package com.tnes;

import com.tnes.Constants;
import com.tnes.CPU;
import com.tnes.PPU;
import com.tnes.Debugger;
import java.lang.reflect.Method;

public class MMC {
	private CPU cpu;
	private PPU ppu;
	private Debugger debugger = Debugger.getInstance();

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
		
		// Add MMC commands to the debugger
		addDebugCommands();
	}

	public CPU getCPU() {
		return cpu;
	}

	public void setCPU(CPU cpu) {
		this.cpu = cpu;
	}

	public PPU getPPU() {
		return ppu;
	}

	public void setPPU(PPU ppu) {
		this.ppu = ppu;
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

	public byte readCPUMem(int address) {
		byte result = 0;

		if (address >= Constants.CPU_RAM_LO && address <= Constants.CPU_RAM_HI) {
			// Read from CPU RAM
			// Handle mirroring
			int ramMirror = address / Constants.CPU_RAM_SIZE;
			int trueAddress = address - (Constants.CPU_RAM_SIZE * ramMirror);
			result = cpuRam[trueAddress];
		} else if (address >= Constants.IO_LO && address <= Constants.IO_HI) {
			// Read from IO ports
			// Handle port mirroring
			int trueAddress;
			if (address <= Constants.PPU_PORT_HI) {
				// PPU Ports
				int portMirror = (address - Constants.PPU_PORT_LO) / Constants.PPU_PORT_SIZE;
				trueAddress = address - (Constants.PPU_PORT_SIZE * portMirror);
			} else {
				// Other Ports (APU mostly)
				int portMirror = (address - Constants.OTHER_PORT_LO) / Constants.OTHER_PORT_SIZE;
				trueAddress = address - (Constants.OTHER_PORT_SIZE * portMirror);
			}

			if (trueAddress == Constants.PPU_CONTROL_REG_1_PORT)
				result = ppu.getControlReg1();
			else if (trueAddress == Constants.PPU_CONTROL_REG_2_PORT)
				result = ppu.getControlReg2();
			else if (trueAddress == Constants.PPU_STATUS_REG_PORT) {
				byte status = ppu.getStatus();
				result = status;
				// Clear VBLANK flag on read
				ppu.setStatus((byte) (status & (~Constants.PPU_STAT_VBLANK)));
			} else if (trueAddress == Constants.PPU_SPRITE_MEM_DATA_PORT) {
				result = spriteMem[ppu.getSpriteMemAddr()];
				ppu.setSpriteMemAddr(ppu.getSpriteMemAddr() + 1);
			} else if (trueAddress == Constants.PPU_MEM_DATA_PORT) {
				result = readPPUMem(ppu.getPPUMemAddr());

				if (ppu.isVerticalRWFlagSet()) {
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() + 32);
				} else {
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() + 1);
				}
			} else if (trueAddress == Constants.JOYSTICK_1_PORT) {
				result = (byte) (0x40 | (joystick1LatchKeys & 0x01));
				joystick1LatchKeys >>= 1;
			} else if (trueAddress == Constants.JOYSTICK_2_PORT) {
				result = (byte) (0x40 | (joystick2LatchKeys & 0x01));
				joystick2LatchKeys >>= 1;
			}
		} else if (address >= Constants.EXPANSION_MODULES_LO && address <= Constants.EXPANSION_MODULES_HI) {
			// Read from expansion modules
		} else if (address >= Constants.CARTRIDGE_RAM_LO && address <= Constants.CARTRIDGE_RAM_HI) {
			// Read from cartridge ram
			result = cartridgeRam[address - Constants.CARTRIDGE_RAM_LO];
		} else if (address >= Constants.CARTRIDGE_ROM_LOW_BANK_LO && address <= Constants.CARTRIDGE_ROM_LOW_BANK_HI) {
			// Read from cartridge low bank
			result = cartridgeBankLo[address - Constants.CARTRIDGE_ROM_LOW_BANK_LO];
		} else if (address >= Constants.CARTRIDGE_ROM_HIGH_BANK_LO && address <= Constants.CARTRIDGE_ROM_HIGH_BANK_HI) {
			// Read from cartridge high bank
			result = cartridgeBankHi[address - Constants.CARTRIDGE_ROM_HIGH_BANK_LO];
		}

		return result;
	}

	public byte readCPUMemSafe(int address) {
		byte result = 0;

		if (address >= Constants.IO_LO && address <= Constants.IO_HI) {
			// Read from IO ports
			// Handle port mirroring
			int trueAddress;
			if (address <= Constants.PPU_PORT_HI) {
				// PPU Ports
				int portMirror = (address - Constants.PPU_PORT_LO) / Constants.PPU_PORT_SIZE;
				trueAddress = address - (Constants.PPU_PORT_SIZE * portMirror);
			} else {
				// Other Ports (APU mostly)
				int portMirror = (address - Constants.OTHER_PORT_LO) / Constants.OTHER_PORT_SIZE;
				trueAddress = address - (Constants.OTHER_PORT_SIZE * portMirror);
			}

			if (trueAddress == Constants.PPU_CONTROL_REG_1_PORT)
				result = ppu.getControlReg1();
			else if (trueAddress == Constants.PPU_CONTROL_REG_2_PORT)
				result = ppu.getControlReg2();
			else if (trueAddress == Constants.PPU_STATUS_REG_PORT)
				result = ppu.getStatus();
			else if (trueAddress == Constants.PPU_SPRITE_MEM_DATA_PORT)
				result = spriteMem[ppu.getSpriteMemAddr()];
			else if (trueAddress == Constants.PPU_MEM_DATA_PORT)
				result = readPPUMem(ppu.getPPUMemAddr());
			else if (trueAddress == Constants.JOYSTICK_1_PORT)
				result = joystick1LatchKeys;
			else if (trueAddress == Constants.JOYSTICK_2_PORT)
				result = joystick2LatchKeys;
		} else {
			result = readCPUMem(address);
		}

		return result;
	}

	public void writeCPUMem(int address, byte value) {
		if (address >= Constants.CPU_RAM_LO && address <= Constants.CPU_RAM_HI) {
			// Write into CPU RAM
			// Handle mirroring
			int ramMirror = address / Constants.CPU_RAM_SIZE;
			int trueAddress = address - (Constants.CPU_RAM_SIZE * ramMirror);
			cpuRam[trueAddress] = value;
		} else if (address >= Constants.IO_LO && address <= Constants.IO_HI) {
			// Write into IO ports
			// Handle port mirroring
			int trueAddress;
			if (address <= Constants.PPU_PORT_HI) {
				// PPU Ports
				int portMirror = (address - Constants.PPU_PORT_LO) / Constants.PPU_PORT_SIZE;
				trueAddress = address - (Constants.PPU_PORT_SIZE * portMirror);
			} else {
				// Other Ports (APU mostly)
				int portMirror = (address - Constants.OTHER_PORT_LO) / Constants.OTHER_PORT_SIZE;
				trueAddress = address - (Constants.OTHER_PORT_SIZE * portMirror);
			}

			if (trueAddress == Constants.PPU_CONTROL_REG_1_PORT)
				ppu.setControlReg1(value);
			else if (trueAddress == Constants.PPU_CONTROL_REG_2_PORT) {
				ppu.setControlReg2(value);
				// Recalculate background color
				ppu.updateBackgroundColor();
			} else if (trueAddress == Constants.PPU_SPRITE_MEM_ADDRESS_PORT)
				ppu.setSpriteMemAddr(value);
			else if (trueAddress == Constants.PPU_SPRITE_MEM_DATA_PORT) {
				spriteMem[ppu.getSpriteMemAddr()] = value;
				ppu.setSpriteMemAddr(ppu.getSpriteMemAddr() + 1);
			} else if (trueAddress == Constants.PPU_SCREEN_SCROLL_OFFSET_PORT) {
				if (!screenScrollRegSwitch) {
					// Set Vertical Scroll Register
					if (value <= 239)
						ppu.setVerticalScrollReg(value);
				} else {
					// Set Horizontal Scroll Register
					ppu.setHorizontalScrollReg(value);
				}
				// Toggle switch
				screenScrollRegSwitch = !screenScrollRegSwitch;
			} else if (trueAddress == Constants.PPU_MEM_ADDRESS_PORT) {
				if (!ppuMemAddressRegSwitch) {
					// Reset the PPU memory address register
					ppu.setPPUMemAddr(0);

					// Set high 6 bits of PPU Memory address register
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() | ((value & 0x3F) << 8));
				} else {
					// Set low 8 bits of PPU Memory address register
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() | value);
				}

				// Toggle switch
				ppuMemAddressRegSwitch = (!ppuMemAddressRegSwitch);
			} else if (trueAddress == Constants.PPU_MEM_DATA_PORT) {
				writePPUMem(ppu.getPPUMemAddr(), value);
				debugger.debugPrint(String.format("\nWriting %s to PPU address %s", Debugger.byteToHex(value), Debugger.intToHex(ppu.getPPUMemAddr())));
				if (ppu.isVerticalRWFlagSet())
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() + 32);
				else
					ppu.setPPUMemAddr(ppu.getPPUMemAddr() + 1);
			} else if (trueAddress == Constants.PPU_SPRITE_DMA_PORT) {
				// Sprite RAM DMA - Transfer 256 bytes of data from CPU mem to
				// Sprite RAM
				// from location at (0x100 * value)
				int startAddress = value * 0x100;
				int endAddress = startAddress + 0x100;
				for (int i = startAddress; i < endAddress; i++) {
					spriteMem[i - startAddress] = readCPUMem(i);
				}
			} else if (trueAddress == Constants.JOYSTICK_1_PORT) {
				if (value == 1) {
					joystickLatchStarted = true;
				} else if (value == 0 && joystickLatchStarted) {
					joystickLatchStarted = false;
					joystick1LatchKeys = joystick1Keys;
					joystick2LatchKeys = joystick2Keys;
					joystick1Keys = 0;
					joystick2Keys = 0;
				}
			}
		} else if (address >= Constants.EXPANSION_MODULES_LO && address <= Constants.EXPANSION_MODULES_HI) {
			// Write into expansion modules
		} else if (address >= Constants.CARTRIDGE_RAM_LO && address <= Constants.CARTRIDGE_RAM_HI) {
			// Write into cartridge ram
			cartridgeRam[address - Constants.CARTRIDGE_RAM_LO] = value;
		} else if (address >= Constants.CARTRIDGE_ROM_LOW_BANK_LO && address <= Constants.CARTRIDGE_ROM_LOW_BANK_HI) {
			// Write into cartridge low bank???
			// @cartridge_bank_low[address - CARTRIDGE_ROM_LOW_BANK_LO] = value
		} else if (address >= Constants.CARTRIDGE_ROM_HIGH_BANK_LO && address <= Constants.CARTRIDGE_ROM_HIGH_BANK_HI) {
			// Write into cartridge high bank???
			// @cartridge_bank_high[address - CARTRIDGE_ROM_HIGH_BANK_LO] =
			// value
		}
	}

	public byte readPPUMem(int address) {
		byte result = 0;

		if (address >= Constants.PATTERN_TABLE_0_LO && address <= Constants.PATTERN_TABLE_0_HI)
			result = patternTable0[address];
		else if (address >= Constants.PATTERN_TABLE_1_LO && address <= Constants.PATTERN_TABLE_1_HI)
			result = patternTable1[address - Constants.PATTERN_TABLE_1_LO];
		else if (address >= Constants.NAME_TABLE_0_LO && address <= Constants.NAME_TABLE_0_HI)
			result = nameTable0[address - Constants.NAME_TABLE_0_LO];
		else if (address >= Constants.ATTRIBUTE_TABLE_0_LO && address <= Constants.ATTRIBUTE_TABLE_0_HI)
			result = attributeTable0[address - Constants.ATTRIBUTE_TABLE_0_LO];
		else if (address >= Constants.NAME_TABLE_1_LO && address <= Constants.NAME_TABLE_1_HI)
			result = nameTable1[address - Constants.NAME_TABLE_1_LO];
		else if (address >= Constants.ATTRIBUTE_TABLE_1_LO && address <= Constants.ATTRIBUTE_TABLE_1_HI)
			result = attributeTable1[address - Constants.ATTRIBUTE_TABLE_1_LO];
		else if (address >= Constants.NAME_TABLE_2_LO && address <= Constants.NAME_TABLE_2_HI)
			result = nameTable2[address - Constants.NAME_TABLE_2_LO];
		else if (address >= Constants.ATTRIBUTE_TABLE_2_LO && address <= Constants.ATTRIBUTE_TABLE_2_HI)
			result = attributeTable2[address - Constants.ATTRIBUTE_TABLE_2_LO];
		else if (address >= Constants.NAME_TABLE_3_LO && address <= Constants.NAME_TABLE_3_HI)
			result = nameTable3[address - Constants.NAME_TABLE_3_LO];
		else if (address >= Constants.ATTRIBUTE_TABLE_3_LO && address <= Constants.ATTRIBUTE_TABLE_3_HI)
			result = attributeTable3[address - Constants.ATTRIBUTE_TABLE_3_LO];
		else if (address >= Constants.IMAGE_PALETTE_LO && address <= Constants.IMAGE_PALETTE_HI)
			result = imagePalette[address - Constants.IMAGE_PALETTE_LO];
		else if (address >= Constants.SPRITE_PALETTE_LO && address <= Constants.SPRITE_PALETTE_HI)
			result = spritePalette[address - Constants.SPRITE_PALETTE_LO];

		return result;
	}

	public void writePPUMem(int address, byte value) {
		if (address >= Constants.PATTERN_TABLE_0_LO && address <= Constants.PATTERN_TABLE_0_HI && isPatternTable0Writable())
			patternTable0[address] = value;
		else if (address >= Constants.PATTERN_TABLE_1_LO && address <= Constants.PATTERN_TABLE_1_HI && isPatternTable1Writable())
			patternTable1[address - Constants.PATTERN_TABLE_1_LO] = value;
		else if (address >= Constants.NAME_TABLE_0_LO && address <= Constants.NAME_TABLE_0_HI)
			nameTable0[address - Constants.NAME_TABLE_0_LO] = value;
		else if (address >= Constants.ATTRIBUTE_TABLE_0_LO && address <= Constants.ATTRIBUTE_TABLE_0_HI)
			attributeTable0[address - Constants.ATTRIBUTE_TABLE_0_LO] = value;
		else if (address >= Constants.NAME_TABLE_1_LO && address <= Constants.NAME_TABLE_1_HI)
			nameTable1[address - Constants.NAME_TABLE_1_LO] = value;
		else if (address >= Constants.ATTRIBUTE_TABLE_1_LO && address <= Constants.ATTRIBUTE_TABLE_1_HI)
			attributeTable1[address - Constants.ATTRIBUTE_TABLE_1_LO] = value;
		else if (address >= Constants.NAME_TABLE_2_LO && address <= Constants.NAME_TABLE_2_HI)
			nameTable2[address - Constants.NAME_TABLE_2_LO] = value;
		else if (address >= Constants.ATTRIBUTE_TABLE_2_LO && address <= Constants.ATTRIBUTE_TABLE_2_HI)
			attributeTable2[address - Constants.ATTRIBUTE_TABLE_2_LO] = value;
		else if (address >= Constants.NAME_TABLE_3_LO && address <= Constants.NAME_TABLE_3_HI)
			nameTable3[address - Constants.NAME_TABLE_3_LO] = value;
		else if (address >= Constants.ATTRIBUTE_TABLE_3_LO && address <= Constants.ATTRIBUTE_TABLE_3_HI)
			attributeTable3[address - Constants.ATTRIBUTE_TABLE_3_LO] = value;
		else if (address >= Constants.IMAGE_PALETTE_LO && address <= Constants.IMAGE_PALETTE_HI)
			imagePalette[address - Constants.IMAGE_PALETTE_LO] = value;
		else if (address >= Constants.SPRITE_PALETTE_LO && address <= Constants.SPRITE_PALETTE_HI)
			spritePalette[address - Constants.SPRITE_PALETTE_LO] = value;
	}

	private void addDebugCommands() {
		try {
			debugger.addCommand("getCPUMem", MMC.class.getMethod("__getCPUMem", String.class), this);
			debugger.addCommand("setCPUMem", MMC.class.getMethod("__setCPUMem", String.class), this);
			debugger.addCommand("getCPUMemBlock", MMC.class.getMethod("__getCPUMemBlock", String.class), this);
			debugger.addCommand("getPPUMem", MMC.class.getMethod("__getPPUMem", String.class), this);
			debugger.addCommand("setPPUMem", MMC.class.getMethod("__setPPUMem", String.class), this);
			debugger.addCommand("getPPUMemBlock", MMC.class.getMethod("__getPPUMemBlock", String.class), this);
			debugger.addCommand("getSpriteMem", MMC.class.getMethod("__getSpriteMem", String.class), this);
			debugger.addCommand("setSpriteMem", MMC.class.getMethod("__setSpriteMem", String.class), this);
			debugger.addCommand("getSpriteMemBlock", MMC.class.getMethod("__getSpriteMemBlock", String.class), this);

		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Debugger methods
	 */
	public void __getCPUMem(String param) {
		int address = Integer.parseInt(param);
		debugger.debugPrint(Debugger.byteToHex(readCPUMemSafe(address)) + "\n");
	}

	public void __setCPUMem(String param) {
		int address = Debugger.hexToInt(param.split(",")[0]);
		byte value = Debugger.hexToByte(param.split(",")[1]);
		writeCPUMem(address, value);
	}

	public void __getCPUMemBlock(String param) {
		int address0 = Debugger.hexToInt(param.split(",")[0]);
		int address1 = Debugger.hexToInt(param.split(",")[1]);

		debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(address0)));
		for (int i = address0; i <= address1; i++) {
			if (i % 16 == 0 && i != address0)
				debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(i)));

			debugger.debugPrint(String.format(" %s", Debugger.byteToHex(readCPUMemSafe(i))));
		}
	}

	public void __getPPUMem(String param) {
		int address = Integer.parseInt(param);
		debugger.debugPrint(Debugger.byteToHex(readPPUMem(address)) + "\n");
	}

	public void __setPPUMem(String param) {
		int address = Debugger.hexToInt(param.split(",")[0]);
		byte value = Debugger.hexToByte(param.split(",")[1]);
		writePPUMem(address, value);
	}

	public void __getPPUMemBlock(String param) {
		int address0 = Debugger.hexToInt(param.split(",")[0]);
		int address1 = Debugger.hexToInt(param.split(",")[1]);

		debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(address0)));
		for (int i = address0; i <= address1; i++) {
			if (i % 16 == 0 && i != address0)
				debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(i)));

			debugger.debugPrint(String.format(" %s", Debugger.byteToHex(readPPUMem(i))));
		}
	}

	public void __getSpriteMem(String param) {
		int address = Integer.parseInt(param);
		debugger.debugPrint(Debugger.byteToHex(spriteMem[address]) + "\n");
	}

	public void __setSpriteMem(String param) {
		int address = Debugger.hexToInt(param.split(",")[0]);
		byte value = Debugger.hexToByte(param.split(",")[1]);
		spriteMem[address] = value;
	}

	public void __getSpriteMemBlock(String param) {
		int address0 = Debugger.hexToInt(param.split(",")[0]);
		int address1 = Debugger.hexToInt(param.split(",")[1]);

		debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(address0)));
		for (int i = address0; i <= address1; i++) {
			if (i % 16 == 0 && i != address0)
				debugger.debugPrint(String.format("\n%s:", Debugger.intToHex(i)));

			debugger.debugPrint(String.format(" %s", Debugger.byteToHex(spriteMem[i])));
		}
	}
}
