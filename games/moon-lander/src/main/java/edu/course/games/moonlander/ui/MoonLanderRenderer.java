package edu.course.games.moonlander.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class MoonLanderRenderer {
  private MoonLanderRenderer() {}

  static void draw(Graphics2D g, double shipX, double shipY, double verticalSpeed) {

    box(g, 30, 575, 900, 20, SLATE);
    box(g, 370, 565, 200, 20, GREEN);
    box(g, (int) shipX - 15, (int) shipY - 20, 30, 20, CYAN);
    text(
        g,
        String.format(java.util.Locale.ROOT, "Скорость: %.0f", verticalSpeed),
        45,
        145,
        22,
        WHITE);
  }
}
