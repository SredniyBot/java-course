package edu.course.games.cloudjumper.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class CloudJumperRenderer {
  private CloudJumperRenderer() {}

  static void draw(
      Graphics2D g,
      double playerX,
      double playerY,
      int[] platformXs,
      double[] platformYs,
      int score) {

    for (int i = 0; i < 7; i++) box(g, platformXs[i], (int) platformYs[i], 140, 12, GREEN);
    circle(g, (int) playerX, (int) playerY, 14, CYAN);
    text(g, "Высота: " + score + " / 1200", 40, 145, 22, WHITE);
  }
}
