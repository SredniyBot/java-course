package edu.course.games.pixelsymmetry.ui;

import edu.course.games.pixelsymmetry.domain.SymmetryRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — PixelSymmetryRenderer. */
public final class PixelSymmetryGame implements DesktopGame {
  private int[][] pixels;
  private int color;
  private final GameSession context;

  public PixelSymmetryGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "13. Мастерская симметрии",
        "Нарисуйте симметричный узор минимум из 20 цветных пикселей.",
        "Мышь — кисть; 1–4 или палитра — цвет; M — отражение; Enter — проверка");
  }

  @Override
  public void reset() {
    pixels = new int[12][16];
    color = 1;
  }

  @Override
  public void render(Graphics2D g) {
    PixelSymmetryRenderer.draw(g, pixels, color);
  }

  @Override
  public void onKeyPressed(int key) {
    if (key >= 49 && key <= 52) color = key - 48;
    if (key == 77) SymmetryRules.mirrorLeftToRight(pixels);
    if (key == KeyEvent.VK_ENTER) {
      int n = 0;
      for (int[] row : pixels) for (int v : row) if (v != 0) n++;
      if (n >= 20 && SymmetryRules.isHorizontallySymmetric(pixels))
        context.end("Узор принят в галерею!");
      else context.status("Нужно 20 пикселей и зеркальная симметрия");
    }
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    if (button != 1) return;
    if (mx >= 35 && mx < 125 && my >= 165) {
      int index = (my - 165) / 65;
      if (index < 4 && (my - 165) % 65 < 45) {
        color = index + 1;
        return;
      }
    }
    SymmetryRules.paintCell(
        pixels, Math.floorDiv(my - 140, 38), Math.floorDiv(mx - 160, 40), color);
  }
}
