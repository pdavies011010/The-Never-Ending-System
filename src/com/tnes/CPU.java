package com.tnes;

import com.tnes.Constants;
import com.tnes.MMC;
import com.tnes.CpuTables;
import com.tnes.Opcode;
import com.tnes.Operation;
import com.tnes.Debugger;
import java.util.*;

public class CPU {
	private MMC mmc;
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

	private void addDebugCommands() {
		try {
			debugger.addCommand("go", MMC.class.getMethod("__go", String.class), this);
			debugger.addCommand("step", MMC.class.getMethod("__step", String.class), this);
			debugger.addCommand("setBreakpoint", MMC.class.getMethod("__setBreakpoint", String.class), this);
			debugger.addCommand("clearBreakpoint", MMC.class.getMethod("__clearBreakpoint", String.class), this);
			debugger.addCommand("clearBreakpoints", MMC.class.getMethod("__clearBreakpoints", String.class), this);

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
		this.breakpoints.add(new Integer(Debugger.hextToInt(param)));
	}
	
	public void __clearBreakpoint(String param) {
		this.breakpoints.remove(new Integer(Debugger.hextToInt(param)));
	}
	
	public void __clearBreakpoints(String param) {
		this.breakpoints.clear();
	}
}
