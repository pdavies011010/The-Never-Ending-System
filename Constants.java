package com.tnes;

public class Constants {
	/* 
	* *******
	* ******* NES Constants **********
	* *******
	*/
	public static int NMIB_LO  =  0xFFFA;
	public static int NMIB_HI = 0xFFFB;
	public static int RESET_LO = 0xFFFC;
	public static int RESET_HI = 0xFFFD;
	public static int IRQ_BRK_LO = 0xFFFE;
	public static int IRQ_BRK_HI = 0xFFFF;

	public static int PRG_ROM_PAGE_SIZE = 0x4000;
	public static int CHR_ROM_PAGE_SIZE = 0x2000;

	/* 
	* ******
	* ******** CPU Constants ************
	* *******
	*/
	// CPU Memory map
	public static int CPU_RAM_SIZE = 0x0800;  // 2kB
	public static short CPU_RAM_PAGE_SIZE = 0xFF;  // 256 B
	public static int CARTRIDGE_RAM_SIZE = 0x1FFF;
	public static int CARTRIDGE_BANK_SIZE = 0x4000;
	public static short PPU_PORT_SIZE = 0x08;
	public static short OTHER_PORT_SIZE = 0x18;

	public static int CPU_RAM_LO = 0x0000;
	public static int CPU_RAM_HI = 0x1FFF;
	public static int CPU_ZERO_PAGE_LO = 0x0000;
	public static int CPU_ZERO_PAGE_HI = 0x00FF;
	public static int CPU_STACK_LO = 0x0100;
	public static int CPU_STACK_HI = 0x01FF;
	public static int IO_LO = 0x2000;
	public static int IO_HI = 0x4FFF;
	public static int PPU_PORT_LO = 0x2000;
	public static int PPU_PORT_HI = 0x3FFF;
	public static int OTHER_PORT_LO = 0x4000;  // Other Ports (APU mostly)
	public static int OTHER_PORT_HI = 0x4FFF;
	public static int EXPANSION_MODULES_LO = 0x5000;
	public static int EXPANSION_MODULES_HI = 0x5FFF;
	public static int CARTRIDGE_RAM_LO = 0x6000;
	public static int CARTRIDGE_RAM_HI = 0x7FFF;
	public static int CARTRIDGE_ROM_LOW_BANK_LO = 0x8000;
	public static int CARTRIDGE_ROM_LOW_BANK_HI = 0xBFFF;
	public static int CARTRIDGE_ROM_HIGH_BANK_LO = 0xC000;
	public static int CARTRIDGE_ROM_HIGH_BANK_HI = 0xFFFF;

	public static int PPU_CONTROL_REG_1_PORT = 0x2000;
	public static int PPU_CONTROL_REG_2_PORT = 0x2001;
	public static int PPU_STATUS_REG_PORT = 0x2002;
	public static int PPU_SPRITE_MEM_ADDRESS_PORT = 0x2003;
	public static int PPU_SPRITE_MEM_DATA_PORT = 0x2004;
	public static int PPU_SCREEN_SCROLL_OFFSET_PORT = 0x2005;
	public static int PPU_MEM_ADDRESS_PORT = 0x2006;
	public static int PPU_MEM_DATA_PORT = 0x2007;
	public static int PPU_SPRITE_DMA_PORT = 0x4014;

	public static int APU_SOUND_CHANNEL_SWITCH_PORT = 0x4015;

	public static int JOYSTICK_1_PORT = 0x4016;
	public static int JOYSTICK_2_PORT = 0x4017;

	/*
	*  Status Flags
	*/
	public static short CPU_STAT_NEGATIVE = 0x80;
	public static short CPU_STAT_OVERFLOW = 0x40;
	public static short CPU_STAT_BREAK = 0x10;
	public static short CPU_STAT_DECIMAL = 0x08;
	public static short CPU_STAT_INTERRUPT_DISABLE = 0x04;
	public static short CPU_STAT_ZERO = 0x02;
	public static short CPU_STAT_CARRY = 0x01;


	/* 
	* ******
	* ******** PPU Constants ************
	* *******
	*/
	public static int PPU_MEM_LO = 0x0000;
	public static int PPU_MEM_HI = 0x3FFF;
	public static int PPU_MEM_SIZE = 0x4000;

