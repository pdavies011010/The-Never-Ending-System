package com.tnes;

import com.tnes.Constants;
import com.tnes.MMC;
import com.tnes.CpuTables;
import com.tnes.Opcode;
import com.tnes.Operation;

public class CPU {
	private MMC mmc; 
	private byte sp;
	private int pc;
	private byte flags;
	private byte a; 
	private byte x; 
	private byte y;
	private boolean pageBoundaryCrossed = false;
	
	public CPU(MMC mmc) {
		this.mmc = mmc;
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
}
