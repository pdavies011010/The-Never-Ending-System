package com.tnes;

public class Opcode {
	// Constant definition of opcodes
	// Instruction OpCodes
	// ADC - Add memory to accumulator with carry
	// * - add 1 cycle if page boundary is crossed
	public static short ADCI = (short) 0x69; // ADC Immediate; 2 shorts, 2
											 // cycles
	public static short ADCZ = (short) 0x65; // ADC Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short ADCZX = (short) 0x75; // ADC Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short ADCA = (short) 0x6D; // ADC Absolute; 3 shorts, 4 cycles
	public static short ADCAX = (short) 0x7D; // ADC Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ADCAY = (short) 0x79; // ADC Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ADCIX = (short) 0x61; // ADC Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short ADCIY = (short) 0x71; // ADC Indirect Post-indexed; 2
											  // shorts, 5
	// cycles *

	// AND - "AND" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short ANDI = (short) 0x29; // AND Immediate; 2 shorts, 2
											 // cycles
	public static short ANDZ = (short) 0x25; // AND Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short ANDZX = (short) 0x35; // AND Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short ANDA = (short) 0x2D; // AND Absolute; 3 shorts, 4 cycles
	public static short ANDAX = (short) 0x3D; // AND Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ANDAY = (short) 0x39; // AND Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ANDIX = (short) 0x21; // AND Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short ANDIY = (short) 0x31; // AND Indirect Post-indexed; 2
											  // shorts, 5
	// cycles *

	// ASL - ASL Shift Left One Bit (Memory or Accumulator)
	public static short ASL = (short) 0x0A; // ASL Accumulator; 1 short, 2
											// cycles
	public static short ASLZ = (short) 0x06; // ASL Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short ASLZX = (short) 0x16; // ASL Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short ASLA = (short) 0x0E; // ASL Absolute; 3 shorts, 6 cycles
	public static short ASLAX = (short) 0x1E; // ASL Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// BCC - BCC Branch on Carry Clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BCC = (short) 0x90; // BCC (Relative); 2 shorts, 2
											// cycles *

	// BCS - BCS Branch on carry set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BCS = (short) 0xB0; // BCC (Relative); 2 shorts, 2
											// cycles *

	// BEQ - BEQ Branch on result zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BEQ = (short) 0xF0; // BCC (Relative); 2 shorts, 2
											// cycles *

	// BIT - BIT Test bits in memory with accumulator
	public static short BITZ = (short) 0x24; // BIT Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short BITA = (short) 0x2C; // BIT Absolute; 3 shorts, 4 cycles

	// BMI - BMI Branch on result minus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BMI = (short) 0x30; // BMI (Relative); 2 shorts, 2
											// cycles *

	// BNE - BNE Branch on result not zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BNE = (short) 0xD0; // BNE (Relative); 2 shorts, 2
											// cycles *

	// BPL - BPL Branch on result plus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BPL = (short) 0x10; // BPL (Relative); 2 shorts, 2
											// cycles *

	// BRK - BRK Force Break
	public static short BRK = (short) 0x00; // BRK (Implied); 1 short, 7 cycles

	// BVC - BVC Branch on overflow clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BVC = (short) 0x50; // BVC (Relative); 2 shorts, 2
											// cycles *

	// BVS - BVS Branch on overflow set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BVS = (short) 0x70; // BVS (Relative); 2 shorts, 2
											// cycles *

	// CLC - CLC Clear carry flag
	public static short CLC = (short) 0x18; // CLC (Implied); 1 short, 2 cycles

	// CLD - CLD Clear decimal mode flag
	public static short CLD = (short) 0xD8; // CLD (Implied); 1 short, 2 cycles

	// CLI - CLI Clear interrupt disable flag
	public static short CLI = (short) 0x58; // CLI (Implied); 1 short, 2 cycles

	// CLV - CLV Clear overflow flag
	public static short CLV = (short) 0xB8; // CLV (Implied); 1 short, 2 cycles