	public static int PATTERN_TABLE_SIZE = 0x1000;
	public static int NAME_TABLE_SIZE = 0x03C0;
	public static int ATTRIBUTE_TABLE_SIZE = 0x0040;
	public static int PALETTE_SIZE = 0x0010;
	public static int SPRITE_MEM_SIZE  =  0x100;

	public static int PATTERN_TABLE_0_LO = 0x0000;
	public static int PATTERN_TABLE_0_HI = 0x0FFF; // 4kB
	public static int PATTERN_TABLE_1_LO = 0x1000;
	public static int PATTERN_TABLE_1_HI = 0x1FFF; // 4kB
	public static int NAME_TABLE_0_LO = 0x2000;
	public static int NAME_TABLE_0_HI = 0x23BF;
	public static int ATTRIBUTE_TABLE_0_LO = 0x23C0;
	public static int ATTRIBUTE_TABLE_0_HI = 0x23FF;
	public static int NAME_TABLE_1_LO = 0x2400;
	public static int NAME_TABLE_1_HI = 0x27BF;
	public static int ATTRIBUTE_TABLE_1_LO = 0x27C0;
	public static int ATTRIBUTE_TABLE_1_HI = 0x27FF;
	public static int NAME_TABLE_2_LO = 0x2800;
	public static int NAME_TABLE_2_HI = 0x2BBF;
	public static int ATTRIBUTE_TABLE_2_LO = 0x2BC0;
	public static int ATTRIBUTE_TABLE_2_HI = 0x2BFF;
	public static int NAME_TABLE_3_LO = 0x2C00;
	public static int NAME_TABLE_3_HI = 0x2FBF;
	public static int ATTRIBUTE_TABLE_3_LO = 0x2FC0;
	public static int ATTRIBUTE_TABLE_3_HI = 0x2FFF;
	public static int IMAGE_PALETTE_LO = 0x3F00;
	public static int IMAGE_PALETTE_HI = 0x3F0F;
	public static int SPRITE_PALETTE_LO = 0x3F10;
	public static int SPRITE_PALETTE_HI = 0x3F1F;
	public static short SPRITE_MEM_LO = 0x00;
	public static short SPRITE_MEM_HI = 0xFF;

	/*
	*  Status Flag
	*/
	public static short PPU_STAT_HIT = 0x40;
	public static short PPU_STAT_VBLANK = 0x80;

	/*
	*  Control Register Flags
	*/
	public static short PPU_CTRL_1_NAME_TABLE_LO = 0x01;
	public static short PPU_CTRL_1_NAME_TABLE_HI = 0x02;
	public static short PPU_CTRL_1_NAME_TABLE_MASK = 0x03;
	public static short PPU_CTRL_1_VERTICAL_WRITE = 0x04;
	public static short PPU_CTRL_1_SPRITE_PATTERN_TABLE_ADDRESS = 0x08;
	public static short PPU_CTRL_1_SCREEN_PATTERN_TABLE_ADDRESS = 0x10;
	public static short PPU_CTRL_1_SPRITE_SIZE = 0x20;
	public static short PPU_CTRL_1_VBLANK_ENABLE = 0x80;

	public static short PPU_CTRL_2_IMAGE_MASK = 0x02;
	public static short PPU_CTRL_2_SPRITE_MASK = 0x04;
	public static short PPU_CTRL_2_SCREEN_ENABLE = 0x08;
	public static short PPU_CTRL_2_SPRITE_ENABLE = 0x10;
	public static short PPU_CTRL_2_BKG_COLOR_LO = 0x20;
	public static short PPU_CTRL_2_BKG_COLOR_HI = 0x80;
	public static short PPU_CTRL_2_BKG_COLOR_MASK = 0xE0;

	public static int SCANLINE_CYCLES = 341;

	/*
	*  Joystick Constants
	*/
	public static short JOYSTICK_A = 0x01;
	public static short JOYSTICK_B = 0x02;
	public static short JOYSTICK_SELECT = 0x04;
	public static short JOYSTICK_START = 0x08;
	public static short JOYSTICK_UP = 0x10;
	public static short JOYSTICK_DOWN = 0x20;
	public static short JOYSTICK_LEFT = 0x40;
	public static short JOYSTICK_RIGHT = 0x80;
}