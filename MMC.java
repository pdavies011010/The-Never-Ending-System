package com.tnes;

import com.tnes.Constants;

public class MMC {
	private byte[] cpuRam = new byte[Constants.CPU_RAM_SIZE];
	private byte[] cartridgeRam = new byte[Constants.CARTRIDGE_RAM_SIZE];
	private byte[] cartridgeBankLo = new byte[Constants.CARTRIDGE_BANK_SIZE];
	private byte[] cartridgeBankHi = new byte[Constants.CARTRIDGE_BANK_SIZE];

	public byte[] getCpuRam() {
		return cpuRam;
	}
	
	public byte[] getCartridgeRam() {
		return cartridgeRam;
	}
	
	public byte[] getCartridgeBankLo() {
		return cartridgeBankLo;
	}
	
	public byte[] getCartridgeBankHi() {
		return cartridgeBankHi;
	}
}
