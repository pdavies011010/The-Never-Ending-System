package com.tnes;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NES {
	private Debugger debugger = Debugger.getInstance();
	private MMC mmc;
	private CPU cpu;
	private PPU ppu;
	private ROMFile romFile;
	private boolean poweredOn = false;
	private Map<Class<? extends NESEvent>, List<INESHandler>> eventHandlers;
	private MainThread mainThread = new MainThread();

	public NES() {
		romFile = null;
		poweredOn = false;

		eventHandlers = new HashMap<Class<? extends NESEvent>, List<INESHandler>>();

		addDebugCommands();

		new Thread(mainThread).start();
	}

	public boolean isPoweredOn() {
		return poweredOn;
	}

	public ROMFile getROMFile() {
		return romFile;
	}

	/*
	 * NES logic
	 */
	public void loadROM(String romFilePath) {
		// Load up ROM
		romFile = new ROMFile(romFilePath);

		// Raise a power on event
		raiseEvent(new ROMLoadEvent(this, romFilePath));
	}

	public void reset() {
		cpu.reset();

		// Raise a reset event
		raiseEvent(new ResetEvent(this));
	}

	public void powerOn() {
		if (romFile == null)
			return;

		mmc = new MMC();
		cpu = new CPU(mmc);
		ppu = new PPU(mmc);

		/*
		 * MMC needs access to the CPU / PPU for access to registers via IO
		 * ports, and to allow it to generate NMI's etc.
		 */
		mmc.setCPU(cpu);
		mmc.setPPU(ppu);

		ppu.setNameTableMirroring((short) romFile.getMirroring());

		if (ppu.getNameTableMirroring() == 0) {
			// Horizontal Mirroring
			mmc.setNameTable1(mmc.getNameTable0());
			mmc.setNameTable3(mmc.getNameTable2());
		} else if (ppu.getNameTableMirroring() == 1) {
			// Vertical Mirroring
			mmc.setNameTable2(mmc.getNameTable0());
			mmc.setNameTable3(mmc.getNameTable1());
		}

		/*
		 * Get PRG / CHR rom pages from ROMFile object into NES Memory map.
		 * Note, this depends on teh mapper in use ...
		 * 
		 * TODO: For now we will assume Mapper #0 !!!. In the future we will
		 * need to implement mapper functionality here, as well as during
		 * runtime
		 */
		if (romFile.getMapper() == 0) {
			Iterator<Short> iter = romFile.getPrgROMPages().get(0).iterator();
			for (int i = 0; iter.hasNext(); i++) {
				Short val = iter.next();
				mmc.getCartridgeBankLo()[i] = val;
			}

			// If there is only one rom page, mirror them
			if (romFile.getPrgPageCount() == 1) {
				mmc.setCartridgeBankHi(mmc.getCartridgeBankLo());
			} else {
				iter = romFile.getPrgROMPages().get(1).iterator();
				for (int i = 0; iter.hasNext(); i++) {
					Short val = iter.next();
					mmc.getCartridgeBankHi()[i] = val;
				}
			}

			/*
			 * Mapper #0 games should always have 1 8Kb CHR-ROM page to map into
			 * the pattern tables
			 */
			List<Short> patTbl0 = splitList(romFile.getChrROMPages().get(0), 0);
			iter = patTbl0.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				Short val = iter.next();
				mmc.getPatternTable0()[i] = val;
			}
			List<Short> patTbl1 = splitList(romFile.getChrROMPages().get(0), 1);
			iter = patTbl1.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				Short val = iter.next();
				mmc.getPatternTable1()[i] = val;
			}
			mmc.setPatternTable0Writable(false);
			mmc.setPatternTable1Writable(false);
		}

		// Rest the CPU
		cpu.reset();

		// Get debug commands if debugging is enabled
		debugger.readCommands();

		poweredOn = true;

		// Raise a power on event
		raiseEvent(new PowerOnEvent(this));
	}

	public void powerOff() {
		poweredOn = false;

		// Raise a power off event
		raiseEvent(new PowerOffEvent(this));
	}

	private void runOneFrame() {
		ppu.preFrame();

		while (!ppu.isFrameComplete()) {
			int cycles = cpu.execute();

			// CPU CC = PPU CC / 3
			ppu.execute(cycles * 3);
		}

		ppu.setFrameComplete(false);

		// Raise a frame complete event
		raiseEvent(new FrameCompleteEvent(this));
	}

	private List<Short> splitList(List<Short> list, int index) {
		if (index == 0)
			return list.subList(0, ((list.size() / 2) - 1));
		else if (index == 1)
			return list.subList((list.size() / 2), list.size() - 1);

		return null;
	}

	/*
	 * Runnable object
	 */
	public class MainThread implements Runnable {
		public void run() {
			while (true) {
				if (poweredOn)
					runOneFrame();
				else {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}

	/*
	 * Manage Event Handlers
	 */
	public void addHandler(Class<? extends NESEvent> eventClass, INESHandler eventHandler) {
		if (this.eventHandlers.get(eventClass) == null)
			this.eventHandlers.put(eventClass, new ArrayList<INESHandler>());

		this.eventHandlers.get(eventClass).add(eventHandler);
	}

	public void removeHandler(Class<? extends NESEvent> eventClass, INESHandler eventHandler) {
		if (this.eventHandlers.get(eventClass) != null) {
			this.eventHandlers.get(eventClass).remove(eventHandler);
		}
	}

	public void removeAllHandlers() {
		this.eventHandlers.clear();
	}

	public void raiseEvent(NESEvent event) {
		List<INESHandler> handlers = this.eventHandlers.get(event.getClass());
		if (handlers != null && !handlers.isEmpty()) {
			for (INESHandler handler : handlers) {
				handler.handleEvent(event);
			}
		}
	}

	/*
	 * Debug commands
	 */
	private void addDebugCommands() {
		try {
			debugger.addCommand("loadROM", NES.class.getMethod("__loadROM", String.class), this);
			debugger.addCommand("powerOn", NES.class.getMethod("__powerOn", String.class), this);
			debugger.addCommand("reset", NES.class.getMethod("__reset", String.class), this);
			debugger.addCommand("stopDebugging", NES.class.getMethod("__stopDebugging", String.class), this);
			debugger.addCommand("quit", NES.class.getMethod("__quit", String.class), this);

		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
	}

	public void __loadROM(String param) {
		loadROM(param);
	}

	public void __powerOn(String param) {
		powerOn();
	}

	public void __reset(String param) {
		cpu.reset();
	}

	public void __stopDebugging(String param) {
		debugger.setDebugging(false);
	}

	public void __quit(String param) {
		System.exit(0);
	}

	/*
	 * Events / interfaces for event handling
	 */
	protected interface INESHandler {
		public void handleEvent(NESEvent e);
	}

	public interface IROMLoadHandler extends INESHandler {
	}

	public interface IResetHandler extends INESHandler {
	}

	public interface IPowerOnHandler extends INESHandler {
	}

	public interface IPowerOffHandler extends INESHandler {
	}

	public interface IFrameCompleteHandler extends INESHandler {
	}

	protected class NESEvent extends EventObject {
		private static final long serialVersionUID = 1L;

		public NESEvent(Object source) {
			super(source);
		}
	}

	public class ROMLoadEvent extends NESEvent {
		private static final long serialVersionUID = 1L;
		private String romFile;

		public ROMLoadEvent(Object source, String romFile) {
			super(source);
			this.romFile = romFile;
		}

		public String getROMFile() {
			return romFile;
		}
	}

	public class ResetEvent extends NESEvent {
		private static final long serialVersionUID = 1L;

		public ResetEvent(Object source) {
			super(source);
		}
	}

	public class PowerOnEvent extends NESEvent {
		private static final long serialVersionUID = 1L;

		public PowerOnEvent(Object source) {
			super(source);
		}
	}

	public class PowerOffEvent extends NESEvent {
		private static final long serialVersionUID = 1L;

		public PowerOffEvent(Object source) {
			super(source);
		}
	}

	public class FrameCompleteEvent extends NESEvent {
		private static final long serialVersionUID = 1L;

		public FrameCompleteEvent(Object source) {
			super(source);
		}
	}
}
