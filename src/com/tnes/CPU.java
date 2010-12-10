package com.tnes;

import java.util.ArrayList;
import java.util.List;

public class CPU {
	private MMC mmc;
	private CpuTables cpuTables = CpuTables.getInstance();
	private Debugger debugger = Debugger.getInstance();

	private byte sp;
	private int pc;
	private byte flags;
	private byte a;
	private byte x;
	private byte y;
	private boolean pageBoundaryCrossed = false;

	// Debug stuff
	private boolean debugRead = false;
	private boolean step = false;
	private boolean logCPUState = false;
	private List<Integer> breakpoints = new ArrayList<Integer>();

	public CPU(MMC mmc) {
		this.mmc = mmc;

		// CPU is not responsible for initializing the stack
		sp = (byte) 0xFF;

		// Start PC at reset vector
		pc = (mmc.readCPUMem(Constants.RESET_HI) << 8) + mmc.readCPUMem(Constants.RESET_LO);

		// Initialize registers
		a = 0;
		x = 0;
		y = 0;
		// All but the unused flag are cleared to 0
		flags = (byte) 0x20;

		// Debug stuff
		breakpoints = new ArrayList<Integer>();
		step = false;
		logCPUState = false;
		debugRead = false;

		addDebugCommands();
	}

	public MMC getMMC() {
		return mmc;
	}

	public void setMMC(MMC mmc) {
		this.mmc = mmc;
	}

	public byte getSP() {
		return sp;
	}

	public void setSP(byte sp) {
		this.sp = sp;
	}

	public int getPC() {
		return pc;
	}

	public void setPC(int pc) {
		this.pc = pc;
	}

	public byte getFlags() {
		return flags;
	}

	public void setFlags(byte flags) {
		this.flags = flags;
	}

	public byte getA() {
		return a;
	}

	public void setA(byte a) {
		this.a = a;
	}

	public byte getX() {
		return x;
	}

	public void setX(byte x) {
		this.x = x;
	}

	public byte getY() {
		return y;
	}

	public void setY(byte y) {
		this.y = y;
	}

	public boolean isPageBoundaryCrossed() {
		return pageBoundaryCrossed;
	}

	// Status Flag Methods
	// 7 = Sign flag, 6 = Overflow flag, 4 = Break flag, 3 = Decimal mode flag
	// 2 = Interrupt disable flag, 1 = Zero flag, 0 = Carry flag
	public boolean isSignFlagSet() {
		return (flags & Constants.CPU_STAT_NEGATIVE) != 0 ? true : false;
	}

