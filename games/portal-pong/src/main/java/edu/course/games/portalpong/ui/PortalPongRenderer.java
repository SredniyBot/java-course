package edu.course.games.portalpong.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class PortalPongRenderer {
  private PortalPongRenderer() {}

  static void draw(Graphics2D g, double ballX, double ballY, double paddleTop, int score) {

    box(g, 50, (int) paddleTop, 16, 110, CYAN);
    box(g, 910, 150, 8, 445, SLATE);
    circle(g, (int) ballX, (int) ballY, 10, GOLD);
    text(g, "Отражения: " + score + " / 12", 45, 130, 22, WHITE);
  }
}
