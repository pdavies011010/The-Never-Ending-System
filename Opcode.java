package com.tnes;

public class Opcode {
	// Constant definition of opcodes
	// Instruction OpCodes
	// ADC - Add memory to accumulator with carry 
	// * - add 1 cycle if page boundary is crossed
	public static short ADCI = 0x69;	//ADC Immediate; 2 bytes, 2 cycles
	public static short ADCZ = 0x65;	//ADC Zero-page absolute; 2 bytes, 3 cycles
	public static short ADCZX = 0x75;	//ADC Zero-page X-indexed; 2 bytes, 4 cycles
	public static short ADCA = 0x6D;	//ADC Absolute; 3 bytes, 4 cycles
	public static short ADCAX = 0x7D;	//ADC Absolute X-indexed; 3 bytes, 4 cycles *
	public static short ADCAY = 0x79;	//ADC Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short ADCIX = 0x61;	//ADC Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short ADCIY = 0x71;	//ADC Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// AND - "AND" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short ANDI = 0x29;	//AND Immediate; 2 bytes, 2 cycles
	public static short ANDZ = 0x25;	//AND Zero-page absolute; 2 bytes, 3 cycles
	public static short ANDZX = 0x35;	//AND Zero-page X-indexed; 2 bytes, 4 cycles
	public static short ANDA = 0x2D;	//AND Absolute; 3 bytes, 4 cycles
	public static short ANDAX = 0x3D;	//AND Absolute X-indexed; 3 bytes, 4 cycles *
	public static short ANDAY = 0x39;	//AND Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short ANDIX = 0x21;	//AND Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short ANDIY = 0x31;	//AND Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// ASL - ASL Shift Left One Bit (Memory or Accumulator)
	public static short ASL = 0x0A;	//ASL Accumulator; 1 byte, 2 cycles
	public static short ASLZ = 0x06;	//ASL Zero-page absolute; 2 bytes, 5 cycles
	public static short ASLZX = 0x16;	//ASL Zero-page X-indexed; 2 bytes, 6 cycles
	public static short ASLA = 0x0E;	//ASL Absolute; 3 bytes, 6 cycles
	public static short ASLAX = 0x1E;	//ASL Absolute X-indexed; 3 bytes, 7 cycles
	
	// BCC - BCC Branch on Carry Clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BCC = 0x90;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BCS - BCS Branch on carry set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BCS = 0xB0;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BEQ - BEQ Branch on result zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BEQ = 0xF0;	//BCC (Relative); 2 bytes, 2 cycles *
	
	// BIT - BIT Test bits in memory with accumulator
	public static short BITZ = 0x24;	//BIT Zero-page absolute; 2 bytes, 3 cycles
	public static short BITA = 0x2C;	//BIT Absolute; 3 bytes, 4 cycles
	
	// BMI - BMI Branch on result minus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BMI = 0x30;	//BMI (Relative); 2 bytes, 2 cycles *
	
	// BNE - BNE Branch on result not zero
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BNE = 0xD0;	//BNE (Relative); 2 bytes, 2 cycles *
	
	// BPL - BPL Branch on result plus
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BPL = 0x10;	//BPL (Relative); 2 bytes, 2 cycles *
	
	// BRK - BRK Force Break
	public static short BRK = 0x00;	//BRK (Implied); 1 byte, 7 cycles
	
	// BVC - BVC Branch on overflow clear
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BVC = 0x50;	//BVC (Relative); 2 bytes, 2 cycles *
	
	// BVS - BVS Branch on overflow set
	// * - add 1 cycle if page boundary is not crossed, 2 if it is
	public static short BVS = 0x70;	//BVS (Relative); 2 bytes, 2 cycles *
	
	// CLC - CLC Clear carry flag
	public static short CLC = 0x18;	//CLC (Implied); 1 byte, 2 cycles
	
	// CLD - CLD Clear decimal mode flag 
	public static short CLD = 0xD8;	//CLD (Implied); 1 byte, 2 cycles
	
	// CLI - CLI Clear interrupt disable flag
	public static short CLI = 0x58;	//CLI (Implied); 1 byte, 2 cycles
	
	// CLV - CLV Clear overflow flag
	public static short CLV = 0xB8;	//CLV (Implied); 1 byte, 2 cycles
	
