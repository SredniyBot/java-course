package edu.course.games.balloonrescue.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.RED;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class BalloonRescueRenderer {
  private BalloonRescueRenderer() {}

  static void draw(Graphics2D g, String guessed, String maskedWord, int misses) {

    circle(g, 220, 290, 90, misses < 4 ? CYAN : RED);
    g.setColor(WHITE);
    g.drawLine(220, 380, 220, 470);
    box(g, 180, 470, 80, 55, GOLD);
    text(g, maskedWord, 370, 300, 34, WHITE);
    text(g, "Буквы: " + guessed, 370, 360, 24, WHITE);
    text(g, "Ошибки: " + misses + " / 6", 370, 405, 24, WHITE);
  }
}
