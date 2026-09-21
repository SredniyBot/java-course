package edu.course.games.marsmines.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;

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
        if (flags[r][c]) {
          g.setColor(GOLD);
          g.drawLine(x + 15, y + 12, x + 15, y + 34);
          g.fillPolygon(new int[] {x + 15, x + 33, x + 15}, new int[] {y + 12, y + 20, y + 26}, 3);
        } else if (open[r][c] && (mines[r][c] || numbers[r][c] > 0))
          edu.course.platform.desktop.GameDrawing.centered(
              g, mines[r][c] ? "×" : "" + numbers[r][c], x, y, 46, 46, 24, WHITE);
      }
  }
}
