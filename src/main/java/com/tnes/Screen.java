package com.tnes;

import processing.core.PApplet;

public class Screen extends PApplet {
	private static final long serialVersionUID = 1L;

	// Game Canvas Area
	private int CANVAS_X = 100;
	private int CANVAS_Y = 0;
	private int CANVAS_W = 256;
	private int CANVAS_H = 241;

	private int BOTTOM_PANEL_X = 100;
	private int BOTTOM_PANEL_Y = 241;
	private int BOTTOM_PANEL_W = 256;
	private int BOTTOM_PANEL_H = 59;

	// Palette Viewer Canvas Area
	private int PALETTE_VIEWER_X = 101;
	private int PALETTE_VIEWER_Y = 250;
	private int PALETTE_VIEWER_W = 256;
	private int PALETTE_VIEWER_H = 32;

	// Pattern Table Canvas Area
	private int PATTERN_TABLE_VIEWER_X = 101;
	private int PATTERN_TABLE_VIEWER_Y = 0;
	private int PATTERN_TABLE_VIEWER_W = 128;
	private int PATTERN_TABLE_VIEWER_H = 256;

	private boolean paletteViewerShown = false;
	private boolean patternTableViewerShown = false;

	public Screen() {
		super();
	}
	
	public boolean isPaletteViewerShown() {
	    return paletteViewerShown;
    }

	public void setPaletteViewerShown(boolean paletteViewerShown) {
	    this.paletteViewerShown = paletteViewerShown;
    }

	public boolean isPatternTableViewerShown() {
	    return patternTableViewerShown;
    }

	public void setPatternTableViewerShown(boolean patternTableViewerShown) {
	    this.patternTableViewerShown = patternTableViewerShown;
    }

	@Override
	public void setup() {
		setPaletteViewerShown(false);
		setPatternTableViewerShown(false);

		size(356, 300, "P2D");

		// Bottom Panel
		fill(0xFF, 0xFF, 0xFF);
		rect(BOTTOM_PANEL_X, BOTTOM_PANEL_Y, BOTTOM_PANEL_W, BOTTOM_PANEL_H);

		// NTSC refresh rate (Should Be) 1/30 of a second
		frameRate(30);
	}
}
