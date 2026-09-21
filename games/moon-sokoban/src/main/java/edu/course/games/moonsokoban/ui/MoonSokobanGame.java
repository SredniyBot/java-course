package edu.course.games.moonsokoban.ui;

import edu.course.games.moonsokoban.domain.WarehouseRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — MoonSokobanRenderer. */
public final class MoonSokobanGame implements DesktopGame {
  private int[][] board;
  private boolean[][] goals;
  private int pr, pc;
  private final GameSession context;

  public MoonSokobanGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "17. Склад лунного сыра",
        "Переместите два ящика на золотые площадки.",
        "Стрелки — движение; F5 — начать уровень заново");
  }

  @Override
  public void reset() {
    board =
        new int[][] {
          {1, 1, 1, 1, 1, 1, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 0, 2, 0, 2, 0, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 1, 1, 1, 1, 1, 1}
        };
    goals = new boolean[7][7];
    goals[4][2] = true;
    goals[4][4] = true;
    pr = 1;
    pc = 3;
  }

  @Override
  public void render(Graphics2D g) {
    MoonSokobanRenderer.draw(g, board, goals, pr, pc);
  }

  @Override
  public void onKeyPressed(int key) {
    int dr = key == KeyEvent.VK_UP ? -1 : key == KeyEvent.VK_DOWN ? 1 : 0,
        dc = key == KeyEvent.VK_LEFT ? -1 : key == KeyEvent.VK_RIGHT ? 1 : 0;
    if (dr == 0 && dc == 0) return;
    int r = pr + dr, c = pc + dc;
    if (r < 0 || r >= 7 || c < 0 || c >= 7 || board[r][c] == 1) return;
    if (board[r][c] == 2 && !WarehouseRules.tryPushBox(board, r, c, dr, dc)) return;
    pr = r;
    pc = c;
    context.addScore(1);
    if (WarehouseRules.allGoalsOccupied(board, goals))
      context.end("Сыр доставлен за " + context.score() + " шагов!");
  }
}
