package edu.course.games.wordrain.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.RED;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class WordRainRenderer {
  private WordRainRenderer() {}

  static void draw(
      Graphics2D g, String word, String input, double y, int lives, boolean isPrefix, int score) {

    text(g, word, 390, (int) y, 40, GOLD);
    box(g, 170, 555, 620, 48, isPrefix ? BLUE : RED);
    text(g, input + "_", 190, 588, 28, WHITE);
    text(g, "Жизни: " + lives + "   Слова: " + score + " / 12", 50, 140, 22, WHITE);
  }
}
