package com.tnes;

public class PPU {
	private MMC mmc;
	private short nameTableMirroring;
	private short controlReg1, controlReg2, status;
	private int spriteMemAddr, ppuMemAddr;
	private short verticalScrollReg, horizontalScrollReg;
	private short[][] screenBuffer = new short[241][256];
	private short scanline;
	private int elapsedCycles;
	private short backgroundColor;
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

	public short getNameTableMirroring() {
		return nameTableMirroring;
	}

	public void setNameTableMirroring(short nameTableMirroring) {
		this.nameTableMirroring = nameTableMirroring;
	}

	public short getControlReg1() {
		return controlReg1;
	}

	public void setControlReg1(short controlReg1) {
		this.controlReg1 = controlReg1;
	}

	public short getControlReg2() {
		return controlReg2;
	}

	public void setControlReg2(short controlReg2) {
		this.controlReg2 = controlReg2;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
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

	public short getVerticalScrollReg() {
		return verticalScrollReg;
	}

	public void setVerticalScrollReg(short verticalScrollReg) {
		this.verticalScrollReg = verticalScrollReg;
	}

	public short getHorizontalScrollReg() {
		return horizontalScrollReg;
	}

	public void setHorizontalScrollReg(short horizontalScrollReg) {
		this.horizontalScrollReg = horizontalScrollReg;
	}

	public short[][] getScreenBuffer() {
		return screenBuffer;
	}

	public short getScanline() {
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

	public short getBackgroundColorBits() {
		short result = (short) (controlReg2 >> 5);
		return result;
	}

	public void set_background_color_bits(short value) {
		controlReg2 &= ~Constants.PPU_CTRL_2_BKG_COLOR_MASK;
		controlReg2 |= (value << (short) 5);
	}

	public void updateBackgroundColor() {
		short color = getBackgroundColorBits();

		// Default to Black
		backgroundColor = 0x0F;
		switch (color) {
		case 0:
			// Palette Black
			backgroundColor = 0x0F;
			break;
		case 1:
			// Palette Blue
			backgroundColor = 0x01;
			break;
		case 2:
			// Palette Green
			backgroundColor = 0x09;
			break;
		case 4:
			// Palette Red
			backgroundColor = 0x06;
			break;
		}
	}
}
