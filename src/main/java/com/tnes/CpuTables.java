package com.tnes;

import java.util.HashMap;
import java.util.Map;

/*
 * Singleton class, use 'getInstance()'
 */
public class CpuTables {
	private static CpuTables cpuTables;

	private CpuTables() {
	}

	public static CpuTables getInstance() {
		if (cpuTables == null) {
			cpuTables = new CpuTables();
		}

		return cpuTables;
	}

	// Operation Hash (OPERATIONS[opcode] -> operation)
	public Map<Short, Operation> Operations = new HashMap<Short, Operation>();
	// Addressing Mode hash (ADDRESSING_MODES[opcode] -> addressing_mode)
	public Map<Short, AddressingMode> AdressingModes = new HashMap<Short, AddressingMode>();
	// Cycle Count hashes (CYCLE_COUNTS[operation][addressing_mode] ->
	// cycle_count)
	public Map<Operation, Map<AddressingMode, Integer>> CycleCounts = new HashMap<Operation, Map<AddressingMode, Integer>>();
	// Byte Count hashes (instruction length)
	// (BYTE_COUNTS[operation][addressing_mode] -> short_count)
	public Map<Operation, Map<AddressingMode, Integer>> ByteCounts = new HashMap<Operation, Map<AddressingMode, Integer>>();

