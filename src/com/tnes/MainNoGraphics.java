package com.tnes;

public class MainNoGraphics {
	public static void main(String[] args) {
		NES nes = new NES();
		Debugger debugger = Debugger.getInstance();
		String romFile = "";
		boolean debugging = false;
		
		/* Read command line args */
		for (String arg : args) {
			if (arg.matches("[^\\.]*\\.nes")) {
				romFile = arg;
			} else if (arg.matches("-[dD]")) {
				debugging = true;
			}
		}
		
		debugger.setDebugging(debugging);

		if (!romFile.isEmpty()) {
			nes.loadROM(romFile);
			nes.powerOn();
			
			// Loop and run PPU frames
			while (true) {
				nes.runOneFrame();
			}
		} else {
			System.out.println(String.format("ROM File passed in as: '%s'", romFile));
			debugger.readCommands();
		}
	}
}
