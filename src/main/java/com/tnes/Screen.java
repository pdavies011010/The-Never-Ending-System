package com.tnes;

import processing.core.PApplet;
import processing.core.PImage;

import com.tnes.NES.FrameCompleteEvent;
import com.tnes.NES.IFrameCompleteHandler;
import com.tnes.NES.NESEvent;

public class Screen extends PApplet {
	private static final long serialVersionUID = 1L;
	private final NES nes;
	private final PaletteViewer paletteViewer;
	private final PatternTablesViewer patternTablesViewer;
	private PImage canvasImage;

	// Game Canvas Area
	private int CANVAS_X = 0;
	private int CANVAS_Y = 0;
	private int CANVAS_W = 256;
	private int CANVAS_H = 241;

	private int BOTTOM_PANEL_X = 0;
	private int BOTTOM_PANEL_Y = 241;
	private int BOTTOM_PANEL_W = 256;
	private int BOTTOM_PANEL_H = 59;

	// Palette Viewer Canvas Area
	private int PALETTE_VIEWER_X = 0;
	private int PALETTE_VIEWER_Y = 250;
	private int PALETTE_VIEWER_W = 256;
	private int PALETTE_VIEWER_H = 32;

	// Pattern Table Canvas Area
	private int PATTERN_TABLE_VIEWER_X = 0;
	private int PATTERN_TABLE_VIEWER_Y = 0;
	private int PATTERN_TABLE_VIEWER_W = 128;
	private int PATTERN_TABLE_VIEWER_H = 256;

	private boolean paletteViewerShown = false;
	private boolean patternTableViewerShown = false;

	public Screen(final NES nes) {
		super();
		this.nes = nes;
		this.paletteViewer = new PaletteViewer(nes);
		this.patternTablesViewer = new PatternTablesViewer(nes);
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

		size(356, 300, P2D);

		// Bottom Panel
		fill(0xFF, 0xFF, 0xFF);
		rect(BOTTOM_PANEL_X, BOTTOM_PANEL_Y, BOTTOM_PANEL_W, BOTTOM_PANEL_H);

		// NTSC refresh rate (Should Be) 1/30 of a second
		frameRate(30);

		nes.addHandler(FrameCompleteEvent.class, new IFrameCompleteHandler() {
			public void handleEvent(NESEvent e) {
				update();
			}
		});
	}

	public void update() {
		if (patternTableViewerShown) {
			patternTablesViewer.repaint();
		} else if (nes.isPoweredOn()) {
			repaint();

			if (paletteViewerShown)
				paletteViewer.repaint();
		}
	}

	public void repaint() {
		/*
		 * TODO: We might be overdoing it with creating a new image on every
		 * repaint (every frame) vs. just using a single global one.
		 * imageLoadPixels/imageUpdatePixels might take care of that for us.
		 * This applies to the pattern table/palette viewers as well.
		 */
		PImage img = createImage(CANVAS_W, CANVAS_H, RGB);
		PPU ppu = nes.getPPU();

		img.loadPixels();
		/*
		 * Loop through the scanlines (scanline 0 is a dummy)
		 */
		short[][] buffer = ppu.getScreenBuffer();
		for (int i = 1; i < buffer.length; i++) {
			for (int j = 0; j < buffer[i].length; j++) {
				int pixel = Palette.COLORS[buffer[i][j]];
				img.pixels[((i - 1) * 256) + j] = color(((pixel & 0xFF0000) >> 16), ((pixel & 0xFF00) >> 8), (pixel & 0xFF));
			}
		}
		img.updatePixels();

		this.canvasImage = img;
	}

	public void draw() {
		if (patternTableViewerShown && patternTablesViewer != null && patternTablesViewer.getImage() != null)
			image(patternTablesViewer.getImage(), PATTERN_TABLE_VIEWER_X, PATTERN_TABLE_VIEWER_Y, PATTERN_TABLE_VIEWER_W, PATTERN_TABLE_VIEWER_H);

		if (paletteViewerShown && paletteViewer != null && paletteViewer.getImage() != null)
			image(paletteViewer.getImage(), PALETTE_VIEWER_X, PALETTE_VIEWER_Y, PALETTE_VIEWER_W, PALETTE_VIEWER_H);

		if (canvasImage != null)
			image(canvasImage, CANVAS_X, CANVAS_Y, CANVAS_W, CANVAS_H);
	}

	private short[] combinePatternTableBytes(short byte0, short byte1) {
		short[] result = new short[8];

		result[0] = (short) (((byte0 & 0x80) >> 7) | ((byte1 & 0x80) >> 6));
		result[1] = (short) (((byte0 & 0x40) >> 6) | ((byte1 & 0x40) >> 5));
		result[2] = (short) (((byte0 & 0x20) >> 5) | ((byte1 & 0x20) >> 4));
		result[3] = (short) (((byte0 & 0x10) >> 4) | ((byte1 & 0x10) >> 3));
		result[4] = (short) (((byte0 & 0x08) >> 3) | ((byte1 & 0x08) >> 2));
		result[5] = (short) (((byte0 & 0x04) >> 2) | ((byte1 & 0x04) >> 1));
		result[6] = (short) (((byte0 & 0x02) >> 1) | (byte1 & 0x02));
		result[7] = (short) ((byte0 & 0x01) | ((byte1 & 0x01) << 1));

		return result;
	}

	public class PaletteViewer {
		private final NES nes;
		private PImage image;

		public PaletteViewer(final NES nes) {
			this.nes = nes;
		}

		public void repaint() {
			PImage img = createImage(PALETTE_VIEWER_W, PALETTE_VIEWER_H, RGB);

			this.image = img;
		}

		public PImage getImage() {
			return image;
		}

	}

	public class PatternTablesViewer {
		private final NES nes;
		private PImage image;

		public PatternTablesViewer(final NES nes) {
			this.nes = nes;
		}

		public void repaint() {
			PImage img = createImage(PATTERN_TABLE_VIEWER_W, PATTERN_TABLE_VIEWER_H, RGB);

			this.image = img;
		}

		public PImage getImage() {
			return image;
		}
	}
}
