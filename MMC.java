package com.tnes;

import com.tnes.Constants;

public class MMC {
	private byte[] cpuRam = new byte[Constants.CPU_RAM_SIZE];
	private byte[] cartridgeRam = new byte[Constants.CARTRIDGE_RAM_SIZE];
	private byte[] cartridgeBankLo = new byte[Constants.CARTRIDGE_BANK_SIZE];
	private byte[] cartridgeBankHi = new byte[Constants.CARTRIDGE_BANK_SIZE];

	private byte[] patternTable0 = new byte[Constants.PATTERN_TABLE_SIZE];
	private byte[] patternTable1 = new byte[Constants.PATTERN_TABLE_SIZE];
	private byte[] nameTable0 = new byte[Constants.NAME_TABLE_SIZE];
	private byte[] attributeTable0 = new byte[Constants.ATTRIBUTE_TABLE_SIZE];
	private byte[] nameTable1 = new byte[Constants.NAME_TABLE_SIZE];
	private byte[] attributeTable1 = new byte[Constants.ATTRIBUTE_TABLE_SIZE];
	private byte[] nameTable2 = new byte[Constants.NAME_TABLE_SIZE];
	private byte[] attributeTable2 = new byte[Constants.ATTRIBUTE_TABLE_SIZE];
	private byte[] nameTable3 = new byte[Constants.NAME_TABLE_SIZE];
	private byte[] attributeTable3 = new byte[Constants.ATTRIBUTE_TABLE_SIZE];
	private byte[] imagePalette = new byte[Constants.PALETTE_SIZE];
	private byte[] spritePalette = new byte[Constants.PALETTE_SIZE];
	private byte[] spriteMem = new byte[Constants.SPRITE_MEM_SIZE];
	
	private boolean patternTable0Writable, patternTable1Writable;
	private boolean screenScrollRegSwitch, ppuMemAddressRegSwitch;
	private boolean joystickLatchStarted;
	private byte joystick1Keys, joystick2Keys;
	private byte joystick1LatchKeys, joystick2LatchKeys;
	
	public MMC() {
		patternTable0Writable = false;
		patternTable1Writable = false;
		screenScrollRegSwitch = false;
		ppuMemAddressRegSwitch = false;
		joystickLatchStarted = false;
		joystick1Keys = 0;
		joystick2Keys = 0;
		joystick1LatchKeys = 0;
		joystick2LatchKeys = 0;
	}
	
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
	
	public byte[] getPatternTable0() {
		return patternTable0;
	}
	
	public byte[] getPatternTable1() {
		return patternTable1;
	}
	
	public byte[] getNameTable0() {
		return nameTable0;
	}
	
	public byte[] getAttributeTable0() {
		return attributeTable0;
	}
	
	public byte[] getNameTable1() {
		return nameTable1;
	}
	
	public byte[] getAttributeTable1() {
		return attributeTable1;
	}
	
	public byte[] getNameTable2() {
		return nameTable2;
	}
	
	public byte[] getAttributeTable2() {
		return attributeTable2;
	}
	
	public byte[] getNameTable3() {
		return nameTable3;
	}
	
	public byte[] getAttributeTable3() {
		return attributeTable3;
	}
	
	public byte[] getImagePalette() {
		return imagePalette;
	}
	
	public byte[] getSpritePalette() {
		return spritePalette;
	}
	
	public byte[] getSpriteMem() {
		return spriteMem;
	}
}
