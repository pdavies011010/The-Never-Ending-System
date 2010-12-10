package com.tnes;

public class Opcode {
	// Constant definition of opcodes
	// Instruction OpCodes
	// ADC - Add memory to accumulator with carry
	// * - add 1 cycle if page boundary is crossed
	public static byte ADCI = (byte)0x69; // ADC Immediate; 2 bytes, 2 cycles
	public static byte ADCZ = (byte)0x65; // ADC Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte ADCZX = (byte)0x75; // ADC Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte ADCA = (byte)0x6D; // ADC Absolute; 3 bytes, 4 cycles
	public static byte ADCAX = (byte)0x7D; // ADC Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte ADCAY = (byte)0x79; // ADC Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte ADCIX = (byte)0x61; // ADC Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte ADCIY = (byte)0x71; // ADC Indirect Post-indexed; 2 bytes, 5
									  // cycles *

	// AND - "AND" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static byte ANDI = (byte)0x29; // AND Immediate; 2 bytes, 2 cycles
	public static byte ANDZ = (byte)0x25; // AND Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte ANDZX = (byte)0x35; // AND Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte ANDA = (byte)0x2D; // AND Absolute; 3 bytes, 4 cycles
	public static byte ANDAX = (byte)0x3D; // AND Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte ANDAY = (byte)0x39; // AND Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte ANDIX = (byte)0x21; // AND Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte ANDIY = (byte)0x31; // AND Indirect Post-indexed; 2 bytes, 5
									  // cycles *

	// ASL - ASL Shift Left One Bit (Memory or Accumulator)
	public static byte ASL = (byte)0x0A; // ASL Accumulator; 1 byte, 2 cycles
	public static byte ASLZ = (byte)0x06; // ASL Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte ASLZX = (byte)0x16; // ASL Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte ASLA = (byte)0x0E; // ASL Absolute; 3 bytes, 6 cycles
	public static byte ASLAX = (byte)0x1E; // ASL Absolute X-indexed; 3 bytes, 7
									  // cycles

	// BCC - BCC Branch on Carry Clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BCC = (byte)0x90; // BCC (Relative); 2 bytes, 2 cycles *

	// BCS - BCS Branch on carry set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BCS = (byte)0xB0; // BCC (Relative); 2 bytes, 2 cycles *

	// BEQ - BEQ Branch on result zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BEQ = (byte)0xF0; // BCC (Relative); 2 bytes, 2 cycles *

	// BIT - BIT Test bits in memory with accumulator
	public static byte BITZ = (byte)0x24; // BIT Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte BITA = (byte)0x2C; // BIT Absolute; 3 bytes, 4 cycles

	// BMI - BMI Branch on result minus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BMI = (byte)0x30; // BMI (Relative); 2 bytes, 2 cycles *

	// BNE - BNE Branch on result not zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BNE = (byte)0xD0; // BNE (Relative); 2 bytes, 2 cycles *

	// BPL - BPL Branch on result plus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BPL = (byte)0x10; // BPL (Relative); 2 bytes, 2 cycles *

	// BRK - BRK Force Break
	public static byte BRK = (byte)0x00; // BRK (Implied); 1 byte, 7 cycles

	// BVC - BVC Branch on overflow clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BVC = (byte)0x50; // BVC (Relative); 2 bytes, 2 cycles *

	// BVS - BVS Branch on overflow set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static byte BVS = (byte)0x70; // BVS (Relative); 2 bytes, 2 cycles *

	// CLC - CLC Clear carry flag
	public static byte CLC = (byte)0x18; // CLC (Implied); 1 byte, 2 cycles

	// CLD - CLD Clear decimal mode flag
	public static byte CLD = (byte)0xD8; // CLD (Implied); 1 byte, 2 cycles

	// CLI - CLI Clear interrupt disable flag
	public static byte CLI = (byte)0x58; // CLI (Implied); 1 byte, 2 cycles

	// CLV - CLV Clear overflow flag
	public static byte CLV = (byte)0xB8; // CLV (Implied); 1 byte, 2 cycles

