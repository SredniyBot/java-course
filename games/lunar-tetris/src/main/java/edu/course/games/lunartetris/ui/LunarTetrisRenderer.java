package edu.course.games.lunartetris.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.grid;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class LunarTetrisRenderer {
  private LunarTetrisRenderer() {}

  static void draw(
      Graphics2D g, int[][] board, int[][] piece, int pieceColumn, int pieceRow, int score) {

    grid(g, 300, 130, 10, 16, 29);
    for (int r = 0; r < 16; r++)
      for (int c = 0; c < 10; c++)
        if (board[r][c] > 0) box(g, 301 + c * 29, 131 + r * 29, 27, 27, GREEN);
    for (int r = 0; r < piece.length; r++)
      for (int c = 0; c < piece[r].length; c++)
        if (piece[r][c] > 0 && pieceRow + r >= 0)
          box(g, 301 + (pieceColumn + c) * 29, 131 + (pieceRow + r) * 29, 27, 27, CYAN);
    text(g, "Линии: " + score + " / 5", 45, 160, 22, WHITE);
  }
}