	public void setSignFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_NEGATIVE;
		else
			flags &= ~Constants.CPU_STAT_NEGATIVE;
	}

	public boolean isOverflowFlagSet() {
		return (flags & Constants.CPU_STAT_OVERFLOW) != 0 ? true : false;
	}

	public void setOverflowFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_OVERFLOW;
		else
			flags &= ~Constants.CPU_STAT_OVERFLOW;
	}

	public boolean isBreakFlagSet() {
		return (flags & Constants.CPU_STAT_BREAK) != 0 ? true : false;
	}

	public void setBreakFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_BREAK;
		else
			flags &= ~Constants.CPU_STAT_BREAK;
	}

	public boolean isDecimalFlagSet() {
		return (flags & Constants.CPU_STAT_DECIMAL) != 0 ? true : false;
	}

	public void setDecimalFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_DECIMAL;
		else
			flags &= ~Constants.CPU_STAT_DECIMAL;
	}

	public boolean isInterruptFlagSet() {
		return (flags & Constants.CPU_STAT_INTERRUPT_DISABLE) != 0 ? true : false;
	}

	public void setInterruptFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_INTERRUPT_DISABLE;
		else
			flags &= ~Constants.CPU_STAT_INTERRUPT_DISABLE;
	}

	public boolean isZeroFlagSet() {
		return (flags & Constants.CPU_STAT_ZERO) != 0 ? true : false;
	}

	public void setZeroFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_ZERO;
		else
			flags &= ~Constants.CPU_STAT_ZERO;
	}

	public boolean isCarryFlagSet() {
		return (flags & Constants.CPU_STAT_CARRY) != 0 ? true : false;
	}

	public void setCarryFlag(boolean val) {
		if (val)
			flags |= Constants.CPU_STAT_CARRY;
		else
			flags &= ~Constants.CPU_STAT_CARRY;
	}

	private void addDebugCommands() {
		try {
			debugger.addCommand("go", CPU.class.getMethod("__go", String.class), this);
			debugger.addCommand("step", CPU.class.getMethod("__step", String.class), this);
			debugger.addCommand("setBreakpoint", CPU.class.getMethod("__setBreakpoint", String.class), this);
			debugger.addCommand("clearBreakpoint", CPU.class.getMethod("__clearBreakpoint", String.class), this);
			debugger.addCommand("clearBreakpoints", CPU.class.getMethod("__clearBreakpoints", String.class), this);
			debugger.addCommand("getStackPointer", CPU.class.getMethod("__getStackPointer", String.class), this);
			debugger.addCommand("getProgramCounter", CPU.class.getMethod("__getProgramCounter", String.class), this);
			debugger.addCommand("getProcessorStatus", CPU.class.getMethod("__getProcessorStatus", String.class), this);
			debugger.addCommand("getAccumulator", CPU.class.getMethod("__getAccumulator", String.class), this);
			debugger.addCommand("getX", CPU.class.getMethod("__getX", String.class), this);
			debugger.addCommand("getY", CPU.class.getMethod("__getY", String.class), this);
			debugger.addCommand("setStackPointer", CPU.class.getMethod("__setStackPointer", String.class), this);
			debugger.addCommand("setProgramCounter", CPU.class.getMethod("__setProgramCounter", String.class), this);
			debugger.addCommand("setProcessorStatus", CPU.class.getMethod("__setProcessorStatus", String.class), this);
			debugger.addCommand("setAccumulator", CPU.class.getMethod("__setAccumulator", String.class), this);
			debugger.addCommand("setX", CPU.class.getMethod("__setX", String.class), this);
			debugger.addCommand("setY", CPU.class.getMethod("__setY", String.class), this);
			debugger.addCommand("getCPUState", CPU.class.getMethod("__getCPUState", String.class), this);
			debugger.addCommand("logCPUState", CPU.class.getMethod("__logCPUState", String.class), this);
			debugger.addCommand("enableCPULogging", CPU.class.getMethod("__enableCPULogging", String.class), this);
			debugger.addCommand("disableCPULogging", CPU.class.getMethod("__disableCPULogging", String.class), this);

		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Debugger methods
	 */
	public void __go(String param) {
		step = false;
	}

	public void __step(String param) {
		step = true;
	}

	public void __setBreakpoint(String param) {
		this.breakpoints.add(new Integer(Debugger.hexToInt(param)));
	}

	public void __clearBreakpoint(String param) {
		this.breakpoints.remove(new Integer(Debugger.hexToInt(param)));
	}

	public void __clearBreakpoints(String param) {
		this.breakpoints.clear();
	}

	public void __getStackPointer(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.byteToHex(sp)));
	}

	public void __getProgramCounter(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.intToHex(pc)));
	}

	public void __getProcessorStatus(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.byteToHex(flags)));
	}

	public void __getAccumulator(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.byteToHex(a)));
	}

	public void __getX(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.byteToHex(x)));
	}

	public void __getY(String param) {
		debugger.debugPrint(String.format("\n%s", Debugger.byteToHex(y)));
	}

	public void __setStackPointer(String param) {
		sp = Debugger.hexToByte(param);
	}

	public void __setProgramCounter(String param) {
		pc = Debugger.hexToInt(param);
	}

	public void __setProcessorStatus(String param) {
		flags = Debugger.hexToByte(param);
	}

	public void __setAccumulator(String param) {
		a = Debugger.hexToByte(param);
	}

	public void __setX(String param) {
		x = Debugger.hexToByte(param);
	}

	public void __setY(String param) {
		y = Debugger.hexToByte(param);
	}

	public void __getCPUState(String param) {
		byte opcode = mmc.readCPUMemSafe(pc);
		Operation operation = cpuTables.OPERATIONS.get(opcode);
		AddressingMode addressingMode = cpuTables.ADDRESSING_MODES.get(opcode);

		/*
		 * Address and Data have to be passed in, because reading from the mem
		 * map can change what's in memory.
		 * 
		 * TODO: Note, this was carried over from the ruby version of the app,
		 * not sure if that's still true using readCPUMemSafe
		 */
		int address = Integer.parseInt(param.split(",")[0]);
		byte data = Byte.parseByte(param.split(",")[1]);

		debugger.debugPrint(String.format("\nOperation: %s  Addressing Mode: %s  Address: %s  Data: %s", operation.toString(), addressingMode.toString(), address, data));
		debugger.debugPrint(String.format("\nPC: %s  SP: %s  A: %s  X: %s  Y: %s", Debugger.intToHex(pc), Debugger.byteToHex(sp), Debugger.byteToHex(a), Debugger.byteToHex(x), Debugger.byteToHex(y)));
		debugger.debugPrint(String.format("\nStatus: S-%d  V-%d  B-%d  D-%d  I-%d  Z-%d  C-%d", isSignFlagSet()?1:0, isOverflowFlagSet()?1:0, isBreakFlagSet()?1:0, isDecimalFlagSet()?1:0, isInterruptFlagSet()?1:0, isZeroFlagSet()?1:0, isCarryFlagSet()?1:0));
	}
	
	public void __logCPUState(String param) {
		byte opcode = mmc.readCPUMemSafe(pc);
		Operation operation = cpuTables.OPERATIONS.get(opcode);
		AddressingMode addressingMode = cpuTables.ADDRESSING_MODES.get(opcode);

		/*
		 * Address and Data have to be passed in, because reading from the mem
		 * map can change what's in memory.
		 * 
		 * TODO: Note, this was carried over from the ruby version of the app,
		 * not sure if that's still true using readCPUMemSafe
		 */
		int address = Integer.parseInt(param.split(",")[0]);
		byte data = Byte.parseByte(param.split(",")[1]);

		try {
			debugger.debugLog(String.format("\nOperation: %s  Addressing Mode: %s  Address: %s  Data: %s", operation.toString(), addressingMode.toString(), address, data));
			debugger.debugLog(String.format("\nPC: %s  SP: %s  A: %s  X: %s  Y: %s", Debugger.intToHex(pc), Debugger.byteToHex(sp), Debugger.byteToHex(a), Debugger.byteToHex(x), Debugger.byteToHex(y)));
			debugger.debugLog(String.format("\nStatus: S-%d  V-%d  B-%d  D-%d  I-%d  Z-%d  C-%d", isSignFlagSet()?1:0, isOverflowFlagSet()?1:0, isBreakFlagSet()?1:0, isDecimalFlagSet()?1:0, isInterruptFlagSet()?1:0, isZeroFlagSet()?1:0, isCarryFlagSet()?1:0));
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void __enableCPULogging(String param) {
		logCPUState = true;
	}
	
	public void __disableCPULogging(String param) {
		logCPUState = false;
	}
}