	// CMP - CMP Compare memory and accumulator
	// * - add 1 cycle if page boundary is crossed
	public static byte CMPI = (byte)0xC9; // CMP Immediate; 2 bytes, 2 cycles
	public static byte CMPZ = (byte)0xC5; // CMP Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte CMPZX = (byte)0xD5; // CMP Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte CMPA = (byte)0xCD; // CMP Absolute; 3 bytes, 4 cycles
	public static byte CMPAX = (byte)0xDD; // CMP Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte CMPAY = (byte)0xD9; // CMP Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte CMPIX = (byte)0xC1; // CMP Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte CMPIY = (byte)0xD1; // CMP Indirect Post-indexed; 2 bytes, 5
									  // cycles *

	// CPX - CPX Compare Memory and Index X
	public static byte CPXI = (byte)0xE0; // CPX Immediate; 2 bytes, 2 cycles
	public static byte CPXZ = (byte)0xE4; // CPX Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte CPXA = (byte)0xEC; // CPX Absolute; 3 bytes, 4 cycles

	// CPY - CPY Compare Memory and Index Y
	public static byte CPYI = (byte)0xC0; // CPY Immediate; 2 bytes, 2 cycles
	public static byte CPYZ = (byte)0xC4; // CPY Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte CPYA = (byte)0xCC; // CPY Absolute; 3 bytes, 4 cycles

	// DEC - DEC Decrement memory by one
	public static byte DECZ = (byte)0xC6; // DEC Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte DECZX = (byte)0xD6; // DEC Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte DECA = (byte)0xCE; // DEC Absolute; 3 bytes, 6 cycles
	public static byte DECAX = (byte)0xDE; // DEC Absolute X-indexed; 3 bytes, 7
									  // cycles

	// DEX - DEX Decrement index X by one
	public static byte DEX = (byte)0xCA; // DEX (Implied); 1 byte, 2 cycles

	// DEY - DEY Decrement index Y by one
	public static byte DEY = (byte)0x88; // DEY (Implied); 1 byte, 2 cycles

	// EOR - EOR "Exclusive-Or" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static byte EORI = (byte)0x49; // EOR Immediate; 2 bytes, 2 cycles
	public static byte EORZ = (byte)0x45; // EOR Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte EORZX = (byte)0x55; // EOR Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte EORA = (byte)0x4D; // EOR Absolute; 3 bytes, 4 cycles
	public static byte EORAX = (byte)0x5D; // EOR Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte EORAY = (byte)0x59; // EOR Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte EORIX = (byte)0x41; // EOR Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte EORIY = (byte)0x51; // EOR Indirect Post-indexed; 2 bytes, 5
									  // cycles *

	// INC - INC Increment memory by one
	public static byte INCZ = (byte)0xE6; // INC Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte INCZX = (byte)0xF6; // INC Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte INCA = (byte)0xEE; // INC Absolute; 3 bytes, 6 cycles
	public static byte INCAX = (byte)0xFE; // INC Absolute X-indexed; 3 bytes, 7
									  // cycles

	// INX - INX Increment Index X by one
	public static byte INX = (byte)0xE8; // INX (Implied); 1 byte, 2 cycles

	// INY - INY Increment Index Y by one
	public static byte INY = (byte)0xC8; // INY (Implied); 1 byte, 2 cycles

	// JMP - JMP Jump to new location
	public static byte JMPA = (byte)0x4C; // JMP Absolute; 3 bytes, 3 cycles
	public static byte JMPI = (byte)0x6C; // JMP Indirect; 3 bytes, 5 cycles

	// JSR - JSR Jump to new location saving return address
	public static byte JSRA = (byte)0x20; // JSR Absolute; 3 bytes, 6 cycles

	// LDA - LDA Load accumulator with memory
	// * - add 1 cycle if page boundary is crossed
	public static byte LDAI = (byte)0xA9; // LDA Immediate; 2 bytes, 2 cycles
	public static byte LDAZ = (byte)0xA5; // LDA Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte LDAZX = (byte)0xB5; // LDA Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte LDAA = (byte)0xAD; // LDA Absolute; 3 bytes, 4 cycles
	public static byte LDAAX = (byte)0xBD; // LDA Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte LDAAY = (byte)0xB9; // LDA Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte LDAIX = (byte)0xA1; // LDA Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte LDAIY = (byte)0xB1; // LDA Indirect Post-indexed; 2 bytes, 5
									  // cycles *

