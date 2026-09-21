package edu.course.games.moonsokoban.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class MoonSokobanRenderer {
  private MoonSokobanRenderer() {}

  static void draw(Graphics2D g, int[][] board, boolean[][] goals, int pr, int pc) {

    for (int r = 0; r < 7; r++)
      for (int c = 0; c < 7; c++) {
        int x = 270 + c * 60, y = 150 + r * 60;
        box(g, x, y, 56, 56, board[r][c] == 1 ? BLUE : SLATE);
        if (goals[r][c]) circle(g, x + 28, y + 28, 16, GOLD);
        if (board[r][c] == 2) box(g, x + 8, y + 8, 40, 40, GREEN);
      }
    circle(g, 298 + pc * 60, 178 + pr * 60, 19, CYAN);
  }
}
