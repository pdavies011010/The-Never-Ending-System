package com.tnes;

public class PPU {
	private Debugger debugger = Debugger.getInstance();
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
	private boolean logPPUState;

	public PPU(MMC mmc) {
		this.mmc = mmc;
		
		controlReg1 = 0;
		controlReg2 = 0x18;
		// TODO: Correct init value?
		status = 0;
		spriteMemAddr = 0;
		nameTableMirroring = 0;
		// TODO: Correct init value?
		verticalScrollReg = 0;
		// TODO: Correct init value?
		horizontalScrollReg = 0;
		ppuMemAddr = 0;
		
		elapsedCycles = 0;
		scanline = 0;
		
		logPPUState = false;
		
		// Palette black
		backgroundColor = 0x0F;
		
		// Frame complete flag must be reset from outside this class
		frameComplete = false;
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
	
	public void setFrameComplete(boolean frameComplete) {
		this.frameComplete = frameComplete;
	}

	public boolean isVerticalRWFlagSet() {
		// Vertical Read: PPU Address increments by 32 on read or write
		return ((controlReg1 & Constants.PPU_CTRL_1_VERTICAL_WRITE) != 0);
	}
	
	public boolean isVBlankEnableFlagSet() {
		return ((controlReg1 & Constants.PPU_CTRL_1_VBLANK_ENABLE) != 0);
	}

	public short getBackgroundColorBits() {
		short result = (short) (controlReg2 >> 5);
		return result;
	}

	public void setBackgroundColorBits(short value) {
		controlReg2 &= ~Constants.PPU_CTRL_2_BKG_COLOR_MASK;
		controlReg2 |= (value << (short) 5);
	}
	
	public void setHitFlag(boolean hitFlag) {
		if (hitFlag)
			status |= Constants.PPU_STAT_HIT;
		else 
			status &= ~Constants.PPU_STAT_HIT;
	}
	
	public void setVBlankFlag(boolean vblankFlag) {
		if (vblankFlag)
			status |= Constants.PPU_STAT_VBLANK;
		else 
			status &= ~Constants.PPU_STAT_VBLANK;
	}
	
	/*
	 * PPU Logic
	 */
	public void execute(int cycles) {
		boolean vblankHit = false;
		int preVBlankCycles = 0;
		
		for (int cycle = 1; cycle < cycles; cycle++) {
			// What scanline are we on?
			scanline = (short) ((cycle + elapsedCycles) / Constants.SCANLINE_CYCLES);
			int scanlineCycle = ((cycle + elapsedCycles) % Constants.SCANLINE_CYCLES);
			int tilePixel = scanlineCycle % 8;
			
			if (scanline < 20) {
				// Do nothing for first 20 scanlines
			} else if (scanline == 20) {
				
			} else if (scanline < 261) {
				
			} else if (scanline == 261) {
				// Again, do nothing
			} else {
				// Frame complete
				vblankHit = true;
				elapsedCycles = 0;
				preVBlankCycles = cycle;
				
				postFrame();
			}
		}
		
		if (vblankHit) {
			elapsedCycles = cycles - preVBlankCycles;
		} else {
			elapsedCycles += cycles;
		}
	}
	
	public void preFrame() {
		/*
		 * Fill the screen with the background color
		 * fillScreenWithBackgroundColor();
		 */
		
		// Clear Sprite #0 hit flag
		setHitFlag(false);
	}
	
	public void postFrame() {
		// Raise the VBlank flag, NMI will be triggered
		setVBlankFlag(true);
		
		// debugger.debugPrint("\nVBlank.");
		if (logPPUState)
			debugger.debugLog("\nVBlank");
		
		// Force CPU Non-maskable interrupt
		if (isVBlankEnableFlagSet())
			mmc.getCPU().NMI();
		
		frameComplete = true;
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
