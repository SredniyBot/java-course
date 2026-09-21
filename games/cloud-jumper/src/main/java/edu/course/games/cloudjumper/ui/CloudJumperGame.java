package edu.course.games.cloudjumper.ui;

import edu.course.games.cloudjumper.domain.PlatformRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — CloudJumperRenderer. */
public final class CloudJumperGame implements DesktopGame {
  private double playerX, playerY, verticalSpeed;
  private int[] platformXs = new int[7];
  private double[] platformYs = new double[7];
  private double climbedDistance;
  private final GameSession context;

  public CloudJumperGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "03. Облачный прыгун",
        "Поднимитесь на 1200 метров по платформам.",
        "Стрелки влево/вправо; прыжок автоматический");
  }

  @Override
  public void reset() {
    playerX = 440;
    playerY = 510;
    verticalSpeed = -330;
    climbedDistance = 0;
    platformXs[0] = 390;
    platformYs[0] = 550;
    for (int i = 1; i < 7; i++) {
      platformXs[i] =
          Math.max(
              60,
              Math.min(
                  760,
                  platformXs[i - 1]
                      + (context.random().nextBoolean() ? 1 : -1)
                          * (70 + context.random().nextInt(100))));
      platformYs[i] = 550 - i * 65;
    }
  }

  @Override
  public void render(Graphics2D g) {
    CloudJumperRenderer.draw(g, playerX, playerY, platformXs, platformYs, context.score());
  }

  @Override
  public void update(double dt) {
    playerX =
        PlatformRules.wrapHorizontal(
            playerX + (context.held(KeyEvent.VK_RIGHT) - context.held(KeyEvent.VK_LEFT)) * 300 * dt,
            960);
    double old = playerY + 14;
    verticalSpeed += 650 * dt;
    playerY += verticalSpeed * dt;
    for (int i = 0; i < 7; i++)
      if (PlatformRules.crossesPlatform(
          old, playerY + 14, verticalSpeed, playerX, platformXs[i], platformYs[i])) {
        playerY = platformYs[i] - 14;
        verticalSpeed = -360;
      }
    if (playerY < 320) {
      double shift = 320 - playerY;
      climbedDistance += shift;
      context.setScore((int) climbedDistance);
      playerY = 320;
      for (int i = 0; i < 7; i++) {
        platformYs[i] += shift;
        if (platformYs[i] > 605) {
          platformYs[i] -= 455;
          platformXs[i] =
              Math.max(
                  60,
                  Math.min(
                      760,
                      platformXs[(i + 6) % 7]
                          + (context.random().nextBoolean() ? 1 : -1)
                              * (70 + context.random().nextInt(100))));
        }
      }
    }
    if (playerY > 630) context.end("Вы упали. F5 — новый полёт");
    if (context.score() >= 1200) context.end("Выше облаков!");
  }
}
