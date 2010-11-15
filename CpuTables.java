package com.tnes;

import java.util.*;

public class CpuTables {
	// Operation Hash (OPERATIONS[opcode] -> operation)
	public Map<Short, Operation> OPERATIONS = new HashMap<Short, Operation>();
	// Addressing Mode hash (ADDRESSING_MODES[opcode] -> addressing_mode)
	public Map<Short, AddressingMode> ADDRESSING_MODES = new HashMap<Short, AddressingMode>();
	// Cycle Count hashes (CYCLE_COUNTS[operation][addressing_mode] -> cycle_count)
	public Map<Operation, Map<AddressingMode, Integer>> CYCLE_COUNTS = new HashMap<Operation, Map<AddressingMode, Integer>>();
	// Byte Count hashes (instruction length) (BYTE_COUNTS[operation][addressing_mode] -> byte_count)
	public Map<Operation, Map<AddressingMode, Integer>> BYTE_COUNTS = new HashMap<Operation, Map<AddressingMode, Integer>>();
	
	/* 
	*  TODO: This stuff should probably be kept in a properties file.
	*/ 
	{
		/*
		*  Build map of Opcode -> Operation
		*/
		OPERATIONS.put(Opcode.ADCI, Operation.ADC);
		OPERATIONS.put(Opcode.ADCZ, Operation.ADC);
		OPERATIONS.put(Opcode.ADCZX, Operation.ADC);
		OPERATIONS.put(Opcode.ADCA, Operation.ADC);
		OPERATIONS.put(Opcode.ADCAX, Operation.ADC);
		OPERATIONS.put(Opcode.ADCAY, Operation.ADC);
		OPERATIONS.put(Opcode.ADCIX, Operation.ADC);
		OPERATIONS.put(Opcode.ADCIY, Operation.ADC);
		OPERATIONS.put(Opcode.ANDI, Operation.AND);
		OPERATIONS.put(Opcode.ANDZ, Operation.AND);
		OPERATIONS.put(Opcode.ANDZX, Operation.AND);
		OPERATIONS.put(Opcode.ANDA, Operation.AND);
		OPERATIONS.put(Opcode.ANDAX, Operation.AND);
		OPERATIONS.put(Opcode.ANDAY, Operation.AND);
		OPERATIONS.put(Opcode.ANDIX, Operation.AND);
		OPERATIONS.put(Opcode.ANDIY, Operation.AND);
		OPERATIONS.put(Opcode.ASL, Operation.ASL);
		OPERATIONS.put(Opcode.ASLZ, Operation.ASL);
		OPERATIONS.put(Opcode.ASLZX, Operation.ASL);
		OPERATIONS.put(Opcode.ASLA, Operation.ASL);
		OPERATIONS.put(Opcode.ASLAX, Operation.ASL);
		OPERATIONS.put(Opcode.BCC, Operation.BCC);
		OPERATIONS.put(Opcode.BCS, Operation.BCS);
		OPERATIONS.put(Opcode.BEQ, Operation.BEQ);
		OPERATIONS.put(Opcode.BITZ, Operation.BIT);
		OPERATIONS.put(Opcode.BITA, Operation.BIT);
		OPERATIONS.put(Opcode.BMI, Operation.BMI);
		OPERATIONS.put(Opcode.BNE, Operation.BNE);
		OPERATIONS.put(Opcode.BPL, Operation.BPL);
		OPERATIONS.put(Opcode.BRK, Operation.BRK);
		OPERATIONS.put(Opcode.BVC, Operation.BVC);
		OPERATIONS.put(Opcode.BVS, Operation.BVS);
		OPERATIONS.put(Opcode.CLC, Operation.CLC);
		OPERATIONS.put(Opcode.CLD, Operation.CLD);
		OPERATIONS.put(Opcode.CLI, Operation.CLI);
		OPERATIONS.put(Opcode.CLV, Operation.CLV);
		OPERATIONS.put(Opcode.CMPI, Operation.CMP);
		OPERATIONS.put(Opcode.CMPZ, Operation.CMP);
		OPERATIONS.put(Opcode.CMPZX, Operation.CMP);
		OPERATIONS.put(Opcode.CMPA, Operation.CMP);
		OPERATIONS.put(Opcode.CMPAX, Operation.CMP);
		OPERATIONS.put(Opcode.CMPAY, Operation.CMP);
		OPERATIONS.put(Opcode.CMPIX, Operation.CMP);
		OPERATIONS.put(Opcode.CMPIY, Operation.CMP);
		OPERATIONS.put(Opcode.CPXI, Operation.CPX);
		OPERATIONS.put(Opcode.CPXZ, Operation.CPX);
		OPERATIONS.put(Opcode.CPXA, Operation.CPX);
		OPERATIONS.put(Opcode.CPYI, Operation.CPY);
		OPERATIONS.put(Opcode.CPYZ, Operation.CPY);
		OPERATIONS.put(Opcode.CPYA, Operation.CPY);
		OPERATIONS.put(Opcode.DECZ, Operation.DEC);
		OPERATIONS.put(Opcode.DECZX, Operation.DEC);
		OPERATIONS.put(Opcode.DECA, Operation.DEC);
		OPERATIONS.put(Opcode.DECAX, Operation.DEC);
		OPERATIONS.put(Opcode.DEX, Operation.DEX);
		OPERATIONS.put(Opcode.DEY, Operation.DEY);
		OPERATIONS.put(Opcode.EORI, Operation.EOR);
		OPERATIONS.put(Opcode.EORZ, Operation.EOR);
		OPERATIONS.put(Opcode.EORZX, Operation.EOR);
		OPERATIONS.put(Opcode.EORA, Operation.EOR);
		OPERATIONS.put(Opcode.EORAX, Operation.EOR);
		OPERATIONS.put(Opcode.EORAY, Operation.EOR);
		OPERATIONS.put(Opcode.EORIX, Operation.EOR);
		OPERATIONS.put(Opcode.EORIY, Operation.EOR);
		OPERATIONS.put(Opcode.INCZ, Operation.INC);
		OPERATIONS.put(Opcode.INCZX, Operation.INC);
		OPERATIONS.put(Opcode.INCA, Operation.INC);
		OPERATIONS.put(Opcode.INCAX, Operation.INC);
		OPERATIONS.put(Opcode.INX, Operation.INX);
		OPERATIONS.put(Opcode.INY, Operation.INY);
		OPERATIONS.put(Opcode.JMPA, Operation.JMP);
		OPERATIONS.put(Opcode.JMPI, Operation.JMP);
		OPERATIONS.put(Opcode.JSRA, Operation.JSR);
		OPERATIONS.put(Opcode.LDAI, Operation.LDA);
		OPERATIONS.put(Opcode.LDAZ, Operation.LDA);
		OPERATIONS.put(Opcode.LDAZX, Operation.LDA);
		OPERATIONS.put(Opcode.LDAA, Operation.LDA);
		OPERATIONS.put(Opcode.LDAAX, Operation.LDA);
		OPERATIONS.put(Opcode.LDAAY, Operation.LDA);
		OPERATIONS.put(Opcode.LDAIX, Operation.LDA);
		OPERATIONS.put(Opcode.LDAIY, Operation.LDA);
		OPERATIONS.put(Opcode.LDXI, Operation.LDX);
		OPERATIONS.put(Opcode.LDXZ, Operation.LDX);
		OPERATIONS.put(Opcode.LDXZY, Operation.LDX);
		OPERATIONS.put(Opcode.LDXA, Operation.LDX);
		OPERATIONS.put(Opcode.LDXAY, Operation.LDX);
		OPERATIONS.put(Opcode.LDYI, Operation.LDY);
		OPERATIONS.put(Opcode.LDYZ, Operation.LDY);
		OPERATIONS.put(Opcode.LDYZX, Operation.LDY);
		OPERATIONS.put(Opcode.LDYA, Operation.LDY);
		OPERATIONS.put(Opcode.LDYAX, Operation.LDY);
		OPERATIONS.put(Opcode.LSR, Operation.LSR);
		OPERATIONS.put(Opcode.LSRZ, Operation.LSR);
		OPERATIONS.put(Opcode.LSRZX, Operation.LSR);
		OPERATIONS.put(Opcode.LSRA, Operation.LSR);
		OPERATIONS.put(Opcode.LSRAX, Operation.LSR);
		OPERATIONS.put(Opcode.NOP, Operation.NOP);
		OPERATIONS.put(Opcode.ORAI, Operation.ORA);
		OPERATIONS.put(Opcode.ORAZ, Operation.ORA);
		OPERATIONS.put(Opcode.ORAZX, Operation.ORA);
		OPERATIONS.put(Opcode.ORAA, Operation.ORA);
		OPERATIONS.put(Opcode.ORAAX, Operation.ORA);
		OPERATIONS.put(Opcode.ORAAY, Operation.ORA);
		OPERATIONS.put(Opcode.ORAIX, Operation.ORA);
		OPERATIONS.put(Opcode.ORAIY, Operation.ORA);
		OPERATIONS.put(Opcode.PHA, Operation.PHA);
		OPERATIONS.put(Opcode.PHP, Operation.PHP);
		OPERATIONS.put(Opcode.PLA, Operation.PLA);
		OPERATIONS.put(Opcode.PLP, Operation.PLP);
		OPERATIONS.put(Opcode.ROL, Operation.ROL);
		OPERATIONS.put(Opcode.ROLZ, Operation.ROL);
		OPERATIONS.put(Opcode.ROLZX, Operation.ROL);
		OPERATIONS.put(Opcode.ROLA, Operation.ROL);
		OPERATIONS.put(Opcode.ROLAX, Operation.ROL);
		OPERATIONS.put(Opcode.ROR, Operation.ROR);
		OPERATIONS.put(Opcode.RORZ, Operation.ROR);
		OPERATIONS.put(Opcode.RORZX, Operation.ROR);
		OPERATIONS.put(Opcode.RORA, Operation.ROR);
		OPERATIONS.put(Opcode.RORAX, Operation.ROR);
		OPERATIONS.put(Opcode.RTI, Operation.RTI);
		OPERATIONS.put(Opcode.RTS, Operation.RTS);
		OPERATIONS.put(Opcode.SBCI, Operation.SBC);
		OPERATIONS.put(Opcode.SBCZ, Operation.SBC);
		OPERATIONS.put(Opcode.SBCZX, Operation.SBC);
		OPERATIONS.put(Opcode.SBCA, Operation.SBC);
		OPERATIONS.put(Opcode.SBCAX, Operation.SBC);
		OPERATIONS.put(Opcode.SBCAY, Operation.SBC);
		OPERATIONS.put(Opcode.SBCIX, Operation.SBC);
		OPERATIONS.put(Opcode.SBCIY, Operation.SBC);
		OPERATIONS.put(Opcode.SEC, Operation.SEC);
		OPERATIONS.put(Opcode.SED, Operation.SED);
		OPERATIONS.put(Opcode.SEI, Operation.SEI);
		OPERATIONS.put(Opcode.STAZ, Operation.STA);
		OPERATIONS.put(Opcode.STAZX, Operation.STA);
		OPERATIONS.put(Opcode.STAA, Operation.STA);
		OPERATIONS.put(Opcode.STAAX, Operation.STA);
		OPERATIONS.put(Opcode.STAAY, Operation.STA);
		OPERATIONS.put(Opcode.STAIX, Operation.STA);
		OPERATIONS.put(Opcode.STAIY, Operation.STA);
		OPERATIONS.put(Opcode.STXZ, Operation.STX);
		OPERATIONS.put(Opcode.STXZX, Operation.STX);
		OPERATIONS.put(Opcode.STXA, Operation.STX);
		OPERATIONS.put(Opcode.STYZ, Operation.STY);
		OPERATIONS.put(Opcode.STYZX, Operation.STY);
		OPERATIONS.put(Opcode.STYA, Operation.STY);
		OPERATIONS.put(Opcode.TAX, Operation.TAX);
		OPERATIONS.put(Opcode.TAY, Operation.TAY);
		OPERATIONS.put(Opcode.TSX, Operation.TSX);
		OPERATIONS.put(Opcode.TXA, Operation.TXA);
		OPERATIONS.put(Opcode.TXS, Operation.TXS);
		
		/*
		* Build map of Opcode -> Addressing Mode
		*/
		ADDRESSING_MODES.put(Opcode.ADCI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.ANDI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.CMPI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.CPXI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.CPYI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.EORI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.LDAI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.LDXI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.LDYI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.ORAI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.SBCI, AddressingMode.IMMEDIATE);
		ADDRESSING_MODES.put(Opcode.ADCA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.ANDA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.ASLA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.BITA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.CMPA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.CPXA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.CPYA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.DECA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.EORA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.INCA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.JMPA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.JSRA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.LDAA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.LDXA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.LDYA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.LSRA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.ORAA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.ROLA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.RORA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.SBCA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.STAA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.STXA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.STYA, AddressingMode.ABSOLUTE);
		ADDRESSING_MODES.put(Opcode.ADCZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.ANDZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.ASLZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.BITZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.CMPZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.CPXZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.CPYZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.DECZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.EORZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.INCZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.LDAZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.LDXZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.LDYZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.LSRZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.ORAZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.ROLZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.RORZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.SBCZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.STAZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.STXZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.STYZ, AddressingMode.ZERO_PAGE);
		ADDRESSING_MODES.put(Opcode.BRK, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.CLC, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.CLD, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.CLI, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.CLV, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.DEX, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.DEY, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.INX, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.INY, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.NOP, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.PHA, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.PHP, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.PLA, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.PLP, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.RTI, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.RTS, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.SEC, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.SED, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.SEI, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TAX, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TAY, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TSX, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TXA, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TXS, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.TYA, AddressingMode.IMPLIED);
		ADDRESSING_MODES.put(Opcode.ASL, AddressingMode.ACCUMULATOR);
		ADDRESSING_MODES.put(Opcode.LSR, AddressingMode.ACCUMULATOR);
		ADDRESSING_MODES.put(Opcode.ROL, AddressingMode.ACCUMULATOR);
		ADDRESSING_MODES.put(Opcode.ROR, AddressingMode.ACCUMULATOR);
		ADDRESSING_MODES.put(Opcode.ADCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ANDZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ASLZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.CMPZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.DECZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.EORZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.INCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDYZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LSRZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ORAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ROLZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.RORZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.SBCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.STAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.STYZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDXZY, AddressingMode.ZERO_PAGE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.STXZX, AddressingMode.ZERO_PAGE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.ADCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ANDAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ASLAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.CMPAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.DECAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.EORAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.INCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDYAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.LSRAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ORAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ROLAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.RORAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.SBCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.STAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		ADDRESSING_MODES.put(Opcode.ADCAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.ANDAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.CMPAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.EORAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.LDXAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.ORAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.SBCAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.STAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		ADDRESSING_MODES.put(Opcode.JMPI, AddressingMode.INDIRECT);
		ADDRESSING_MODES.put(Opcode.ADCIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.ANDIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.CMPIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.EORIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.LDAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.ORAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.SBCIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.STAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.ADCIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.ANDIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.CMPIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.EORIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.LDAIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.ORAIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.SBCIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.STAIY, AddressingMode.POST_INDEXED_INDIRECT);
		ADDRESSING_MODES.put(Opcode.BCC, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BCS, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BEQ, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BMI, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BNE, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BPL, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BVC, AddressingMode.RELATIVE);
		ADDRESSING_MODES.put(Opcode.BVS, AddressingMode.RELATIVE);
		
		/*
		*  Build map of Operation/Addr. Mode -> Cycle count
		*/
		ChainedHashMap<AddressingMode, Integer> modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.ADC, modeMap);
	
		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.AND, modeMap);
		
		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.ASL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BCC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BCS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BEQ, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CYCLE_COUNTS.put(Operation.BIT, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BMI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BNE, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BPL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 7);
		CYCLE_COUNTS.put(Operation.BRK, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BVC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CYCLE_COUNTS.put(Operation.BVS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.CLC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.CLD, modeMap);
		
		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.CLI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.CLV, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.CMP, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CYCLE_COUNTS.put(Operation.CPX, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CYCLE_COUNTS.put(Operation.CPY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6).set(AddressingMode.ABSOLUTE, 6);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.DEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.DEX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.DEY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.EOR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6).set(AddressingMode.ABSOLUTE, 6);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.INC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.INX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.INY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.JMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 6);
		CYCLE_COUNTS.put(Operation.JSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.LDA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		CYCLE_COUNTS.put(Operation.LDX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4);
		CYCLE_COUNTS.put(Operation.LDY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.LSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.NOP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.ORA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 3);
		CYCLE_COUNTS.put(Operation.PHA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 3);
		CYCLE_COUNTS.put(Operation.PHP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 4);
		CYCLE_COUNTS.put(Operation.PLA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 4);
		CYCLE_COUNTS.put(Operation.PLP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.ROL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CYCLE_COUNTS.put(Operation.ROR, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 6);
		CYCLE_COUNTS.put(Operation.RTI, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 6);
		CYCLE_COUNTS.put(Operation.RTS, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CYCLE_COUNTS.put(Operation.SBC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.SEC, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.SED, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.SEI, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 5).set(AddressingMode.ABSOLUTE_Y_INDEXED, 5).set(AddressingMode.PRE_INDEXED_INDIRECT, 6);
		modeMap.set(AddressingMode.POST_INDEXED_INDIRECT, 6);
		CYCLE_COUNTS.put(Operation.STA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		CYCLE_COUNTS.put(Operation.STX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		CYCLE_COUNTS.put(Operation.STY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TAX, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TAY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TSX, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TXA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TXS, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CYCLE_COUNTS.put(Operation.TYA, modeMap);
		
		/*
		*  Build map of Operation/Addr. Mode -> Byte Count (for program counter)
		*/
		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.ADC, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.AND, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.ASL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BCC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BCS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BEQ, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.BIT, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BMI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BNE, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BPL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.BRK, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BVC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		BYTE_COUNTS.put(Operation.BVS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.CLC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.CLD, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.CLI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.CLV, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.CMP, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.CPX, modeMap);  

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.CPY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.DEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.DEX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.DEY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.EOR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.INC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.INX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.INY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.INDIRECT, 3);
		BYTE_COUNTS.put(Operation.JMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.JSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.LDA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		BYTE_COUNTS.put(Operation.LDX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.LDY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.LSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.NOP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.ORA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.PHA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.PHP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.PLA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.PLP, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.ROL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		BYTE_COUNTS.put(Operation.ROR, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.RTI, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.RTS, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.SBC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.SEC, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.SED, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.SEI, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2);
		modeMap.set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		BYTE_COUNTS.put(Operation.STA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.STX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		BYTE_COUNTS.put(Operation.STY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TAX, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TAY, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TSX, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TXA, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TXS, modeMap); 

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		BYTE_COUNTS.put(Operation.TYA, modeMap); 
	}
	
	class ChainedHashMap<K,V> extends HashMap<K,V> {
		public ChainedHashMap<K,V> set(K key, V value) {
			this.put(key, value);
			return this;
		}
	}
}