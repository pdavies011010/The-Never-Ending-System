package com.tnes;

public class Opcode {
	// Constant definition of opcodes
	// Instruction OpCodes
	// ADC - Add memory to accumulator with carry 
	// * - add 1 cycle if page boundary is crossed
	public short ADCI = 0x69;	//ADC Immediate; 2 bytes, 2 cycles
	public short ADCZ = 0x65;	//ADC Zero-page absolute; 2 bytes, 3 cycles
	public short ADCZX = 0x75;	//ADC Zero-page X-indexed; 2 bytes, 4 cycles
	public short ADCA = 0x6D;	//ADC Absolute; 3 bytes, 4 cycles
	public short ADCAX = 0x7D;	//ADC Absolute X-indexed; 3 bytes, 4 cycles *
	public short ADCAY = 0x79;	//ADC Absolute Y-indexed; 3 bytes, 4 cycles *
	public short ADCIX = 0x61;	//ADC Indirect Pre-indexed; 2 bytes, 6 cycles
	public short ADCIY = 0x71;	//ADC Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// AND - "AND" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public short ANDI = 0x29;	//AND Immediate; 2 bytes, 2 cycles
	public short ANDZ = 0x25;	//AND Zero-page absolute; 2 bytes, 3 cycles
	public short ANDZX = 0x35;	//AND Zero-page X-indexed; 2 bytes, 4 cycles
	public short ANDA = 0x2D;	//AND Absolute; 3 bytes, 4 cycles
	public short ANDAX = 0x3D;	//AND Absolute X-indexed; 3 bytes, 4 cycles *
	public short ANDAY = 0x39;	//AND Absolute Y-indexed; 3 bytes, 4 cycles *
	public short ANDIX = 0x21;	//AND Indirect Pre-indexed; 2 bytes, 6 cycles
	public short ANDIY = 0x31;	//AND Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// ASL - ASL Shift Left One Bit (Memory or Accumulator)
	public short ASL = 0x0A;	//ASL Accumulator; 1 byte, 2 cycles
	public short ASLZ = 0x06;	//ASL Zero-page absolute; 2 bytes, 5 cycles
	public short ASLZX = 0x16;	//ASL Zero-page X-indexed; 2 bytes, 6 cycles
	public short ASLA = 0x0E;	//ASL Absolute; 3 bytes, 6 cycles
	public short ASLAX = 0x1E;	//ASL Absolute X-indexed; 3 bytes, 7 cycles
	
	// BCC - BCC Branch on Carry Clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BCC = 0x90;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BCS - BCS Branch on carry set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BCS = 0xB0;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BEQ - BEQ Branch on result zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BEQ = 0xF0;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BIT - BIT Test bits in memory with accumulator
	public short BITZ = 0x24;	//BIT Zero-page absolute; 2 bytes, 3 cycles
	public short BITA = 0x2C;	//BIT Absolute; 3 bytes, 4 cycles
	
	// BMI - BMI Branch on result minus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BMI = 0x30;	//BMI (Relative); 2 bytes, 2 cycles *
	
	// BNE - BNE Branch on result not zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BNE = 0xD0;	//BNE (Relative); 2 bytes, 2 cycles *
	
	// BPL - BPL Branch on result plus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BPL = 0x10;	//BPL (Relative); 2 bytes, 2 cycles *
	
	// BRK - BRK Force Break
	public short BRK = 0x00;	//BRK (Implied); 1 byte, 7 cycles
	
	// BVC - BVC Branch on overflow clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BVC = 0x50;	//BVC (Relative); 2 bytes, 2 cycles *
	
	// BVS - BVS Branch on overflow set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public short BVS = 0x70;	//BVS (Relative); 2 bytes, 2 cycles *
	
	// CLC - CLC Clear carry flag
	public short CLC = 0x18;	//CLC (Implied); 1 byte, 2 cycles
	
	// CLD - CLD Clear decimal mode flag 
	public short CLD = 0xD8;	//CLD (Implied); 1 byte, 2 cycles
	
	// CLI - CLI Clear interrupt disable flag
	public short CLI = 0x58;	//CLI (Implied); 1 byte, 2 cycles
	
	// CLV - CLV Clear overflow flag
	public short CLV = 0xB8;	//CLV (Implied); 1 byte, 2 cycles
	
