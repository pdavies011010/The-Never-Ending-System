package com.tnes;

import javax.swing.JFrame;

public class Main {
	private static final long serialVersionUID = 1L;

	public Main() {
	}

	public static void main(String[] args) {
		NES nes = new NES();
		Debugger debugger = Debugger.getInstance();
		JFrame window = new JFrame();
		Screen screen = new Screen();
		String romFile = "";
		boolean debugging = false;

		/*
		 * Build the window
		 */
		window.setSize(100, 100);
		window.setVisible(true);

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
		} else {
			System.out.println(String.format("ROM File passed in as: '%s'", romFile));
			debugger.readCommands();
		}
	}
}
