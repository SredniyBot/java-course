package edu.course.games.wordmaze.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.GREEN;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.centered;
import static edu.course.platform.desktop.GameDrawing.text;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class WordMazeRenderer {
  private WordMazeRenderer() {}

  static void draw(Graphics2D g, char[][] letters, int[] path, int count, String trail) {

    for (int r = 0; r < 4; r++)
      for (int c = 0; c < 4; c++) {
        int i = r * 4 + c;
        boolean chosen = false;
        for (int j = 0; j < count; j++) if (path[j] == i) chosen = true;
        box(g, 270 + c * 100, 155 + r * 100, 90, 90, chosen ? GREEN : BLUE);
        centered(g, "" + letters[r][c], 270 + c * 100, 155 + r * 100, 90, 90, 32, WHITE);
      }
    text(g, "JAVA → " + trail, 300, 590, 25, GOLD);
  }
}
