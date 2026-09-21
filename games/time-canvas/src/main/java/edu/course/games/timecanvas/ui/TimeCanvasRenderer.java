package edu.course.games.timecanvas.ui;

import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.palette;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class TimeCanvasRenderer {
  private TimeCanvasRenderer() {}

  static void draw(Graphics2D g, int[][] image, int index, int last, int color) {

    for (int r = 0; r < 6; r++)
      for (int c = 0; c < 6; c++) {
        box(g, 70 + c * 65, 160 + r * 65, 61, 61, palette(image[r][c]));
        box(g, 555 + c * 50, 200 + r * 50, 46, 46, palette(r == c ? 1 : (r + c == 5 ? 2 : 0)));
      }
    text(g, "Ваш холст", 70, 145, 22, WHITE);
    text(g, "Образец", 555, 175, 22, WHITE);
    text(g, "Снимок " + index + " / " + last + "   Цвет " + color, 70, 590, 22, GOLD);
  }
}
