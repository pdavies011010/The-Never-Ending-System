package com.tnes;

import java.util.Iterator;
import java.util.List;

public class NES {
	private Debugger debugger = Debugger.getInstance();
	private MMC mmc;
	private CPU cpu;
	private PPU ppu;
	private String romFilePath;
	private ROMFile romFile;
	private boolean poweredOn = false;

	public NES() {
		romFile = null;
		poweredOn = false;
	}
	
	public boolean isPoweredOn() {
		return poweredOn;
	}

	/*
	 * NES logic
	 */
	public void loadROM(String romFilePath) {
		this.romFilePath = romFilePath;
	}

	public void powerOn() {
		mmc = new MMC();
		cpu = new CPU(mmc);
		ppu = new PPU(mmc);

		/*
		 * MMC needs access to the CPU / PPU for access to registers via IO
		 * ports, and to allow it to generate NMI's etc.
		 */
		mmc.setCPU(cpu);
		mmc.setPPU(ppu);

		// Load up ROM
		romFile = new ROMFile(romFilePath);

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
	}
	
	public void runOneFrame() {
		ppu.preFrame();
		
		while (!ppu.isFrameComplete()) {
			int cycles = cpu.execute();
			
			// CPU CC = PPU CC / 3
			ppu.execute(cycles * 3);
		}
		
		ppu.setFrameComplete(false);
	}
	
	private List<Short> splitList(List<Short> list, int index) {
		if (index == 0)
			return list.subList(0, ((list.size() / 2) - 1));
		else if (index == 1) 
			return list.subList((list.size() / 2), list.size() - 1);
		
		return null;
	}
}
