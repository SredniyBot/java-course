package edu.course.games.ballisticmail.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class BallisticMailRenderer {
  private BallisticMailRenderer() {}

  static void draw(
      Graphics2D g,
      double angle,
      double speed,
      double projectileX,
      double projectileY,
      int targetX,
      int score) {

    box(g, targetX - 40, 560, 80, 30, GREEN);
    circle(g, (int) projectileX, (int) projectileY, 12, GOLD);
    text(
        g,
        String.format(
            java.util.Locale.ROOT,
            "Угол %.0f°   Скорость %.0f   Доставлено %d / 3",
            angle,
            speed,
            score),
        80,
        175,
        25,
        WHITE);
    g.setColor(CYAN);
    g.drawLine(
        100,
        550,
        100 + (int) (70 * Math.cos(Math.toRadians(angle))),
        550 - (int) (70 * Math.sin(Math.toRadians(angle))));
  }
}
