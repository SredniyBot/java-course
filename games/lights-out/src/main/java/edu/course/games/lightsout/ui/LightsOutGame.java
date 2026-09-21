package edu.course.games.lightsout.ui;

import edu.course.games.lightsout.domain.LightRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — LightsOutRenderer. */
public final class LightsOutGame implements DesktopGame {
  private boolean[][] lights;
  private final GameSession context;

  public LightsOutGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "15. Ночной город",
        "Погасите все окна. Нажатие меняет окно и четыре соседних.",
        "Мышь — переключить крест");
  }

  @Override
  public void reset() {
    lights = new boolean[5][5];
    int[][] clicks = {{1, 1}, {2, 3}, {4, 0}, {3, 2}};
    for (int[] p : clicks) {
      int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, -1, 1};
      for (int k = 0; k < 5; k++) {
        int r = p[0] + dr[k], c = p[1] + dc[k];
        if (r >= 0 && r < 5 && c >= 0 && c < 5) lights[r][c] = !lights[r][c];
      }
    }
  }

  @Override
  public void render(Graphics2D g) {
    LightsOutRenderer.draw(g, lights, context.score());
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 255, 90), r = Math.floorDiv(my - 145, 90);
    if (r < 0 || r >= 5 || c < 0 || c >= 5) return;
    LightRules.toggleCross(lights, r, c);
    context.addScore(1);
    if (LightRules.allLightsOff(lights)) context.end("Город уснул!");
  }
}
