package com.tnes;

public class MainNoGraphics {
	public static void main(String[] args) {
		NES nes = new NES();

		if (args.length < 1)
			nes.loadROM(args[0]);

		nes.powerOn();
	}
}