	// LDX - LDX Load index X with memory
	// * - add 1 cycle if page boundary is crossed
	public static byte LDXI = (byte)0xA2; // LDX Immediate; 2 bytes, 2 cycles
	public static byte LDXZ = (byte)0xA6; // LDX Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte LDXZY = (byte)0xB6; // LDX Zero-page Y-indexed; 2 bytes, 4
									  // cycles
	public static byte LDXA = (byte)0xAE; // LDX Absolute; 3 bytes, 4 cycles
	public static byte LDXAY = (byte)0xBE; // LDX Absolute Y-indexed; 3 bytes, 4
									  // cycles *

	// LDY - LDY Load index Y with memory
	// * - add 1 cycle if page boundary is crossed
	public static byte LDYI = (byte)0xA0; // LDY Immediate; 2 bytes, 2 cycles
	public static byte LDYZ = (byte)0xA4; // LDY Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte LDYZX = (byte)0xB4; // LDY Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte LDYA = (byte)0xAC; // LDY Absolute; 3 bytes, 4 cycles
	public static byte LDYAX = (byte)0xBC; // LDY Absolute X-indexed; 3 bytes, 4
									  // cycles *

	// LSR - LSR Shift right one bit (memory or accumulator)
	public static byte LSR = (byte)0x4A; // LSR Accumulator; 1 byte, 2 cycles
	public static byte LSRZ = (byte)0x46; // LSR Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte LSRZX = (byte)0x56; // LSR Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte LSRA = (byte)0x4E; // LSR Absolute; 3 bytes, 6 cycles
	public static byte LSRAX = (byte)0x5E; // LSR Absolute X-indexed; 3 bytes, 7
									  // cycles

	// NOP - NOP No operation
	public static byte NOP = (byte)0xEA; // NOP Implied; 1 byte, 2 cycles

	// ORA - ORA "OR" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static byte ORAI = (byte)0x09; // ORA Immediate; 2 bytes, 2 cycles
	public static byte ORAZ = (byte)0x05; // ORA Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte ORAZX = (byte)0x15; // ORA Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte ORAA = (byte)0x0D; // ORA Absolute; 3 bytes, 4 cycles
	public static byte ORAAX = (byte)0x1D; // ORA Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte ORAAY = (byte)0x19; // ORA Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte ORAIX = (byte)0x01; // ORA Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte ORAIY = (byte)0x11; // ORA Indirect Post-indexed; 2 bytes, 5
									  // cycles

	// PHA - PHA Push accumulator on stack
	public static byte PHA = (byte)0x48; // PHA (Implied); 1 byte, 3 cycles

	// PHP - PHP Push processor status on stack
	public static byte PHP = (byte)0x08; // PHP (Implied); 1 byte, 3 cycles

	// PLA - PLA Pull accumulator from stack
	public static byte PLA = (byte)0x68; // PLA (Implied); 1 byte, 4 cycles

	// PLP - PLP Pull processor status from stack
	public static byte PLP = (byte)0x28; // PLP (Implied); 1 byte, 4 cycles

	// ROL - ROL Rotate one bit left (memory or accumulator)
	public static byte ROL = (byte)0x2A; // ROL Accumulator; 1 bytes, 2 cycles
	public static byte ROLZ = (byte)0x26; // ROL Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte ROLZX = (byte)0x36; // ROL Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte ROLA = (byte)0x2E; // ROL Absolute; 3 bytes, 6 cycles
	public static byte ROLAX = (byte)0x3E; // ROL Absolute X-indexed; 3 bytes, 7
									  // cycles

	// ROR - ROR Rotate one bit right (memory or accumulator)
	public static byte ROR = (byte)0x6A; // ROR Accumulator; 1 bytes, 2 cycles
	public static byte RORZ = (byte)0x66; // ROR Zero-page absolute; 2 bytes, 5
									 // cycles
	public static byte RORZX = (byte)0x76; // ROR Zero-page X-indexed; 2 bytes, 6
									  // cycles
	public static byte RORA = (byte)0x6E; // ROR Absolute; 3 bytes, 6 cycles
	public static byte RORAX = (byte)0x7E; // ROR Absolute X-indexed; 3 bytes, 7
									  // cycles