	// CMP - CMP Compare memory and accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short CMPI = 0xC9;	//CMP Immediate; 2 bytes, 2 cycles
	public static short CMPZ = 0xC5;	//CMP Zero-page absolute; 2 bytes, 3 cycles
	public static short CMPZX = 0xD5;	//CMP Zero-page X-indexed; 2 bytes, 4 cycles
	public static short CMPA = 0xCD;	//CMP Absolute; 3 bytes, 4 cycles
	public static short CMPAX = 0xDD;	//CMP Absolute X-indexed; 3 bytes, 4 cycles *
	public static short CMPAY = 0xD9;	//CMP Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short CMPIX = 0xC1;	//CMP Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short CMPIY = 0xD1;	//CMP Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// CPX - CPX Compare Memory and Index X
	public static short CPXI = 0xE0;	//CPX Immediate; 2 bytes, 2 cycles
	public static short CPXZ = 0xE4;	//CPX Zero-page absolute; 2 bytes, 3 cycles
	public static short CPXA = 0xEC;	//CPX Absolute; 3 bytes, 4 cycles
	
	// CPY - CPY Compare Memory and Index Y
	public static short CPYI = 0xC0;	//CPY Immediate; 2 bytes, 2 cycles
	public static short CPYZ = 0xC4;	//CPY Zero-page absolute; 2 bytes, 3 cycles
	public static short CPYA = 0xCC;	//CPY Absolute; 3 bytes, 4 cycles
	
	// DEC - DEC Decrement memory by one
	public static short DECZ = 0xC6;	//DEC Zero-page absolute; 2 bytes, 5 cycles
	public static short DECZX = 0xD6;	//DEC Zero-page X-indexed; 2 bytes, 6 cycles
	public static short DECA = 0xCE;	//DEC Absolute; 3 bytes, 6 cycles
	public static short DECAX = 0xDE;	//DEC Absolute X-indexed; 3 bytes, 7 cycles
	
	// DEX - DEX Decrement index X by one
	public static short DEX = 0xCA;	//DEX (Implied); 1 byte, 2 cycles
	
	// DEY - DEY Decrement index Y by one
	public static short DEY = 0x88;	//DEY (Implied); 1 byte, 2 cycles
	
	// EOR - EOR "Exclusive-Or" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short EORI = 0x49;	//EOR Immediate; 2 bytes, 2 cycles
	public static short EORZ = 0x45;	//EOR Zero-page absolute; 2 bytes, 3 cycles
	public static short EORZX = 0x55;	//EOR Zero-page X-indexed; 2 bytes, 4 cycles
	public static short EORA = 0x4D;	//EOR Absolute; 3 bytes, 4 cycles
	public static short EORAX = 0x5D;	//EOR Absolute X-indexed; 3 bytes, 4 cycles *
	public static short EORAY = 0x59;	//EOR Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short EORIX = 0x41;	//EOR Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short EORIY = 0x51;	//EOR Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// INC - INC Increment memory by one
	public static short INCZ = 0xE6;	//INC Zero-page absolute; 2 bytes, 5 cycles
	public static short INCZX = 0xF6;	//INC Zero-page X-indexed; 2 bytes, 6 cycles
	public static short INCA = 0xEE;	//INC Absolute; 3 bytes, 6 cycles
	public static short INCAX = 0xFE;	//INC Absolute X-indexed; 3 bytes, 7 cycles
	
	// INX - INX Increment Index X by one
	public static short INX = 0xE8;	//INX (Implied); 1 byte, 2 cycles  
	
	// INY - INY Increment Index Y by one
	public static short INY = 0xC8;	//INY (Implied); 1 byte, 2 cycles 
	
	// JMP - JMP Jump to new location
	public static short JMPA = 0x4C;	//JMP Absolute; 3 bytes, 3 cycles
	public static short JMPI = 0x6C;	//JMP Indirect; 3 bytes, 5 cycles
	
	// JSR - JSR Jump to new location saving return address
	public static short JSRA = 0x20;	//JSR Absolute; 3 bytes, 6 cycles
	
	// LDA - LDA Load accumulator with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDAI = 0xA9;	//LDA Immediate; 2 bytes, 2 cycles
	public static short LDAZ = 0xA5;	//LDA Zero-page absolute; 2 bytes, 3 cycles
	public static short LDAZX = 0xB5;	//LDA Zero-page X-indexed; 2 bytes, 4 cycles
	public static short LDAA = 0xAD;	//LDA Absolute; 3 bytes, 4 cycles
	public static short LDAAX = 0xBD;	//LDA Absolute X-indexed; 3 bytes, 4 cycles *
	public static short LDAAY = 0xB9;	//LDA Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short LDAIX = 0xA1;	//LDA Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short LDAIY = 0xB1;	//LDA Indirect Post-indexed; 2 bytes, 5 cycles *
	