	// CMP - CMP Compare memory and accumulator
	// * - add 1 cycle if page boundary is crossed
	public short CMPI = 0xC9;	//CMP Immediate; 2 bytes, 2 cycles
	public short CMPZ = 0xC5;	//CMP Zero-page absolute; 2 bytes, 3 cycles
	public short CMPZX = 0xD5;	//CMP Zero-page X-indexed; 2 bytes, 4 cycles
	public short CMPA = 0xCD;	//CMP Absolute; 3 bytes, 4 cycles
	public short CMPAX = 0xDD;	//CMP Absolute X-indexed; 3 bytes, 4 cycles *
	public short CMPAY = 0xD9;	//CMP Absolute Y-indexed; 3 bytes, 4 cycles *
	public short CMPIX = 0xC1;	//CMP Indirect Pre-indexed; 2 bytes, 6 cycles
	public short CMPIY = 0xD1;	//CMP Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// CPX - CPX Compare Memory and Index X
	public short CPXI = 0xE0;	//CPX Immediate; 2 bytes, 2 cycles
	public short CPXZ = 0xE4;	//CPX Zero-page absolute; 2 bytes, 3 cycles
	public short CPXA = 0xEC;	//CPX Absolute; 3 bytes, 4 cycles
	
	// CPY - CPY Compare Memory and Index Y
	public short CPYI = 0xC0;	//CPY Immediate; 2 bytes, 2 cycles
	public short CPYZ = 0xC4;	//CPY Zero-page absolute; 2 bytes, 3 cycles
	public short CPYA = 0xCC;	//CPY Absolute; 3 bytes, 4 cycles
	
	// DEC - DEC Decrement memory by one
	public short DECZ = 0xC6;	//DEC Zero-page absolute; 2 bytes, 5 cycles
	public short DECZX = 0xD6;	//DEC Zero-page X-indexed; 2 bytes, 6 cycles
	public short DECA = 0xCE;	//DEC Absolute; 3 bytes, 6 cycles
	public short DECAX = 0xDE;	//DEC Absolute X-indexed; 3 bytes, 7 cycles
	
	// DEX - DEX Decrement index X by one
	public short DEX = 0xCA;	//DEX (Implied); 1 byte, 2 cycles
	
	// DEY - DEY Decrement index Y by one
	public short DEY = 0x88;	//DEY (Implied); 1 byte, 2 cycles
	
	// EOR - EOR "Exclusive-Or" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public short EORI = 0x49;	//EOR Immediate; 2 bytes, 2 cycles
	public short EORZ = 0x45;	//EOR Zero-page absolute; 2 bytes, 3 cycles
	public short EORZX = 0x55;	//EOR Zero-page X-indexed; 2 bytes, 4 cycles
	public short EORA = 0x4D;	//EOR Absolute; 3 bytes, 4 cycles
	public short EORAX = 0x5D;	//EOR Absolute X-indexed; 3 bytes, 4 cycles *
	public short EORAY = 0x59;	//EOR Absolute Y-indexed; 3 bytes, 4 cycles *
	public short EORIX = 0x41;	//EOR Indirect Pre-indexed; 2 bytes, 6 cycles
	public short EORIY = 0x51;	//EOR Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// INC - INC Increment memory by one
	public short INCZ = 0xE6;	//INC Zero-page absolute; 2 bytes, 5 cycles
	public short INCZX = 0xF6;	//INC Zero-page X-indexed; 2 bytes, 6 cycles
	public short INCA = 0xEE;	//INC Absolute; 3 bytes, 6 cycles
	public short INCAX = 0xFE;	//INC Absolute X-indexed; 3 bytes, 7 cycles
	
	// INX - INX Increment Index X by one
	public short INX = 0xE8;	//INX (Implied); 1 byte, 2 cycles  
	
	// INY - INY Increment Index Y by one
	public short INY = 0xC8;	//INY (Implied); 1 byte, 2 cycles 
	
	// JMP - JMP Jump to new location
	public short JMPA = 0x4C;	//JMP Absolute; 3 bytes, 3 cycles
	public short JMPI = 0x6C;	//JMP Indirect; 3 bytes, 5 cycles
	
	// JSR - JSR Jump to new location saving return address
	public short JSRA = 0x20;	//JSR Absolute; 3 bytes, 6 cycles
	
