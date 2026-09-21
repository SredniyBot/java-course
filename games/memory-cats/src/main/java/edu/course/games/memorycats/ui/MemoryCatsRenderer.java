package edu.course.games.memorycats.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.centered;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class MemoryCatsRenderer {
  private MemoryCatsRenderer() {}

  static void draw(
      Graphics2D g, String[] cards, boolean[] found, int firstCardIndex, int secondCardIndex) {

    for (int i = 0; i < 16; i++) {
      int x = 170 + (i % 4) * 155, y = 150 + (i / 4) * 110;
      boolean show = found[i] || i == firstCardIndex || i == secondCardIndex;
      box(g, x, y, 140, 95, found[i] ? GREEN : show ? BLUE : SLATE);
      centered(g, show ? cards[i] : "?", x, y, 140, 95, 24, WHITE);
    }
  }
}
