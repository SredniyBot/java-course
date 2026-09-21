package edu.course.games.unicodesafari.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.centered;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class UnicodeSafariRenderer {
  private UnicodeSafariRenderer() {}

  static void draw(Graphics2D g, String[] labels, int target, int mode, int score) {

    text(g, (mode == 0 ? "Кодовых точек: " : "Байтов UTF-8: ") + target, 170, 190, 30, GOLD);
    for (int i = 0; i < 6; i++) {
      int x = 135 + (i % 3) * 240, y = 260 + (i / 3) * 140;
      box(g, x, y, 215, 115, BLUE);
      centered(g, labels[i], x, y, 215, 115, 32, WHITE);
    }
    text(g, "Поймано: " + score + " / 10", 170, 590, 23, WHITE);
  }
}
