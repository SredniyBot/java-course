package edu.course.games.lasermail.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.grid;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class LaserMailRenderer {
  private LaserMailRenderer() {}

  static void draw(Graphics2D g, char[][] mirrors, int[] br, int[] bc, int beam) {

    grid(g, 250, 140, 9, 9, 50);
    for (int r = 0; r < 9; r++)
      for (int c = 0; c < 9; c++)
        if (mirrors[r][c] != 0) text(g, "" + mirrors[r][c], 267 + c * 50, 175 + r * 50, 32, CYAN);
    for (int i = 0; i < beam; i++) circle(g, 275 + bc[i] * 50, 165 + br[i] * 50, 5, GOLD);
    text(g, ">", 220, 226, 28, GREEN);
    circle(g, 625, 515, 18, GREEN);
  }
}
