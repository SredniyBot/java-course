package edu.course.games.pixelsymmetry.ui;

import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.palette;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class PixelSymmetryRenderer {
  private PixelSymmetryRenderer() {}

  static void draw(Graphics2D g, int[][] pixels, int color) {

    for (int r = 0; r < 12; r++)
      for (int c = 0; c < 16; c++)
        box(g, 160 + c * 40, 140 + r * 38, 37, 35, palette(pixels[r][c]));
    text(g, "Цвет: " + color, 35, 135, 20, WHITE);
  }
}
