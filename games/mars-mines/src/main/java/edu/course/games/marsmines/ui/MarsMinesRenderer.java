package edu.course.games.marsmines.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class MarsMinesRenderer {
  private MarsMinesRenderer() {}

  static void draw(
      Graphics2D g, boolean[][] mines, boolean[][] open, boolean[][] flags, int[][] numbers) {

    for (int r = 0; r < 9; r++)
      for (int c = 0; c < 9; c++) {
        int x = 250 + c * 50, y = 140 + r * 50;
        box(g, x, y, 46, 46, open[r][c] ? SLATE : BLUE);
        if (flags[r][c]) text(g, "!", x + 17, y + 32, 25, GOLD);
        else if (open[r][c])
          text(g, mines[r][c] ? "*" : "" + numbers[r][c], x + 16, y + 32, 24, WHITE);
      }
  }
}
