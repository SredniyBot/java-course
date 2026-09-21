package edu.course.games.lasermail.ui;

import edu.course.games.lasermail.domain.BeamRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — LaserMailRenderer. */
public final class LaserMailGame implements DesktopGame {
  private char[][] mirrors;
  private int[] br = new int[200], bc = new int[200];
  private int beam;
  private final GameSession context;

  public LaserMailGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "18. Лазерная почта",
        "Доставьте луч из левого края в приёмник (7,7), поворачивая зеркала.",
        "Мышь — повернуть зеркало; Space — пустить луч");
  }

  @Override
  public void reset() {
    mirrors = new char[9][9];
    mirrors[1][3] = '/';
    mirrors[7][3] = '/';
    beam = 0;
  }

  @Override
  public void render(Graphics2D g) {
    LaserMailRenderer.draw(g, mirrors, br, bc, beam);
  }

  @Override
  public void onKeyPressed(int key) {
    if (key != 32) return;
    beam = 0;
    int r = 1, c = 0, d = 0;
    int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    boolean[][][] visited = new boolean[9][9][4];
    while (BeamRules.isInsideGrid(r, c, 9, 9) && beam < 200) {
      if (visited[r][c][d]) break;
      visited[r][c][d] = true;
      br[beam] = r;
      bc[beam++] = c;
      if (r == 7 && c == 7) {
        context.end("Письмо доставлено светом!");
        return;
      }
      d = BeamRules.reflectDirection(d, mirrors[r][c]);
      r += dr[d];
      c += dc[d];
    }
    context.status("Луч не дошёл. Поверните зеркала");
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int r = Math.floorDiv(my - 140, 50), c = Math.floorDiv(mx - 250, 50);
    if (r >= 0 && r < 9 && c >= 0 && c < 9 && mirrors[r][c] != 0)
      mirrors[r][c] = mirrors[r][c] == '/' ? '\\' : '/';
  }
}
