package edu.course.games.colorflood.ui;

import edu.course.games.colorflood.domain.FloodRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — ColorFloodRenderer. */
public final class ColorFloodGame implements DesktopGame {
  private int[][] board;
  private int moves;
  private final GameSession context;

  public ColorFloodGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "14. Цветной прилив",
        "Залейте всё поле одним цветом за 24 хода, начиная сверху слева.",
        "1–4 или палитра слева — выбрать цвет");
  }

  @Override
  public void reset() {
    board = new int[10][10];
    for (int[] row : board)
      for (int i = 0; i < row.length; i++) row[i] = 1 + context.random().nextInt(4);
    moves = 0;
  }

  @Override
  public void render(Graphics2D g) {
    ColorFloodRenderer.draw(g, board, moves);
  }

  @Override
  public void onMousePressed(int x, int y, int button) {
    if (button != 1 || x < 35 || x >= 185 || y < 220) return;
    int index = (y - 220) / 60;
    if (index < 4 && (y - 220) % 60 < 44) onKeyPressed(49 + index);
  }

  @Override
  public void onKeyPressed(int key) {
    if (key < 49 || key > 52) return;
    int color = key - 48;
    if (color == board[0][0]) return;
    FloodRules.fillFromOrigin(board, color);
    moves++;
    if (FloodRules.isUniform(board)) context.end("Море стало одноцветным!");
    else if (moves >= 24) context.end("Ходы закончились. F5 — новый прилив");
  }
}
