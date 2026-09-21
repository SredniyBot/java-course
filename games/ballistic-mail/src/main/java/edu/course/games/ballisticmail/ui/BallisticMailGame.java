package edu.course.games.ballisticmail.ui;

import edu.course.games.ballisticmail.domain.TrajectoryPhysics;
import edu.course.games.ballisticmail.domain.Velocity;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — BallisticMailRenderer. */
public final class BallisticMailGame implements DesktopGame {
  private double angle, speed, projectileX, projectileY, horizontalSpeed, verticalSpeed;
  private int targetX;
  private boolean flying;
  private final GameSession context;

  public BallisticMailGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "24. Баллистическая почта",
        "Попадите посылкой в три приёмника.",
        "Влево/вправо — угол; вверх/вниз — скорость; Space — бросок");
  }

  @Override
  public void reset() {
    angle = 45;
    speed = 310;
    projectileX = 100;
    projectileY = 550;
    targetX = 650;
    flying = false;
  }

  @Override
  public void render(Graphics2D g) {
    BallisticMailRenderer.draw(g, angle, speed, projectileX, projectileY, targetX, context.score());
  }

  @Override
  public void update(double dt) {
    if (!flying) return;
    var next =
        TrajectoryPhysics.advance(
            new edu.course.games.ballisticmail.domain.FlightState(
                projectileX, projectileY, horizontalSpeed, verticalSpeed),
            dt);
    projectileX = next.x();
    projectileY = next.y();
    horizontalSpeed = next.vx();
    verticalSpeed = next.vy();
    if (projectileY >= 560) {
      flying = false;
      if (TrajectoryPhysics.isWithinTarget(projectileX, targetX, 40)) {
        context.addScore(1);
        targetX = 450 + context.random().nextInt(380);
        context.status("Посылка доставлена");
        if (context.score() == 3) context.end("Почта работает без дорог!");
      } else context.status("Промах. Скорректируйте бросок");
      projectileX = 100;
      projectileY = 550;
    }
    if (projectileX > 950 || projectileY < 110) {
      flying = false;
      projectileX = 100;
      projectileY = 550;
      context.status("Вылет за пределы сектора");
    }
  }

  @Override
  public void onKeyPressed(int key) {
    if (flying) return;
    if (key == KeyEvent.VK_LEFT) angle = Math.max(10, angle - 2);
    if (key == KeyEvent.VK_RIGHT) angle = Math.min(75, angle + 2);
    if (key == KeyEvent.VK_UP) speed = Math.min(390, speed + 10);
    if (key == KeyEvent.VK_DOWN) speed = Math.max(150, speed - 10);
    if (key == KeyEvent.VK_SPACE) {
      Velocity v = TrajectoryPhysics.initialVelocity(angle, speed);
      horizontalSpeed = v.x();
      verticalSpeed = v.y();
      projectileX = 100;
      projectileY = 550;
      flying = true;
    }
  }
}
