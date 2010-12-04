package com.tnes;

import com.tnes.Constants;
import com.tnes.MMC;

public class PPU {
	private MMC mmc; 
	private byte nameTableMirroring;
	private byte controlReg1, controlReg2, status;
	private int spriteMemAddr, ppuMemAddr;
	private byte verticalScrollReg, horizontalScrollReg;
	private byte[][] screenBuffer = new byte[241][256];
	private byte scanline;
	private int elapsedCycles;
	private boolean frameComplete;
	
	public PPU(MMC mmc) {
		this.mmc = mmc;
	}
	
	public MMC getMMC() {
		return mmc;
	}
	
	public void setMMC(MMC mmc) {
		this.mmc = mmc;
	}
	
	public byte getNameTableMirroring() {
		return nameTableMirroring;
	}
	
	public void setNameTableMirroring(byte nameTableMirroring) {
		this.nameTableMirroring = nameTableMirroring;
	}
	
	public byte getControlReg1() {
		return controlReg1;
	}
	
	public void setControlReg1(byte controlReg1) {
		this.controlReg1 = controlReg1;
	}
	
	public byte getControlReg2() {
		return controlReg2;
	}
	
	public void setControlReg2(byte controlReg2) {
		this.controlReg2 = controlReg2;
	}
	
	public byte getStatus() {
		return status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
	
	public int getSpriteMemAddr() {
		return spriteMemAddr;
	}
	
	public void setSpriteMemAddr(int spriteMemAddr) {
		this.spriteMemAddr = spriteMemAddr;
	}
	
	public int getPPUMemAddr() {
		return ppuMemAddr;
	}
	
	public void setPPUMemAddr(int ppuMemAddr) {
		this.ppuMemAddr = ppuMemAddr;
	}

	public byte getVerticalScrollReg() {
		return verticalScrollReg;
	}
	
	public void setVerticalScrollReg(byte verticalScrollReg) {
		this.verticalScrollReg = verticalScrollReg;
	}
	
	public byte getHorizontalScrollReg() {
		return horizontalScrollReg;
	}
	
	public void setHorizontalScrollReg(byte horizontalScrollReg) {
		this.horizontalScrollReg = horizontalScrollReg;
	}
	
	public byte[][] getScreenBuffer() {
		return screenBuffer;
	}
	
	public byte getScanline() {
		return scanline;
	}
	
	public int getElapsedCycles() {
		return elapsedCycles;
	}
	
	public boolean isFrameComplete() {
		return frameComplete;
	}
	
	public boolean isVerticalRWFlagSet() {
	    // Vertical Read: PPU Address increments by 32 on read or write
	    return ((controlReg1 & Constants.PPU_CTRL_1_VERTICAL_WRITE) != 0) ? true : false;
	}
}