	// LDA - LDA Load accumulator with memory
	// * - add 1 cycle if page boundary is crossed
	public short LDAI = 0xA9;	//LDA Immediate; 2 bytes, 2 cycles
	public short LDAZ = 0xA5;	//LDA Zero-page absolute; 2 bytes, 3 cycles
	public short LDAZX = 0xB5;	//LDA Zero-page X-indexed; 2 bytes, 4 cycles
	public short LDAA = 0xAD;	//LDA Absolute; 3 bytes, 4 cycles
	public short LDAAX = 0xBD;	//LDA Absolute X-indexed; 3 bytes, 4 cycles *
	public short LDAAY = 0xB9;	//LDA Absolute Y-indexed; 3 bytes, 4 cycles *
	public short LDAIX = 0xA1;	//LDA Indirect Pre-indexed; 2 bytes, 6 cycles
	public short LDAIY = 0xB1;	//LDA Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// LDX - LDX Load index X with memory
	// * - add 1 cycle if page boundary is crossed
	public short LDXI = 0xA2;	//LDX Immediate; 2 bytes, 2 cycles
	public short LDXZ = 0xA6;	//LDX Zero-page absolute; 2 bytes, 3 cycles
	public short LDXZY = 0xB6;	//LDX Zero-page Y-indexed; 2 bytes, 4 cycles
	public short LDXA = 0xAE;	//LDX Absolute; 3 bytes, 4 cycles
	public short LDXAY = 0xBE;	//LDX Absolute Y-indexed; 3 bytes, 4 cycles *
	
	// LDY - LDY Load index Y with memory
	// * - add 1 cycle if page boundary is crossed
	public short LDYI = 0xA0;	//LDY Immediate; 2 bytes, 2 cycles
	public short LDYZ = 0xA4;	//LDY Zero-page absolute; 2 bytes, 3 cycles
	public short LDYZX = 0xB4;	//LDY Zero-page X-indexed; 2 bytes, 4 cycles
	public short LDYA = 0xAC;	//LDY Absolute; 3 bytes, 4 cycles
	public short LDYAX = 0xBC;	//LDY Absolute X-indexed; 3 bytes, 4 cycles *
	
	// LSR - LSR Shift right one bit (memory or accumulator)
	public short LSR = 0x4A;	//LSR Accumulator; 1 byte, 2 cycles
	public short LSRZ = 0x46;	//LSR Zero-page absolute; 2 bytes, 5 cycles
	public short LSRZX = 0x56;	//LSR Zero-page X-indexed; 2 bytes, 6 cycles
	public short LSRA = 0x4E;	//LSR Absolute; 3 bytes, 6 cycles
	public short LSRAX = 0x5E;	//LSR Absolute X-indexed; 3 bytes, 7 cycles
	
	// NOP - NOP No operation 
	public short NOP = 0xEA;	//NOP Implied; 1 byte, 2 cycles
	
	// ORA - ORA "OR" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public short ORAI = 0x09;	//ORA Immediate; 2 bytes, 2 cycles
	public short ORAZ = 0x05;	//ORA Zero-page absolute; 2 bytes, 3 cycles
	public short ORAZX = 0x15;	//ORA Zero-page X-indexed; 2 bytes, 4 cycles
	public short ORAA = 0x0D;	//ORA Absolute; 3 bytes, 4 cycles
	public short ORAAX = 0x1D;	//ORA Absolute X-indexed; 3 bytes, 4 cycles *
	public short ORAAY = 0x19;	//ORA Absolute Y-indexed; 3 bytes, 4 cycles *
	public short ORAIX = 0x01;	//ORA Indirect Pre-indexed; 2 bytes, 6 cycles
	public short ORAIY = 0x11;	//ORA Indirect Post-indexed; 2 bytes, 5 cycles
	
	// PHA - PHA Push accumulator on stack 
	public short PHA = 0x48;	//PHA (Implied); 1 byte, 3 cycles
	
	// PHP - PHP Push processor status on stack 
	public short PHP = 0x08;	//PHP (Implied); 1 byte, 3 cycles
	
	// PLA - PLA Pull accumulator from stack 
	public short PLA = 0x68;	//PLA (Implied); 1 byte, 4 cycles
	
	// PLP - PLP Pull processor status from stack
	public short PLP = 0x28;	//PLP (Implied); 1 byte, 4 cycles
	
	// ROL - ROL Rotate one bit left (memory or accumulator)
	public short ROL = 0x2A;	//ROL Accumulator; 1 bytes, 2 cycles
	public short ROLZ = 0x26;	//ROL Zero-page absolute; 2 bytes, 5 cycles
	public short ROLZX = 0x36;	//ROL Zero-page X-indexed; 2 bytes, 6 cycles
	public short ROLA = 0x2E;	//ROL Absolute; 3 bytes, 6 cycles
	public short ROLAX = 0x3E;	//ROL Absolute X-indexed; 3 bytes, 7 cycles 
	
