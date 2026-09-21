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
    var trace = BeamRules.trace(mirrors, 1, 0, 0, 7, 7);
    beam = trace.cells().size();
    br = new int[beam];
    bc = new int[beam];
    for (int i = 0; i < beam; i++) {
      br[i] = trace.cells().get(i).row();
      bc[i] = trace.cells().get(i).col();
    }
    if (trace.end() == edu.course.games.lasermail.domain.BeamTrace.End.DELIVERED)
      context.end("Письмо доставлено светом!");
    else
      context.status(
          trace.end() == edu.course.games.lasermail.domain.BeamTrace.End.LOOP
              ? "Луч попал в петлю. Поверните зеркала"
              : "Луч вышел за поле. Поверните зеркала");
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int r = Math.floorDiv(my - 140, 50), c = Math.floorDiv(mx - 250, 50);
    if (r >= 0 && r < 9 && c >= 0 && c < 9 && mirrors[r][c] != 0)
      mirrors[r][c] = mirrors[r][c] == '/' ? '\\' : '/';
  }
}
