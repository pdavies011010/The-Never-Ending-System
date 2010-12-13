package com.tnes;

public class NES {
	private MMC mmc;
	private CPU cpu;
	private PPU ppu;
	private String romFilePath;
	private ROMFile romFile;
	private boolean poweredOn = false;

	public NES() {
		poweredOn = false;

	}

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

	}
}
