package edu.course.games.marsmines.ui;

import edu.course.games.marsmines.domain.MinefieldRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — MarsMinesRenderer. */
public final class MarsMinesGame implements DesktopGame {
  private boolean[][] mines, open, flags;
  private int[][] numbers;
  private boolean first;
  private final GameSession context;

  public MarsMinesGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "08. Сапёр на Марсе",
        "Откройте все безопасные клетки. Первый ход безопасен.",
        "ЛКМ — открыть; ПКМ — флаг");
  }

  @Override
  public void reset() {
    mines = new boolean[9][9];
    open = new boolean[9][9];
    flags = new boolean[9][9];
    numbers = new int[9][9];
    first = true;
    int n = 0;
    while (n < 12) {
      int r = context.random().nextInt(9), c = context.random().nextInt(9);
      if (!mines[r][c]) {
        mines[r][c] = true;
        n++;
      }
    }
  }

  @Override
  public void render(Graphics2D g) {
    MarsMinesRenderer.draw(g, mines, open, flags, numbers);
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 250, 50), r = Math.floorDiv(my - 140, 50);
    if (r < 0 || r >= 9 || c < 0 || c >= 9) return;
    if (button == 3) {
      if (!open[r][c]) flags[r][c] = !flags[r][c];
      return;
    }
    if (flags[r][c] || open[r][c]) return;
    if (first) {
      first = false;
      if (mines[r][c]) {
        mines[r][c] = false;
        outer:
        for (int a = 0; a < 9; a++)
          for (int b = 0; b < 9; b++)
            if (!mines[a][b] && (a != r || b != c)) {
              mines[a][b] = true;
              break outer;
            }
      }
    }
    open[r][c] = true;
    numbers[r][c] = MinefieldRules.countAdjacentMines(mines, r, c);
    if (mines[r][c]) context.end("Метеорит! F5 — новая экспедиция");
    else if (MinefieldRules.allSafeCellsOpen(mines, open)) context.end("Марс исследован!");
  }
}