	// LDX - LDX Load index X with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDXI = 0xA2;	//LDX Immediate; 2 bytes, 2 cycles
	public static short LDXZ = 0xA6;	//LDX Zero-page absolute; 2 bytes, 3 cycles
	public static short LDXZY = 0xB6;	//LDX Zero-page Y-indexed; 2 bytes, 4 cycles
	public static short LDXA = 0xAE;	//LDX Absolute; 3 bytes, 4 cycles
	public static short LDXAY = 0xBE;	//LDX Absolute Y-indexed; 3 bytes, 4 cycles *
	
	// LDY - LDY Load index Y with memory
	// * - add 1 cycle if page boundary is crossed
	public static short LDYI = 0xA0;	//LDY Immediate; 2 bytes, 2 cycles
	public static short LDYZ = 0xA4;	//LDY Zero-page absolute; 2 bytes, 3 cycles
	public static short LDYZX = 0xB4;	//LDY Zero-page X-indexed; 2 bytes, 4 cycles
	public static short LDYA = 0xAC;	//LDY Absolute; 3 bytes, 4 cycles
	public static short LDYAX = 0xBC;	//LDY Absolute X-indexed; 3 bytes, 4 cycles *
	
	// LSR - LSR Shift right one bit (memory or accumulator)
	public static short LSR = 0x4A;	//LSR Accumulator; 1 byte, 2 cycles
	public static short LSRZ = 0x46;	//LSR Zero-page absolute; 2 bytes, 5 cycles
	public static short LSRZX = 0x56;	//LSR Zero-page X-indexed; 2 bytes, 6 cycles
	public static short LSRA = 0x4E;	//LSR Absolute; 3 bytes, 6 cycles
	public static short LSRAX = 0x5E;	//LSR Absolute X-indexed; 3 bytes, 7 cycles
	
	// NOP - NOP No operation 
	public static short NOP = 0xEA;	//NOP Implied; 1 byte, 2 cycles
	
	// ORA - ORA "OR" memory with accumulator
	// * - add 1 cycle if page boundary is crossed
	public static short ORAI = 0x09;	//ORA Immediate; 2 bytes, 2 cycles
	public static short ORAZ = 0x05;	//ORA Zero-page absolute; 2 bytes, 3 cycles
	public static short ORAZX = 0x15;	//ORA Zero-page X-indexed; 2 bytes, 4 cycles
	public static short ORAA = 0x0D;	//ORA Absolute; 3 bytes, 4 cycles
	public static short ORAAX = 0x1D;	//ORA Absolute X-indexed; 3 bytes, 4 cycles *
	public static short ORAAY = 0x19;	//ORA Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short ORAIX = 0x01;	//ORA Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short ORAIY = 0x11;	//ORA Indirect Post-indexed; 2 bytes, 5 cycles
	
	// PHA - PHA Push accumulator on stack 
	public static short PHA = 0x48;	//PHA (Implied); 1 byte, 3 cycles
	
	// PHP - PHP Push processor status on stack 
	public static short PHP = 0x08;	//PHP (Implied); 1 byte, 3 cycles
	
	// PLA - PLA Pull accumulator from stack 
	public static short PLA = 0x68;	//PLA (Implied); 1 byte, 4 cycles
	
	// PLP - PLP Pull processor status from stack
	public static short PLP = 0x28;	//PLP (Implied); 1 byte, 4 cycles
	
	// ROL - ROL Rotate one bit left (memory or accumulator)
	public static short ROL = 0x2A;	//ROL Accumulator; 1 bytes, 2 cycles
	public static short ROLZ = 0x26;	//ROL Zero-page absolute; 2 bytes, 5 cycles
	public static short ROLZX = 0x36;	//ROL Zero-page X-indexed; 2 bytes, 6 cycles
	public static short ROLA = 0x2E;	//ROL Absolute; 3 bytes, 6 cycles
	public static short ROLAX = 0x3E;	//ROL Absolute X-indexed; 3 bytes, 7 cycles 
	
