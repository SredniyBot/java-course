package edu.course.games.spacekitchen.ui;

import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.palette;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class SpaceKitchenRenderer {
  private SpaceKitchenRenderer() {}

  static void draw(Graphics2D g, String[] ingredients, String order, String input, int score) {

    text(g, "Заказ: " + order, 160, 200, 30, GOLD);
    for (int i = 0; i < 4; i++) {
      box(g, 100 + i * 210, 270, 190, 95, palette(i + 1));
      text(g, ingredients[i], 120 + i * 210, 325, 28, WHITE);
    }
    text(g, "На тарелке: " + input, 100, 445, 28, WHITE);
    text(g, "Подано: " + score + " / 8", 100, 510, 24, WHITE);
  }
}