	/*
	 * TODO: This stuff should probably be kept in a properties file.
	 */
	{
		/*
		 * Build map of Opcode -> Operation
		 */
		Operations.put(Opcode.ADCI, Operation.ADC);
		Operations.put(Opcode.ADCZ, Operation.ADC);
		Operations.put(Opcode.ADCZX, Operation.ADC);
		Operations.put(Opcode.ADCA, Operation.ADC);
		Operations.put(Opcode.ADCAX, Operation.ADC);
		Operations.put(Opcode.ADCAY, Operation.ADC);
		Operations.put(Opcode.ADCIX, Operation.ADC);
		Operations.put(Opcode.ADCIY, Operation.ADC);
		Operations.put(Opcode.ANDI, Operation.AND);
		Operations.put(Opcode.ANDZ, Operation.AND);
		Operations.put(Opcode.ANDZX, Operation.AND);
		Operations.put(Opcode.ANDA, Operation.AND);
		Operations.put(Opcode.ANDAX, Operation.AND);
		Operations.put(Opcode.ANDAY, Operation.AND);
		Operations.put(Opcode.ANDIX, Operation.AND);
		Operations.put(Opcode.ANDIY, Operation.AND);
		Operations.put(Opcode.ASL, Operation.ASL);
		Operations.put(Opcode.ASLZ, Operation.ASL);
		Operations.put(Opcode.ASLZX, Operation.ASL);
		Operations.put(Opcode.ASLA, Operation.ASL);
		Operations.put(Opcode.ASLAX, Operation.ASL);
		Operations.put(Opcode.BCC, Operation.BCC);
		Operations.put(Opcode.BCS, Operation.BCS);
		Operations.put(Opcode.BEQ, Operation.BEQ);
		Operations.put(Opcode.BITZ, Operation.BIT);
		Operations.put(Opcode.BITA, Operation.BIT);
		Operations.put(Opcode.BMI, Operation.BMI);
		Operations.put(Opcode.BNE, Operation.BNE);
		Operations.put(Opcode.BPL, Operation.BPL);
		Operations.put(Opcode.BRK, Operation.BRK);
		Operations.put(Opcode.BVC, Operation.BVC);
		Operations.put(Opcode.BVS, Operation.BVS);
		Operations.put(Opcode.CLC, Operation.CLC);
		Operations.put(Opcode.CLD, Operation.CLD);
		Operations.put(Opcode.CLI, Operation.CLI);
		Operations.put(Opcode.CLV, Operation.CLV);
		Operations.put(Opcode.CMPI, Operation.CMP);
		Operations.put(Opcode.CMPZ, Operation.CMP);
		Operations.put(Opcode.CMPZX, Operation.CMP);
		Operations.put(Opcode.CMPA, Operation.CMP);
		Operations.put(Opcode.CMPAX, Operation.CMP);
		Operations.put(Opcode.CMPAY, Operation.CMP);
		Operations.put(Opcode.CMPIX, Operation.CMP);
		Operations.put(Opcode.CMPIY, Operation.CMP);
		Operations.put(Opcode.CPXI, Operation.CPX);
		Operations.put(Opcode.CPXZ, Operation.CPX);
		Operations.put(Opcode.CPXA, Operation.CPX);
		Operations.put(Opcode.CPYI, Operation.CPY);
		Operations.put(Opcode.CPYZ, Operation.CPY);
		Operations.put(Opcode.CPYA, Operation.CPY);
		Operations.put(Opcode.DECZ, Operation.DEC);
		Operations.put(Opcode.DECZX, Operation.DEC);
		Operations.put(Opcode.DECA, Operation.DEC);
		Operations.put(Opcode.DECAX, Operation.DEC);
		Operations.put(Opcode.DEX, Operation.DEX);
		Operations.put(Opcode.DEY, Operation.DEY);
		Operations.put(Opcode.EORI, Operation.EOR);
		Operations.put(Opcode.EORZ, Operation.EOR);
		Operations.put(Opcode.EORZX, Operation.EOR);
		Operations.put(Opcode.EORA, Operation.EOR);
		Operations.put(Opcode.EORAX, Operation.EOR);
		Operations.put(Opcode.EORAY, Operation.EOR);
		Operations.put(Opcode.EORIX, Operation.EOR);
		Operations.put(Opcode.EORIY, Operation.EOR);
		Operations.put(Opcode.INCZ, Operation.INC);
		Operations.put(Opcode.INCZX, Operation.INC);
		Operations.put(Opcode.INCA, Operation.INC);
		Operations.put(Opcode.INCAX, Operation.INC);
		Operations.put(Opcode.INX, Operation.INX);
		Operations.put(Opcode.INY, Operation.INY);
		Operations.put(Opcode.JMPA, Operation.JMP);
		Operations.put(Opcode.JMPI, Operation.JMP);
		Operations.put(Opcode.JSRA, Operation.JSR);
		Operations.put(Opcode.LDAI, Operation.LDA);
		Operations.put(Opcode.LDAZ, Operation.LDA);
		Operations.put(Opcode.LDAZX, Operation.LDA);
		Operations.put(Opcode.LDAA, Operation.LDA);
		Operations.put(Opcode.LDAAX, Operation.LDA);
		Operations.put(Opcode.LDAAY, Operation.LDA);
		Operations.put(Opcode.LDAIX, Operation.LDA);
		Operations.put(Opcode.LDAIY, Operation.LDA);
		Operations.put(Opcode.LDXI, Operation.LDX);
		Operations.put(Opcode.LDXZ, Operation.LDX);
		Operations.put(Opcode.LDXZY, Operation.LDX);
		Operations.put(Opcode.LDXA, Operation.LDX);
		Operations.put(Opcode.LDXAY, Operation.LDX);
		Operations.put(Opcode.LDYI, Operation.LDY);
		Operations.put(Opcode.LDYZ, Operation.LDY);
		Operations.put(Opcode.LDYZX, Operation.LDY);
		Operations.put(Opcode.LDYA, Operation.LDY);
		Operations.put(Opcode.LDYAX, Operation.LDY);
		Operations.put(Opcode.LSR, Operation.LSR);
		Operations.put(Opcode.LSRZ, Operation.LSR);
		Operations.put(Opcode.LSRZX, Operation.LSR);
		Operations.put(Opcode.LSRA, Operation.LSR);
		Operations.put(Opcode.LSRAX, Operation.LSR);
		Operations.put(Opcode.NOP, Operation.NOP);
		Operations.put(Opcode.ORAI, Operation.ORA);
		Operations.put(Opcode.ORAZ, Operation.ORA);
		Operations.put(Opcode.ORAZX, Operation.ORA);
		Operations.put(Opcode.ORAA, Operation.ORA);
		Operations.put(Opcode.ORAAX, Operation.ORA);
		Operations.put(Opcode.ORAAY, Operation.ORA);
		Operations.put(Opcode.ORAIX, Operation.ORA);
		Operations.put(Opcode.ORAIY, Operation.ORA);
		Operations.put(Opcode.PHA, Operation.PHA);
		Operations.put(Opcode.PHP, Operation.PHP);
		Operations.put(Opcode.PLA, Operation.PLA);
		Operations.put(Opcode.PLP, Operation.PLP);
		Operations.put(Opcode.ROL, Operation.ROL);
		Operations.put(Opcode.ROLZ, Operation.ROL);
		Operations.put(Opcode.ROLZX, Operation.ROL);
		Operations.put(Opcode.ROLA, Operation.ROL);
		Operations.put(Opcode.ROLAX, Operation.ROL);
		Operations.put(Opcode.ROR, Operation.ROR);
		Operations.put(Opcode.RORZ, Operation.ROR);
		Operations.put(Opcode.RORZX, Operation.ROR);
		Operations.put(Opcode.RORA, Operation.ROR);
		Operations.put(Opcode.RORAX, Operation.ROR);
		Operations.put(Opcode.RTI, Operation.RTI);
		Operations.put(Opcode.RTS, Operation.RTS);
		Operations.put(Opcode.SBCI, Operation.SBC);
		Operations.put(Opcode.SBCZ, Operation.SBC);
		Operations.put(Opcode.SBCZX, Operation.SBC);
		Operations.put(Opcode.SBCA, Operation.SBC);
		Operations.put(Opcode.SBCAX, Operation.SBC);
		Operations.put(Opcode.SBCAY, Operation.SBC);
		Operations.put(Opcode.SBCIX, Operation.SBC);
		Operations.put(Opcode.SBCIY, Operation.SBC);
		Operations.put(Opcode.SEC, Operation.SEC);
		Operations.put(Opcode.SED, Operation.SED);
		Operations.put(Opcode.SEI, Operation.SEI);
		Operations.put(Opcode.STAZ, Operation.STA);
		Operations.put(Opcode.STAZX, Operation.STA);
		Operations.put(Opcode.STAA, Operation.STA);
		Operations.put(Opcode.STAAX, Operation.STA);
		Operations.put(Opcode.STAAY, Operation.STA);
		Operations.put(Opcode.STAIX, Operation.STA);
		Operations.put(Opcode.STAIY, Operation.STA);
		Operations.put(Opcode.STXZ, Operation.STX);
		Operations.put(Opcode.STXZX, Operation.STX);
		Operations.put(Opcode.STXA, Operation.STX);
		Operations.put(Opcode.STYZ, Operation.STY);
		Operations.put(Opcode.STYZX, Operation.STY);
		Operations.put(Opcode.STYA, Operation.STY);
		Operations.put(Opcode.TAX, Operation.TAX);
		Operations.put(Opcode.TAY, Operation.TAY);
		Operations.put(Opcode.TSX, Operation.TSX);
		Operations.put(Opcode.TXA, Operation.TXA);
		Operations.put(Opcode.TXS, Operation.TXS);
		Operations.put(Opcode.TYA, Operation.TYA);

		/*
		 * Build map of Opcode -> Addressing Mode
		 */
		AdressingModes.put(Opcode.ADCI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.ANDI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.CMPI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.CPXI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.CPYI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.EORI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.LDAI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.LDXI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.LDYI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.ORAI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.SBCI, AddressingMode.IMMEDIATE);
		AdressingModes.put(Opcode.ADCA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.ANDA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.ASLA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.BITA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.CMPA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.CPXA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.CPYA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.DECA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.EORA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.INCA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.JMPA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.JSRA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.LDAA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.LDXA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.LDYA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.LSRA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.ORAA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.ROLA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.RORA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.SBCA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.STAA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.STXA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.STYA, AddressingMode.ABSOLUTE);
		AdressingModes.put(Opcode.ADCZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.ANDZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.ASLZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.BITZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.CMPZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.CPXZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.CPYZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.DECZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.EORZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.INCZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.LDAZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.LDXZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.LDYZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.LSRZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.ORAZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.ROLZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.RORZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.SBCZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.STAZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.STXZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.STYZ, AddressingMode.ZERO_PAGE);
		AdressingModes.put(Opcode.BRK, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.CLC, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.CLD, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.CLI, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.CLV, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.DEX, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.DEY, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.INX, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.INY, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.NOP, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.PHA, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.PHP, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.PLA, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.PLP, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.RTI, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.RTS, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.SEC, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.SED, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.SEI, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TAX, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TAY, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TSX, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TXA, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TXS, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.TYA, AddressingMode.IMPLIED);
		AdressingModes.put(Opcode.ASL, AddressingMode.ACCUMULATOR);
		AdressingModes.put(Opcode.LSR, AddressingMode.ACCUMULATOR);
		AdressingModes.put(Opcode.ROL, AddressingMode.ACCUMULATOR);
		AdressingModes.put(Opcode.ROR, AddressingMode.ACCUMULATOR);
		AdressingModes.put(Opcode.ADCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.ANDZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.ASLZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.CMPZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.DECZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.EORZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.INCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.LDAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.LDYZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.LSRZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.ORAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.ROLZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.RORZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.SBCZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.STAZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.STYZX, AddressingMode.ZERO_PAGE_X_INDEXED);
		AdressingModes.put(Opcode.LDXZY, AddressingMode.ZERO_PAGE_Y_INDEXED);
		AdressingModes.put(Opcode.STXZX, AddressingMode.ZERO_PAGE_Y_INDEXED);
		AdressingModes.put(Opcode.ADCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.ANDAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.ASLAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.CMPAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.DECAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.EORAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.INCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.LDAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.LDYAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.LSRAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.ORAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.ROLAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.RORAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.SBCAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.STAAX, AddressingMode.ABSOLUTE_X_INDEXED);
		AdressingModes.put(Opcode.ADCAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.ANDAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.CMPAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.EORAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.LDAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.LDXAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.ORAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.SBCAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.STAAY, AddressingMode.ABSOLUTE_Y_INDEXED);
		AdressingModes.put(Opcode.JMPI, AddressingMode.INDIRECT);
		AdressingModes.put(Opcode.ADCIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.ANDIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.CMPIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.EORIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.LDAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.ORAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.SBCIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.STAIX, AddressingMode.PRE_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.ADCIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.ANDIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.CMPIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.EORIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.LDAIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.ORAIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.SBCIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.STAIY, AddressingMode.POST_INDEXED_INDIRECT);
		AdressingModes.put(Opcode.BCC, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BCS, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BEQ, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BMI, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BNE, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BPL, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BVC, AddressingMode.RELATIVE);
		AdressingModes.put(Opcode.BVS, AddressingMode.RELATIVE);

		/*
		 * Build map of Operation/Addr. Mode -> Cycle count
		 */
		ChainedHashMap<AddressingMode, Integer> modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.ADC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.AND, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.ASL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BCC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BCS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BEQ, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CycleCounts.put(Operation.BIT, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BMI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BNE, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BPL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 7);
		CycleCounts.put(Operation.BRK, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BVC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		CycleCounts.put(Operation.BVS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.CLC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.CLD, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.CLI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.CLV, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.CMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CycleCounts.put(Operation.CPX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ABSOLUTE, 4);
		CycleCounts.put(Operation.CPY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6).set(AddressingMode.ABSOLUTE, 6);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.DEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.DEX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.DEY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.EOR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6).set(AddressingMode.ABSOLUTE, 6);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.INC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.INX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.INY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.INDIRECT, 5);
		CycleCounts.put(Operation.JMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 6);
		CycleCounts.put(Operation.JSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.LDA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		CycleCounts.put(Operation.LDX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4);
		CycleCounts.put(Operation.LDY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.LSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.NOP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.ORA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 3);
		CycleCounts.put(Operation.PHA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 3);
		CycleCounts.put(Operation.PHP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 4);
		CycleCounts.put(Operation.PLA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 4);
		CycleCounts.put(Operation.PLP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.ROL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 2).set(AddressingMode.ZERO_PAGE, 5).set(AddressingMode.ZERO_PAGE_X_INDEXED, 6);
		modeMap.set(AddressingMode.ABSOLUTE, 6).set(AddressingMode.ABSOLUTE_X_INDEXED, 7);
		CycleCounts.put(Operation.ROR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 6);
		CycleCounts.put(Operation.RTI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 6);
		CycleCounts.put(Operation.RTS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4);
		modeMap.set(AddressingMode.ABSOLUTE, 4).set(AddressingMode.ABSOLUTE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE_Y_INDEXED, 4);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 6).set(AddressingMode.POST_INDEXED_INDIRECT, 5);
		CycleCounts.put(Operation.SBC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.SEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.SED, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.SEI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 5).set(AddressingMode.ABSOLUTE_Y_INDEXED, 5).set(AddressingMode.PRE_INDEXED_INDIRECT, 6);
		modeMap.set(AddressingMode.POST_INDEXED_INDIRECT, 6);
		CycleCounts.put(Operation.STA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		CycleCounts.put(Operation.STX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 3).set(AddressingMode.ZERO_PAGE_X_INDEXED, 4).set(AddressingMode.ABSOLUTE, 4);
		CycleCounts.put(Operation.STY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TAX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TAY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TSX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TXA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TXS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 2);
		CycleCounts.put(Operation.TYA, modeMap);

		/*
		 * Build map of Operation/Addr. Mode -> Byte Count (for program counter)
		 */
		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.ADC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.AND, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.ASL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BCC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BCS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BEQ, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.BIT, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BMI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BNE, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BPL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.BRK, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BVC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.RELATIVE, 2);
		ByteCounts.put(Operation.BVS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.CLC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.CLD, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.CLI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.CLV, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.CMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.CPX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.CPY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.DEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.DEX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.DEY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.EOR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.INC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.INX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.INY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.INDIRECT, 3);
		ByteCounts.put(Operation.JMP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.JSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		modeMap.set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.LDA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3);
		ByteCounts.put(Operation.LDX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.LDY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2);
		modeMap.set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.LSR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.NOP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.ORA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.PHA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.PHP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.PLA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.PLP, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.ROL, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ACCUMULATOR, 1).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3);
		ByteCounts.put(Operation.ROR, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.RTI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.RTS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMMEDIATE, 2).set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3).set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2).set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.SBC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.SEC, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.SED, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.SEI, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		modeMap.set(AddressingMode.ABSOLUTE_X_INDEXED, 3).set(AddressingMode.ABSOLUTE_Y_INDEXED, 3).set(AddressingMode.PRE_INDEXED_INDIRECT, 2);
		modeMap.set(AddressingMode.POST_INDEXED_INDIRECT, 2);
		ByteCounts.put(Operation.STA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_Y_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.STX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.ZERO_PAGE, 2).set(AddressingMode.ZERO_PAGE_X_INDEXED, 2).set(AddressingMode.ABSOLUTE, 3);
		ByteCounts.put(Operation.STY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TAX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TAY, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TSX, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TXA, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TXS, modeMap);

		modeMap = new ChainedHashMap<AddressingMode, Integer>();
		modeMap.set(AddressingMode.IMPLIED, 1);
		ByteCounts.put(Operation.TYA, modeMap);
	}

	class ChainedHashMap<K, V> extends HashMap<K, V> {
		private static final long serialVersionUID = 1L;

		public ChainedHashMap<K, V> set(K key, V value) {
			this.put(key, value);
			return this;
		}
	}
}