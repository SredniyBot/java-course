package edu.course.games.brickgarden.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.palette;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class BrickGardenRenderer {
  private BrickGardenRenderer() {}

  static void draw(Graphics2D g, int[][] bricks, double ballX, double ballY, double paddleLeft) {

    for (int r = 0; r < 3; r++)
      for (int c = 0; c < 8; c++)
        if (bricks[r][c] > 0) box(g, 80 + c * 100, 160 + r * 35, 94, 28, palette(r + 1));
    box(g, (int) paddleLeft, 565, 120, 14, CYAN);
    circle(g, (int) ballX, (int) ballY, 9, GOLD);
  }
}
