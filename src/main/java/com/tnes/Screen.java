package com.tnes;

import processing.core.PApplet;
import processing.core.PImage;

import com.tnes.NES.FrameCompleteEvent;
import com.tnes.NES.IFrameCompleteHandler;
import com.tnes.NES.NESEvent;

public class Screen extends PApplet {
	private static final long serialVersionUID = 1L;
	private Debugger debugger = Debugger.getInstance();
	private final NES nes;
	private final PaletteViewer paletteViewer;
	private final PatternTablesViewer patternTablesViewer;
	private boolean paletteViewerShown = false;
	private boolean patternTableViewerShown = false;
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
	private int PALETTE_VIEWER_Y = 241;
	private int PALETTE_VIEWER_W = 256;
	private int PALETTE_VIEWER_H = 32;

	// Pattern Table Canvas Area
	private int PATTERN_TABLE_VIEWER_X = 0;
	private int PATTERN_TABLE_VIEWER_Y = 0;
	private int PATTERN_TABLE_VIEWER_W = 128;
	private int PATTERN_TABLE_VIEWER_H = 256;

	public Screen(final NES nes) {
		super();
		this.nes = nes;
		this.paletteViewer = new PaletteViewer(nes);
		this.patternTablesViewer = new PatternTablesViewer(nes);

		addDebugCommands();
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
		if (nes.isPoweredOn()) {
			repaint();

			if (paletteViewerShown)
				paletteViewer.repaint();
		}

		if (patternTableViewerShown)
			patternTablesViewer.repaint();
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
		if (canvasImage != null)
			image(canvasImage, CANVAS_X, CANVAS_Y, CANVAS_W, CANVAS_H);

		if (paletteViewerShown && paletteViewer != null && paletteViewer.getImage() != null) {
			image(paletteViewer.getImage(), PALETTE_VIEWER_X, PALETTE_VIEWER_Y, PALETTE_VIEWER_W, PALETTE_VIEWER_H);
		} else {
			fill(0xFF, 0xFF, 0xFF);
			rect(BOTTOM_PANEL_X, BOTTOM_PANEL_Y, BOTTOM_PANEL_W, BOTTOM_PANEL_H);
		}

		if (patternTableViewerShown && patternTablesViewer != null && patternTablesViewer.getImage() != null)
			image(patternTablesViewer.getImage(), PATTERN_TABLE_VIEWER_X, PATTERN_TABLE_VIEWER_Y, PATTERN_TABLE_VIEWER_W, PATTERN_TABLE_VIEWER_H);

	}

	/*
	 * Debug commands
	 */
	private void addDebugCommands() {
		try {
			debugger.addCommand("togglePaletteViewer", Screen.class.getMethod("__togglePaletteViewer", String.class), this);
			debugger.addCommand("togglePatternTableViewer", Screen.class.getMethod("__togglePatternTableViewer", String.class), this);

		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}
	}

	public void __togglePaletteViewer(String param) {
		paletteViewerShown = (paletteViewerShown) ? false : true;
	}

	public void __togglePatternTableViewer(String param) {
		patternTableViewerShown = (patternTableViewerShown) ? false : true;
	}

	public class PaletteViewer {
		private final NES nes;
		private PImage image;

		public PaletteViewer(final NES nes) {
			this.nes = nes;
		}

		public PImage getImage() {
			return image;
		}

		public void repaint() {
			PImage img = createImage(PALETTE_VIEWER_W, PALETTE_VIEWER_H, RGB);
			MMC mmc = nes.getMMC();

			int[] palette = new int[32];
			for (int i = Constants.IMAGE_PALETTE_LO; i <= Constants.SPRITE_PALETTE_HI; i++) {
				palette[i - Constants.IMAGE_PALETTE_LO] = mmc.readPPUMem(i);
			}

			img.loadPixels();
			for (int i = 0; i < 32; i++) {
				int color = Palette.COLORS[palette[i]];
				int pColor = color((color & 0xFF0000) >> 16, (color & 0xFF00) >> 8, (color & 0xFF));
				int xOffset = (i % 16) * 16;
				int yOffset = (i / 16) * 16;
				for (int x = 0; x < 16; x++) {
					for (int y = 0; y < 16; y++) {
						img.pixels[((yOffset + y) * 256) + (xOffset + x)] = pColor;
					}
				}
			}
			img.updatePixels();

			this.image = img;
		}

	}

