package edu.course.games.colorflood.ui;

import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.palette;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class ColorFloodRenderer {
  private ColorFloodRenderer() {}

  static void draw(Graphics2D g, int[][] board, int moves) {

    for (int r = 0; r < 10; r++)
      for (int c = 0; c < 10; c++) {
        box(g, 255 + c * 44, 150 + r * 44, 41, 41, palette(board[r][c]));
        edu.course.platform.desktop.GameDrawing.centered(
            g, "" + board[r][c], 255 + c * 44, 150 + r * 44, 41, 41, 14, WHITE);
      }
    text(g, "Выберите цвет", 35, 198, 16, WHITE);
    for (int color = 1; color <= 4; color++) {
      box(g, 35, 220 + (color - 1) * 60, 150, 44, palette(color));
      text(g, "Клавиша " + color, 48, 248 + (color - 1) * 60, 16, WHITE);
    }
    text(g, "Ходы: " + moves + " / 24", 35, 140, 22, WHITE);
  }
}