	// CMP - CMP Compare memory and accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short CMPI = (short) 0xC9; // CMP Immediate; 2 shorts, 2
											 // cycles
	public static short CMPZ = (short) 0xC5; // CMP Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short CMPZX = (short) 0xD5; // CMP Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short CMPA = (short) 0xCD; // CMP Absolute; 3 shorts, 4 cycles
	public static short CMPAX = (short) 0xDD; // CMP Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short CMPAY = (short) 0xD9; // CMP Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short CMPIX = (short) 0xC1; // CMP Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short CMPIY = (short) 0xD1; // CMP Indirect Post-indexed; 2
											  // shorts, 5
	// cycles *

	// CPX - CPX Compare Memory and Index X
	public static short CPXI = (short) 0xE0; // CPX Immediate; 2 shorts, 2
											 // cycles
	public static short CPXZ = (short) 0xE4; // CPX Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short CPXA = (short) 0xEC; // CPX Absolute; 3 shorts, 4 cycles

	// CPY - CPY Compare Memory and Index Y
	public static short CPYI = (short) 0xC0; // CPY Immediate; 2 shorts, 2
											 // cycles
	public static short CPYZ = (short) 0xC4; // CPY Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short CPYA = (short) 0xCC; // CPY Absolute; 3 shorts, 4 cycles

	// DEC - DEC Decrement memory by one
	public static short DECZ = (short) 0xC6; // DEC Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short DECZX = (short) 0xD6; // DEC Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short DECA = (short) 0xCE; // DEC Absolute; 3 shorts, 6 cycles
	public static short DECAX = (short) 0xDE; // DEC Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// DEX - DEX Decrement index X by one
	public static short DEX = (short) 0xCA; // DEX (Implied); 1 short, 2 cycles

	// DEY - DEY Decrement index Y by one
	public static short DEY = (short) 0x88; // DEY (Implied); 1 short, 2 cycles

	// EOR - EOR "Exclusive-Or" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short EORI = (short) 0x49; // EOR Immediate; 2 shorts, 2
											 // cycles
	public static short EORZ = (short) 0x45; // EOR Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short EORZX = (short) 0x55; // EOR Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short EORA = (short) 0x4D; // EOR Absolute; 3 shorts, 4 cycles
	public static short EORAX = (short) 0x5D; // EOR Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short EORAY = (short) 0x59; // EOR Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short EORIX = (short) 0x41; // EOR Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short EORIY = (short) 0x51; // EOR Indirect Post-indexed; 2
											  // shorts, 5
	// cycles *

	// INC - INC Increment memory by one
	public static short INCZ = (short) 0xE6; // INC Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short INCZX = (short) 0xF6; // INC Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short INCA = (short) 0xEE; // INC Absolute; 3 shorts, 6 cycles
	public static short INCAX = (short) 0xFE; // INC Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// INX - INX Increment Index X by one
	public static short INX = (short) 0xE8; // INX (Implied); 1 short, 2 cycles

	// INY - INY Increment Index Y by one
	public static short INY = (short) 0xC8; // INY (Implied); 1 short, 2 cycles

	// JMP - JMP Jump to new location
	public static short JMPA = (short) 0x4C; // JMP Absolute; 3 shorts, 3 cycles
	public static short JMPI = (short) 0x6C; // JMP Indirect; 3 shorts, 5 cycles

	// JSR - JSR Jump to new location saving return address
	public static short JSRA = (short) 0x20; // JSR Absolute; 3 shorts, 6 cycles

	// LDA - LDA Load accumulator with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDAI = (short) 0xA9; // LDA Immediate; 2 shorts, 2
											 // cycles
	public static short LDAZ = (short) 0xA5; // LDA Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short LDAZX = (short) 0xB5; // LDA Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short LDAA = (short) 0xAD; // LDA Absolute; 3 shorts, 4 cycles
	public static short LDAAX = (short) 0xBD; // LDA Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short LDAAY = (short) 0xB9; // LDA Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short LDAIX = (short) 0xA1; // LDA Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short LDAIY = (short) 0xB1; // LDA Indirect Post-indexed; 2
											  // shorts, 5
	// cycles *