	// RTI - RTI Return from interrupt
	public static byte RTI = (byte)0x40; // RTI (Implied); 1 byte, 6 cycles

	// RTS - RTS Return from subroutine
	public static byte RTS = (byte)0x60; // RTS (Implied); 1 byte, 6 cycles

	// SBC - SBC Subtract memory from accumulator with borrow
	// * - add 1 cycle if page boundary is crossed
	public static byte SBCI = (byte)0xE9; // SBC Immediate; 2 bytes, 2 cycles
	public static byte SBCZ = (byte)0xE5; // SBC Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte SBCZX = (byte)0xF5; // SBC Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte SBCA = (byte)0xED; // SBC Absolute; 3 bytes, 4 cycles
	public static byte SBCAX = (byte)0xFD; // SBC Absolute X-indexed; 3 bytes, 4
									  // cycles *
	public static byte SBCAY = (byte)0xF9; // SBC Absolute Y-indexed; 3 bytes, 4
									  // cycles *
	public static byte SBCIX = (byte)0xE1; // SBC Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte SBCIY = (byte)0xF1; // SBC Indirect Post-indexed; 2 bytes, 5
									  // cycles

	// SEC - SEC Set carry flag
	public static byte SEC = (byte)0x38; // SEC (Implied); 1 byte, 2 cycles

	// SED - SED Set decimal mode flag
	public static byte SED = (byte)0xF8; // SED (Implied); 1 byte, 2 cycles

	// SEI - SEI Set interrupt disable status flag
	public static byte SEI = (byte)0x78; // SEI (Implied); 1 byte, 2 cycles

	// STA - STA Store accumulator in memory
	public static byte STAZ = (byte)0x85; // STA Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte STAZX = (byte)0x95; // STA Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte STAA = (byte)0x8D; // STA Absolute; 3 bytes, 4 cycles
	public static byte STAAX = (byte)0x9D; // STA Absolute X-indexed; 3 bytes, 5
									  // cycles
	public static byte STAAY = (byte)0x99; // STA Absolute Y-indexed; 3 bytes, 5
									  // cycles
	public static byte STAIX = (byte)0x81; // STA Indirect Pre-indexed; 2 bytes, 6
									  // cycles
	public static byte STAIY = (byte)0x91; // STA Indirect Post-indexed; 2 bytes, 6
									  // cycles

	// STX - STX Store index X in memory
	public static byte STXZ = (byte)0x86; // STX Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte STXZX = (byte)0x96; // STX Zero-page Y-indexed; 2 bytes, 4
									  // cycles
	public static byte STXA = (byte)0x8E; // STX Absolute; 3 bytes, 4 cycles

	// STY - STY Store index Y in memory
	public static byte STYZ = (byte)0x84; // STY Zero-page absolute; 2 bytes, 3
									 // cycles
	public static byte STYZX = (byte)0x94; // STY Zero-page X-indexed; 2 bytes, 4
									  // cycles
	public static byte STYA = (byte)0x8C; // STY Absolute; 3 bytes, 4 cycles

	// TAX - TAX Transfer accumulator to index X
	public static byte TAX = (byte)0xAA; // TAX (Implied); 1 byte, 2 cycles

	// TAY - TAY Transfer accumulator to index Y
	public static byte TAY = (byte)0xA8; // TAY (Implied); 1 byte, 2 cycles

	// TSX - TSX Transfer stack pointer to index X
	public static byte TSX = (byte)0xBA; // TSX (Implied); 1 byte, 2 cycles

	// TXA - TXA Transfer index X to accumulator
	public static byte TXA = (byte)0x8A; // TXA (Implied); 1 byte, 2 cycles

	// TXS - TXS Transfer index X to stack pointer
	public static byte TXS = (byte)0x9A; // TXS (Implied); 1 byte, 2 cycles

	// TYA - TYA Transfer index Y to accumulator
	public static byte TYA = (byte)0x98; // TYA (Implied); 1 byte, 2 cycles
}