	// ROR - ROR Rotate one bit right (memory or accumulator)
	public static short ROR = 0x6A;	//ROR Accumulator; 1 bytes, 2 cycles
	public static short RORZ = 0x66;	//ROR Zero-page absolute; 2 bytes, 5 cycles
	public static short RORZX = 0x76;	//ROR Zero-page X-indexed; 2 bytes, 6 cycles
	public static short RORA = 0x6E;	//ROR Absolute; 3 bytes, 6 cycles
	public static short RORAX = 0x7E;	//ROR Absolute X-indexed; 3 bytes, 7 cycles 
	
	// RTI - RTI Return from interrupt
	public static short RTI = 0x40;	//RTI (Implied); 1 byte, 6 cycles
	
	// RTS - RTS Return from subroutine
	public static short RTS = 0x60;	//RTS (Implied); 1 byte, 6 cycles
	
	// SBC - SBC Subtract memory from accumulator with borrow
	// * - add 1 cycle if page boundary is crossed
	public static short SBCI = 0xE9;	//SBC Immediate; 2 bytes, 2 cycles
	public static short SBCZ = 0xE5;	//SBC Zero-page absolute; 2 bytes, 3 cycles
	public static short SBCZX = 0xF5;	//SBC Zero-page X-indexed; 2 bytes, 4 cycles
	public static short SBCA = 0xED;	//SBC Absolute; 3 bytes, 4 cycles
	public static short SBCAX = 0xFD;	//SBC Absolute X-indexed; 3 bytes, 4 cycles *
	public static short SBCAY = 0xF9;	//SBC Absolute Y-indexed; 3 bytes, 4 cycles *
	public static short SBCIX = 0xE1;	//SBC Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short SBCIY = 0xF1;	//SBC Indirect Post-indexed; 2 bytes, 5 cycles
	
	// SEC - SEC Set carry flag
	public static short SEC = 0x38;	//SEC (Implied); 1 byte, 2 cycles
	
	// SED - SED Set decimal mode flag
	public static short SED = 0xF8;	//SED (Implied); 1 byte, 2 cycles
	
	// SEI - SEI Set interrupt disable status flag
	public static short SEI = 0x78;	//SEI (Implied); 1 byte, 2 cycles
	
	// STA - STA Store accumulator in memory
	public static short STAZ = 0x85;	//STA Zero-page absolute; 2 bytes, 3 cycles
	public static short STAZX = 0x95;	//STA Zero-page X-indexed; 2 bytes, 4 cycles
	public static short STAA = 0x8D;	//STA Absolute; 3 bytes, 4 cycles
	public static short STAAX = 0x9D;	//STA Absolute X-indexed; 3 bytes, 5 cycles
	public static short STAAY = 0x99;	//STA Absolute Y-indexed; 3 bytes, 5 cycles
	public static short STAIX = 0x81;	//STA Indirect Pre-indexed; 2 bytes, 6 cycles
	public static short STAIY = 0x91;	//STA Indirect Post-indexed; 2 bytes, 6 cycles
	
	// STX - STX Store index X in memory 
	public static short STXZ = 0x86;	//STX Zero-page absolute; 2 bytes, 3 cycles
	public static short STXZX = 0x96;	//STX Zero-page Y-indexed; 2 bytes, 4 cycles
	public static short STXA = 0x8E;	//STX Absolute; 3 bytes, 4 cycles
	
	// STY - STY Store index Y in memory 
	public static short STYZ = 0x84;	//STY Zero-page absolute; 2 bytes, 3 cycles
	public static short STYZX = 0x94;	//STY Zero-page X-indexed; 2 bytes, 4 cycles
	public static short STYA = 0x8C;	//STY Absolute; 3 bytes, 4 cycles
	
	// TAX - TAX Transfer accumulator to index X
	public static short TAX = 0xAA;	//TAX (Implied); 1 byte, 2 cycles  
	
	// TAY - TAY Transfer accumulator to index Y
	public static short TAY = 0xA8;	//TAY (Implied); 1 byte, 2 cycles
	
	// TSX - TSX Transfer stack pointer to index X
	public static short TSX = 0xBA;	//TSX (Implied); 1 byte, 2 cycles
	
	// TXA - TXA Transfer index X to accumulator
	public static short TXA = 0x8A;	//TXA (Implied); 1 byte, 2 cycles
	
	// TXS - TXS Transfer index X to stack pointer
	public static short TXS = 0x9A;	//TXS (Implied); 1 byte, 2 cycles
	
	// TYA - TYA Transfer index Y to accumulator
	public static short TYA = 0x98;	//TYA (Implied); 1 byte, 2 cycles
}