package edu.course.games.factoryrobot.ui;

import static edu.course.platform.desktop.GameDrawing.BLUE;
import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.INK;
import static edu.course.platform.desktop.GameDrawing.SLATE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.circle;
import static edu.course.platform.desktop.GameDrawing.text;
import static edu.course.platform.desktop.GameDrawing.wrapped;

import java.awt.Graphics2D;

/** Drawing only: parameters are borrowed for this call, never stored or changed. */
final class FactoryRobotRenderer {
  private FactoryRobotRenderer() {}

  static void draw(Graphics2D g, int[][] map, String program, int row, int col, int dir, int ip) {

    for (int r = 0; r < 7; r++)
      for (int c = 0; c < 7; c++)
        box(g, 80 + c * 60, 145 + r * 60, 56, 56, map[r][c] == 1 ? BLUE : SLATE);
    circle(g, 410, 475, 19, GOLD);
    circle(g, 110 + col * 60, 175 + row * 60, 19, CYAN);
    text(g, new String[] {">", "v", "<", "^"}[dir], 102 + col * 60, 182 + row * 60, 22, INK);
    text(g, "Программа:", 550, 190, 24, WHITE);
    wrapped(g, program, 550, 225, 350, 22, CYAN);
    text(g, "Шаг: " + ip + " / " + program.length(), 550, 430, 23, WHITE);
  }
}