	// ROR - ROR Rotate one bit right (memory or accumulator)
	public short ROR = 0x6A;	//ROR Accumulator; 1 bytes, 2 cycles
	public short RORZ = 0x66;	//ROR Zero-page absolute; 2 bytes, 5 cycles
	public short RORZX = 0x76;	//ROR Zero-page X-indexed; 2 bytes, 6 cycles
	public short RORA = 0x6E;	//ROR Absolute; 3 bytes, 6 cycles
	public short RORAX = 0x7E;	//ROR Absolute X-indexed; 3 bytes, 7 cycles 
	
	// RTI - RTI Return from interrupt
	public short RTI = 0x40;	//RTI (Implied); 1 byte, 6 cycles
	
	// RTS - RTS Return from subroutine
	public short RTS = 0x60;	//RTS (Implied); 1 byte, 6 cycles
	
	// SBC - SBC Subtract memory from accumulator with borrow
	// * - add 1 cycle if page boundary is crossed
	public short SBCI = 0xE9;	//SBC Immediate; 2 bytes, 2 cycles
	public short SBCZ = 0xE5;	//SBC Zero-page absolute; 2 bytes, 3 cycles
	public short SBCZX = 0xF5;	//SBC Zero-page X-indexed; 2 bytes, 4 cycles
	public short SBCA = 0xED;	//SBC Absolute; 3 bytes, 4 cycles
	public short SBCAX = 0xFD;	//SBC Absolute X-indexed; 3 bytes, 4 cycles *
	public short SBCAY = 0xF9;	//SBC Absolute Y-indexed; 3 bytes, 4 cycles *
	public short SBCIX = 0xE1;	//SBC Indirect Pre-indexed; 2 bytes, 6 cycles
	public short SBCIY = 0xF1;	//SBC Indirect Post-indexed; 2 bytes, 5 cycles
	
	// SEC - SEC Set carry flag
	public short SEC = 0x38;	//SEC (Implied); 1 byte, 2 cycles
	
	// SED - SED Set decimal mode flag
	public short SED = 0xF8;	//SED (Implied); 1 byte, 2 cycles
	
	// SEI - SEI Set interrupt disable status flag
	public short SEI = 0x78;	//SEI (Implied); 1 byte, 2 cycles
	
	// STA - STA Store accumulator in memory
	public short STAZ = 0x85;	//STA Zero-page absolute; 2 bytes, 3 cycles
	public short STAZX = 0x95;	//STA Zero-page X-indexed; 2 bytes, 4 cycles
	public short STAA = 0x8D;	//STA Absolute; 3 bytes, 4 cycles
	public short STAAX = 0x9D;	//STA Absolute X-indexed; 3 bytes, 5 cycles
	public short STAAY = 0x99;	//STA Absolute Y-indexed; 3 bytes, 5 cycles
	public short STAIX = 0x81;	//STA Indirect Pre-indexed; 2 bytes, 6 cycles
	public short STAIY = 0x91;	//STA Indirect Post-indexed; 2 bytes, 6 cycles
	
	// STX - STX Store index X in memory 
	public short STXZ = 0x86;	//STX Zero-page absolute; 2 bytes, 3 cycles
	public short STXZX = 0x96;	//STX Zero-page Y-indexed; 2 bytes, 4 cycles
	public short STXA = 0x8E;	//STX Absolute; 3 bytes, 4 cycles
	
	// STY - STY Store index Y in memory 
	public short STYZ = 0x84;	//STY Zero-page absolute; 2 bytes, 3 cycles
	public short STYZX = 0x94;	//STY Zero-page X-indexed; 2 bytes, 4 cycles
	public short STYA = 0x8C;	//STY Absolute; 3 bytes, 4 cycles
	
	// TAX - TAX Transfer accumulator to index X
	public short TAX = 0xAA;	//TAX (Implied); 1 byte, 2 cycles  
	
	// TAY - TAY Transfer accumulator to index Y
	public short TAY = 0xA8;	//TAY (Implied); 1 byte, 2 cycles
	
	// TSX - TSX Transfer stack pointer to index X
	public short TSX = 0xBA;	//TSX (Implied); 1 byte, 2 cycles
	
	// TXA - TXA Transfer index X to accumulator
	public short TXA = 0x8A;	//TXA (Implied); 1 byte, 2 cycles
	
	// TXS - TXS Transfer index X to stack pointer
	public short TXS = 0x9A;	//TXS (Implied); 1 byte, 2 cycles
	
	// TYA - TYA Transfer index Y to accumulator
	public short TYA = 0x98;	//TYA (Implied); 1 byte, 2 cycles
}