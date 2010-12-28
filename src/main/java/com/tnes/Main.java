package com.tnes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.tnes.NES.NESEvent;

public class Main {
	private static final long serialVersionUID = 1L;

	public Main() {
	}

	public static void main(String[] args) {
		final ResourceBundle resourceBundle = ResourceBundle.getBundle("tnes");
		final JFrame window = new JFrame(resourceBundle.getString("com.tnes.windowTitle"));
		final JMenuBar menuBar = new JMenuBar();
		final JMenu system = new JMenu(resourceBundle.getString("com.tnes.menu.system"));
		final JMenuItem loadROM = new JMenuItem(resourceBundle.getString("com.tnes.menu.system.loadROM"));
		final JCheckBoxMenuItem power = new JCheckBoxMenuItem(resourceBundle.getString("com.tnes.menu.system.power"));
		final JMenuItem reset = new JMenuItem(resourceBundle.getString("com.tnes.menu.system.reset"));

		final NES nes = new NES();
		final Debugger debugger = Debugger.getInstance();
		boolean debugging = false;

		/*
		 * Build the window
		 */
		window.setSize(256, 321);
		window.setVisible(true);
		window.setJMenuBar(menuBar);

		loadROM.addActionListener(new Main.NESAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nes.powerOff();

				JFileChooser fileChooser = new JFileChooser(new File("."));

				int rVal = fileChooser.showOpenDialog(window);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					File romFile = fileChooser.getSelectedFile(); // Returns a
					// Java File
					String sROMFilePath = romFile.getAbsolutePath();
					String sROMFile = romFile.getName();
					if (sROMFilePath != null && !sROMFilePath.isEmpty()) {
						window.setTitle(resourceBundle.getString("com.tnes.windowTitle") + ": " + sROMFile);
						nes.loadROM(sROMFilePath);
					}
				}

			}
		});
		loadROM.setText(resourceBundle.getString("com.tnes.menu.system.loadROM"));

		power.addItemListener(new Main.NESToggleAction() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					nes.powerOn();
				else if (e.getStateChange() == ItemEvent.DESELECTED)
					nes.powerOff();
			}
		});
		power.setText(resourceBundle.getString("com.tnes.menu.system.power"));
		nes.addHandler(new NES.IPowerOnHandler() {
			public void handleEvent(NESEvent e) {
				power.setSelected(true);
			}
		});
		nes.addHandler(new NES.IPowerOffHandler() {
			public void handleEvent(NESEvent e) {
				power.setSelected(false);
			}
		});

		reset.addActionListener(new Main.NESAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nes.reset();
			}
		});
		reset.setText(resourceBundle.getString("com.tnes.menu.system.reset"));

		// Build the system menu
		system.add(loadROM);
		system.add(power);
		system.add(reset);
		menuBar.add(system);

		// Build Processing screen
		Screen screen = new Screen();
		window.add(screen);

		/* Read command line args */
		String romFile = "";
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

	public static class NESAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}

	public static class NESToggleAction implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
		}
	}
}
