package com.tnes;

public enum AddressingMode {
	IMMEDIATE, ABSOLUTE, ZERO_PAGE, IMPLIED, ACCUMULATOR, ZERO_PAGE_X_INDEXED, ZERO_PAGE_Y_INDEXED, ABSOLUTE_X_INDEXED, ABSOLUTE_Y_INDEXED, INDIRECT, PRE_INDEXED_INDIRECT, POST_INDEXED_INDIRECT, RELATIVE;

	public String toString() {
		String result = "";

		if (this == AddressingMode.IMMEDIATE)
			result = "Immediate";
		else if (this == AddressingMode.ABSOLUTE)
			result = "Absolute";
		else if (this == AddressingMode.ZERO_PAGE)
			result = "Zero Page";
		else if (this == AddressingMode.IMPLIED)
			result = "Implied";
		else if (this == AddressingMode.ACCUMULATOR)
			result = "Accumulator";
		else if (this == AddressingMode.ZERO_PAGE_X_INDEXED)
			result = "Zero-Page X Indexed";
		else if (this == AddressingMode.ZERO_PAGE_Y_INDEXED)
			result = "Zero-Page Y Indexed";
		else if (this == AddressingMode.ABSOLUTE_X_INDEXED)
			result = "Absolute X Indexed";
		else if (this == AddressingMode.ABSOLUTE_Y_INDEXED)
			result = "Absolute Y Indexed";
		else if (this == AddressingMode.INDIRECT)
			result = "Indirect";
		else if (this == AddressingMode.PRE_INDEXED_INDIRECT)
			result = "Pre-Indexed Indirect";
		else if (this == AddressingMode.POST_INDEXED_INDIRECT)
			result = "Post-Indexed Indirect";
		else if (this == AddressingMode.RELATIVE)
			result = "Relative";

		return result;
	}
}