package edu.course.games.cats256.ui;

import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.centered;
import static edu.course.platform.desktop.GameDrawing.palette;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class Cats256Renderer {
  private Cats256Renderer() {}

  static void draw(Graphics2D g, int[][] board) {

    for (int r = 0; r < 4; r++)
      for (int c = 0; c < 4; c++) {
        int v = board[r][c];
        box(
            g,
            260 + c * 110,
            150 + r * 110,
            100,
            100,
            v == 0 ? SLATE : palette(1 + (Integer.numberOfTrailingZeros(v) % 4)));
        if (v > 0) centered(g, "" + v, 260 + c * 110, 150 + r * 110, 100, 100, 28, WHITE);
      }
  }
}
