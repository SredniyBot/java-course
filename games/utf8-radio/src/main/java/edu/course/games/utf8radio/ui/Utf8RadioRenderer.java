package edu.course.games.utf8radio.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class Utf8RadioRenderer {
  private Utf8RadioRenderer() {}

  static void draw(
      Graphics2D g, String word, byte[] pool, byte[] packet, boolean[] used, int count, int score) {

    text(g, "Передать: " + word, 100, 180, 32, GOLD);
    for (int i = 0; i < pool.length; i++) {
      int x = 90 + (i % 8) * 100, y = 250 + (i / 8) * 90;
      box(g, x, y, 85, 65, used[i] ? SLATE : BLUE);
      text(g, String.format("%02X", pool[i] & 255), x + 15, y + 42, 26, WHITE);
    }
    text(g, "Байтов выбрано: " + count + " / " + pool.length, 100, 490, 24, WHITE);
    text(g, "Передач: " + score + " / 5", 100, 550, 24, WHITE);
    StringBuilder hex = new StringBuilder();
    for (int i = 0; i < count; i++) hex.append(String.format("%02X ", packet[i] & 255));
    text(g, hex.toString(), 100, 525, 20, CYAN);
  }
}