	public class PatternTablesViewer {
		private final NES nes;
		private PImage image;

		public PatternTablesViewer(final NES nes) {
			this.nes = nes;
		}

		public PImage getImage() {
			return image;
		}

		public void repaint() {
			PImage img = createImage(PATTERN_TABLE_VIEWER_W, PATTERN_TABLE_VIEWER_H, RGB);
			MMC mmc = nes.getMMC();

			short[][] patternTable0PaletteBuffer = new short[128][128];
			short[][] patternTable1PaletteBuffer = new short[128][128];

			// Fill in onscreen buffers from the pattern tables
			for (int index = Constants.PATTERN_TABLE_0_LO; index <= Constants.PATTERN_TABLE_0_HI; index++) {
				if ((index % 16) < 8) {
					int tile = (int) Math.floor(index / 16); // Tiles are 16
					// bytes a piece
					int tileRow = (int) Math.floor(tile / 16); // 16 tiles in a
					// scanline
					int scanlineIndex = (tileRow * 8) + (index % 8);
					int pixelIndex = (tile - (tileRow * 16)) * 8;

					short patternTableByte = mmc.readPPUMem(index);
					short patternTableByte2 = mmc.readPPUMem(index + 8);
					short[] pixels = combinePatternTableBytes(patternTableByte, patternTableByte2);
					for (int i = 0; i <= 7; i++) {
						patternTable0PaletteBuffer[scanlineIndex][pixelIndex + i] = pixels[i];
					}
				}
			}

			for (int index = Constants.PATTERN_TABLE_1_LO; index <= Constants.PATTERN_TABLE_1_HI; index++) {
				if ((index % 16) < 8) {
					int tile = (int) Math.floor((index - Constants.PATTERN_TABLE_1_LO) / 16); // Tiles
					// are
					// 16
					// bytes
					// a
					// piece
					int tileRow = (int) Math.floor(tile / 16); // 16 tiles in a
					// scanline
					int scanlineIndex = (tileRow * 8) + (index % 8);
					int pixelIndex = (tile - (tileRow * 16)) * 8;

					short patternTableByte = mmc.readPPUMem(index);
					short patternTableByte2 = mmc.readPPUMem(index + 8);
					short[] pixels = combinePatternTableBytes(patternTableByte, patternTableByte2);
					for (int i = 0; i <= 7; i++) {
						patternTable1PaletteBuffer[scanlineIndex][pixelIndex + i] = pixels[i];
					}
				}
			}

			img.loadPixels();
			for (int scanline = 0; scanline < patternTable0PaletteBuffer.length; scanline++) {
				short[] line = patternTable0PaletteBuffer[scanline];
				for (short pixel = 0; pixel < line.length; pixel++) {
					int dot = Palette.COLORS[line[pixel]];
					img.pixels[(scanline * 128) + pixel] = color((dot & 0xFF0000) >> 16, (dot & 0xFF00) >> 8, (dot & 0xFF));
				}
			}

			for (int scanline = 0; scanline < patternTable1PaletteBuffer.length; scanline++) {
				short[] line = patternTable1PaletteBuffer[scanline];
				for (short pixel = 0; pixel < line.length; pixel++) {
					int dot = Palette.COLORS[line[pixel]];
					img.pixels[((scanline + 128) * 128) + pixel] = color((dot & 0xFF0000) >> 16, (dot & 0xFF00) >> 8, (dot & 0xFF));
				}
			}
			img.updatePixels();

			this.image = img;
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
	}
}
