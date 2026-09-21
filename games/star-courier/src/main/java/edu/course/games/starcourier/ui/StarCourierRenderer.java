package edu.course.games.starcourier.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class StarCourierRenderer {
  private StarCourierRenderer() {}

  static void draw(Graphics2D g, double shipX, double shipY, int starX, int starY, int score) {

    circle(g, starX, starY, 12, GOLD);
    circle(g, (int) shipX, (int) shipY, 18, CYAN);
    text(g, "Звёзды: " + score + " / 10", 45, 145, 22, WHITE);
  }
}
