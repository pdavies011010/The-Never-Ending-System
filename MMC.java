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
	
	public boolean isPatternTable0Writable() {
		return patternTable0Writable;
	}
	
	public void setPatternTable0Writable(boolean patternTable0Writable) {
		this.patternTable0Writable = patternTable0Writable;
	}
	
	public boolean isPatternTable1Writable() {
		return patternTable1Writable;
	}
	
	public void setPatternTable1Writable(boolean patternTable1Writable) {
		this.patternTable1Writable = patternTable1Writable;
	}
	
	public boolean getScreenScrollRegSwitch() {
		return screenScrollRegSwitch;
	}
	
	public void setScreenScrollRegSwitch(boolean screenScrollRegSwitch) {
		this.screenScrollRegSwitch = screenScrollRegSwitch;
	}
	
	public boolean getPPUMemAddressRegSwitch() {
		return ppuMemAddressRegSwitch;
	}
	
	public void setPPUMemAddressRegSwitch(boolean ppuMemAddressRegSwitch) {
		this.ppuMemAddressRegSwitch = ppuMemAddressRegSwitch;
	}
	
	public boolean isJoystickLatchStarted() {
		return joystickLatchStarted;
	}
	
	public void setJoystickLatchStarted(boolean joystickLatchStarted) {
		this.joystickLatchStarted = joystickLatchStarted;
	}
	
	public byte getJoystick1Keys() {
		return joystick1Keys;
	}
	
	public void setJoystick1Keys(byte joystick1Keys) {
		this.joystick1Keys = joystick1Keys;
	}
	
	public byte getJoystick2Keys() {
		return joystick2Keys;
	}
	
	public void setJoystick2Keys(byte joystick2Keys) {
		this.joystick2Keys = joystick2Keys;
	}
	
	public byte getJoystick1LatchKeys() {
		return joystick1LatchKeys;
	}
	
	public void setJoystick1LatchKeys(byte joystick1LatchKeys) {
		this.joystick1LatchKeys = joystick1LatchKeys;
	}
	
	public byte getJoystick2LatchKeys() {
		return joystick2LatchKeys;
	}
	
	public void setJoystick2LatchKeys(byte joystick2LatchKeys) {
		this.joystick2LatchKeys = joystick2LatchKeys;
	}
}
