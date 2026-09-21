package edu.course.games.moonlander.ui;

import edu.course.games.moonlander.domain.LanderPhysics;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — MoonLanderRenderer. */
public final class MoonLanderGame implements DesktopGame {
  private double shipX, shipY, verticalSpeed;
  private final GameSession context;

  public MoonLanderGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "02. Лунная доставка",
        "Посадите корабль на зелёную площадку со скоростью не выше 55.",
        "Стрелки влево/вправо; вверх — двигатель");
  }

  @Override
  public void reset() {
    shipX = 460;
    shipY = 180;
    verticalSpeed = 0;
  }

  @Override
  public void render(Graphics2D g) {
    MoonLanderRenderer.draw(g, shipX, shipY, verticalSpeed);
  }

  @Override
  public void update(double dt) {
    shipX =
        Math.max(
            45,
            Math.min(
                915,
                shipX
                    + (context.held(KeyEvent.VK_RIGHT) - context.held(KeyEvent.VK_LEFT))
                        * 160
                        * dt));
    verticalSpeed =
        LanderPhysics.nextVerticalSpeed(verticalSpeed, context.held(KeyEvent.VK_UP) == 1, dt);
    shipY += verticalSpeed * dt;
    if (shipY < 150) {
      shipY = 150;
      verticalSpeed = 0;
    }
    if (shipY >= 565) {
      shipY = 565;
      context.end(
          LanderPhysics.isSafeLanding(shipX, verticalSpeed)
              ? "Мягкая посадка!"
              : "Посадка не удалась. F5 — ещё попытка");
    }
  }
}