	// LDX - LDX Load index X with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDXI = (short) 0xA2; // LDX Immediate; 2 shorts, 2
											 // cycles
	public static short LDXZ = (short) 0xA6; // LDX Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short LDXZY = (short) 0xB6; // LDX Zero-page Y-indexed; 2
											  // shorts, 4
	// cycles
	public static short LDXA = (short) 0xAE; // LDX Absolute; 3 shorts, 4 cycles
	public static short LDXAY = (short) 0xBE; // LDX Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *

	// LDY - LDY Load index Y with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDYI = (short) 0xA0; // LDY Immediate; 2 shorts, 2
											 // cycles
	public static short LDYZ = (short) 0xA4; // LDY Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short LDYZX = (short) 0xB4; // LDY Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short LDYA = (short) 0xAC; // LDY Absolute; 3 shorts, 4 cycles
	public static short LDYAX = (short) 0xBC; // LDY Absolute X-indexed; 3
											  // shorts, 4
	// cycles *

	// LSR - LSR Shift right one bit (memory or accumulator)
	public static short LSR = (short) 0x4A; // LSR Accumulator; 1 short, 2
											// cycles
	public static short LSRZ = (short) 0x46; // LSR Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short LSRZX = (short) 0x56; // LSR Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short LSRA = (short) 0x4E; // LSR Absolute; 3 shorts, 6 cycles
	public static short LSRAX = (short) 0x5E; // LSR Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// NOP - NOP No operation
	public static short NOP = (short) 0xEA; // NOP Implied; 1 short, 2 cycles

	// ORA - ORA "OR" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short ORAI = (short) 0x09; // ORA Immediate; 2 shorts, 2
											 // cycles
	public static short ORAZ = (short) 0x05; // ORA Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short ORAZX = (short) 0x15; // ORA Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short ORAA = (short) 0x0D; // ORA Absolute; 3 shorts, 4 cycles
	public static short ORAAX = (short) 0x1D; // ORA Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ORAAY = (short) 0x19; // ORA Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short ORAIX = (short) 0x01; // ORA Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short ORAIY = (short) 0x11; // ORA Indirect Post-indexed; 2
											  // shorts, 5
	// cycles

	// PHA - PHA Push accumulator on stack
	public static short PHA = (short) 0x48; // PHA (Implied); 1 short, 3 cycles

	// PHP - PHP Push processor status on stack
	public static short PHP = (short) 0x08; // PHP (Implied); 1 short, 3 cycles

	// PLA - PLA Pull accumulator from stack
	public static short PLA = (short) 0x68; // PLA (Implied); 1 short, 4 cycles

	// PLP - PLP Pull processor status from stack
	public static short PLP = (short) 0x28; // PLP (Implied); 1 short, 4 cycles

	// ROL - ROL Rotate one bit left (memory or accumulator)
	public static short ROL = (short) 0x2A; // ROL Accumulator; 1 shorts, 2
											// cycles
	public static short ROLZ = (short) 0x26; // ROL Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short ROLZX = (short) 0x36; // ROL Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short ROLA = (short) 0x2E; // ROL Absolute; 3 shorts, 6 cycles
	public static short ROLAX = (short) 0x3E; // ROL Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// ROR - ROR Rotate one bit right (memory or accumulator)
	public static short ROR = (short) 0x6A; // ROR Accumulator; 1 shorts, 2
											// cycles
	public static short RORZ = (short) 0x66; // ROR Zero-page absolute; 2
											 // shorts, 5
	// cycles
	public static short RORZX = (short) 0x76; // ROR Zero-page X-indexed; 2
											  // shorts, 6
	// cycles
	public static short RORA = (short) 0x6E; // ROR Absolute; 3 shorts, 6 cycles
	public static short RORAX = (short) 0x7E; // ROR Absolute X-indexed; 3
											  // shorts, 7
	// cycles

