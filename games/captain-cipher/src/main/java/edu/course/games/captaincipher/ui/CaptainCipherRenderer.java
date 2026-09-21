package edu.course.games.captaincipher.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class CaptainCipherRenderer {
  private CaptainCipherRenderer() {}

  static void draw(Graphics2D g, String encode, String input, int shiftUppercase, int score) {

    text(g, "Сдвиг: " + shiftUppercase, 140, 200, 30, GOLD);
    text(g, encode, 140, 295, 36, CYAN);
    box(g, 130, 370, 700, 70, BLUE);
    text(g, input + "_", 150, 416, 30, WHITE);
    text(g, "Приказов: " + score + " / 5", 140, 520, 24, WHITE);
  }
}
