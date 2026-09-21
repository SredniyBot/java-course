package edu.course.games.couriersnake.ui;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.grid;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class CourierSnakeRenderer {
  private CourierSnakeRenderer() {}

  static void draw(
      Graphics2D g,
      int[] bodyColumns,
      int[] bodyRows,
      int bodyLength,
      int foodColumn,
      int foodRow,
      int score) {

    grid(g, 180, 140, 20, 16, 30);
    for (int i = bodyLength - 1; i >= 0; i--)
      box(g, 181 + bodyColumns[i] * 30, 141 + bodyRows[i] * 30, 28, 28, i == 0 ? CYAN : GREEN);
    circle(g, 195 + foodColumn * 30, 155 + foodRow * 30, 10, GOLD);
    text(g, "Посылки: " + score + " / 10", 35, 130, 18, WHITE);
  }
}
