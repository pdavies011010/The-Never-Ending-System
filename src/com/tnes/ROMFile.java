package com.tnes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ROMFile extends File {

	private static final long serialVersionUID = 1L;
	private int prgPageCount = 0, chrPageCount = 0;
	private int romControl1 = 0, romControl2 = 0;
	private int mapper = 0;
	private List<List<Short>> prgROMPages = new ArrayList<List<Short>>();
	private List<List<Short>> chrROMPages = new ArrayList<List<Short>>();
	private int mirroring = 0;

	public ROMFile(String pathname) {
		super(pathname);

		try {
			FileReader reader = new FileReader(this);
			char[] fileType = new char[4];
			reader.read(fileType, 0, 4);
			prgPageCount = reader.read();
			chrPageCount = reader.read();
			romControl1 = reader.read();
			romControl2 = reader.read();
			mapper = (romControl1 >> 4) | romControl2;
			mirroring |= (romControl1 & 0x08) >> 2;
			mirroring = (mirroring == 0) ? (romControl1 & 0x01) : mirroring;

			// Load PRG-ROM and CHR-Pages into object variables
			prgROMPages = new ArrayList<List<Short>>(prgPageCount);
			chrROMPages = new ArrayList<List<Short>>(chrPageCount);

			// Read in data for PRG-ROM pages
			for (int i = 0; i < prgPageCount; i++) {
				prgROMPages.add(i, new ArrayList<Short>(Constants.PRG_ROM_PAGE_SIZE));
				for (int j = 0; j < Constants.PRG_ROM_PAGE_SIZE; j++) {
					prgROMPages.get(i).add(j, (short) reader.read());
				}
			}

			// Read in data for PRG-ROM pages
			for (int i = 0; i < chrPageCount; i++) {
				chrROMPages.add(i, new ArrayList<Short>(Constants.CHR_ROM_PAGE_SIZE));
				for (int j = 0; j < Constants.CHR_ROM_PAGE_SIZE; j++) {
					chrROMPages.get(i).add(j, (short) reader.read());
				}
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error opening ROM file: " + pathname);
			System.out.println(e.getMessage());
		} catch (IOException ioe) {
			System.out.println("Error reading ROM file: " + pathname);
			System.out.println(ioe.getMessage());
		}

	}

	public int getPrgPageCount() {
		return prgPageCount;
	}

	public int getChrPageCount() {
		return chrPageCount;
	}

	public int getMapper() {
		return mapper;
	}

	public int getROMControl1() {
		return romControl1;
	}

	public int getROMControl2() {
		return romControl2;
	}

	public List<List<Short>> getPrgROMPages() {
		return prgROMPages;
	}

	public List<List<Short>> getChrROMPages() {
		return chrROMPages;
	}

	public int getMirroring() {
		return mirroring;
	}

}