	// RTI - RTI Return from interrupt
	public static short RTI = (short) 0x40; // RTI (Implied); 1 short, 6 cycles

	// RTS - RTS Return from subroutine
	public static short RTS = (short) 0x60; // RTS (Implied); 1 short, 6 cycles

	// SBC - SBC Subtract memory from accumulator with borrow
	// * - add 1 cycle if page boundary is crossed
	public static short SBCI = (short) 0xE9; // SBC Immediate; 2 shorts, 2
											 // cycles
	public static short SBCZ = (short) 0xE5; // SBC Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short SBCZX = (short) 0xF5; // SBC Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short SBCA = (short) 0xED; // SBC Absolute; 3 shorts, 4 cycles
	public static short SBCAX = (short) 0xFD; // SBC Absolute X-indexed; 3
											  // shorts, 4
	// cycles *
	public static short SBCAY = (short) 0xF9; // SBC Absolute Y-indexed; 3
											  // shorts, 4
	// cycles *
	public static short SBCIX = (short) 0xE1; // SBC Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short SBCIY = (short) 0xF1; // SBC Indirect Post-indexed; 2
											  // shorts, 5
	// cycles

	// SEC - SEC Set carry flag
	public static short SEC = (short) 0x38; // SEC (Implied); 1 short, 2 cycles

	// SED - SED Set decimal mode flag
	public static short SED = (short) 0xF8; // SED (Implied); 1 short, 2 cycles

	// SEI - SEI Set interrupt disable status flag
	public static short SEI = (short) 0x78; // SEI (Implied); 1 short, 2 cycles

	// STA - STA Store accumulator in memory
	public static short STAZ = (short) 0x85; // STA Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short STAZX = (short) 0x95; // STA Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short STAA = (short) 0x8D; // STA Absolute; 3 shorts, 4 cycles
	public static short STAAX = (short) 0x9D; // STA Absolute X-indexed; 3
											  // shorts, 5
	// cycles
	public static short STAAY = (short) 0x99; // STA Absolute Y-indexed; 3
											  // shorts, 5
	// cycles
	public static short STAIX = (short) 0x81; // STA Indirect Pre-indexed; 2
											  // shorts, 6
	// cycles
	public static short STAIY = (short) 0x91; // STA Indirect Post-indexed; 2
											  // shorts, 6
	// cycles

	// STX - STX Store index X in memory
	public static short STXZ = (short) 0x86; // STX Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short STXZX = (short) 0x96; // STX Zero-page Y-indexed; 2
											  // shorts, 4
	// cycles
	public static short STXA = (short) 0x8E; // STX Absolute; 3 shorts, 4 cycles

	// STY - STY Store index Y in memory
	public static short STYZ = (short) 0x84; // STY Zero-page absolute; 2
											 // shorts, 3
	// cycles
	public static short STYZX = (short) 0x94; // STY Zero-page X-indexed; 2
											  // shorts, 4
	// cycles
	public static short STYA = (short) 0x8C; // STY Absolute; 3 shorts, 4 cycles

	// TAX - TAX Transfer accumulator to index X
	public static short TAX = (short) 0xAA; // TAX (Implied); 1 short, 2 cycles

	// TAY - TAY Transfer accumulator to index Y
	public static short TAY = (short) 0xA8; // TAY (Implied); 1 short, 2 cycles

	// TSX - TSX Transfer stack pointer to index X
	public static short TSX = (short) 0xBA; // TSX (Implied); 1 short, 2 cycles

	// TXA - TXA Transfer index X to accumulator
	public static short TXA = (short) 0x8A; // TXA (Implied); 1 short, 2 cycles

	// TXS - TXS Transfer index X to stack pointer
	public static short TXS = (short) 0x9A; // TXS (Implied); 1 short, 2 cycles

	// TYA - TYA Transfer index Y to accumulator
	public static short TYA = (short) 0x98; // TYA (Implied); 1 short, 2 cycles
}