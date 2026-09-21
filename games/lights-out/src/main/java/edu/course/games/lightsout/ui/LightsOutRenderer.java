package edu.course.games.lightsout.ui;

import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class LightsOutRenderer {
  private LightsOutRenderer() {}

  static void draw(Graphics2D g, boolean[][] lights, int score) {

    for (int r = 0; r < 5; r++)
      for (int c = 0; c < 5; c++)
        box(g, 255 + c * 90, 145 + r * 90, 78, 78, lights[r][c] ? GOLD : SLATE);
    text(g, "Переключений: " + score, 35, 135, 22, WHITE);
  }
}
