package edu.course.games.portalpong.ui;

import edu.course.games.portalpong.domain.PaddlePhysics;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — PortalPongRenderer. */
public final class PortalPongGame implements DesktopGame {
  private double ballX, ballY, horizontalSpeed, verticalSpeed, paddleTop;
  private final GameSession context;

  public PortalPongGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "04. Пинг-понг с порталом", "Отразите мяч 12 раз.", "Стрелки вверх/вниз — ракетка");
  }

  @Override
  public void reset() {
    ballX = 700;
    ballY = 300;
    horizontalSpeed = -280;
    verticalSpeed = 120;
    paddleTop = 300;
  }

  @Override
  public void render(Graphics2D g) {
    PortalPongRenderer.draw(g, ballX, ballY, paddleTop, context.score());
  }

  @Override
  public void update(double dt) {
    paddleTop =
        Math.max(
            150,
            Math.min(
                485,
                paddleTop
                    + (context.held(KeyEvent.VK_DOWN) - context.held(KeyEvent.VK_UP)) * 300 * dt));
    double old = ballX;
    ballX += horizontalSpeed * dt;
    ballY += verticalSpeed * dt;
    if (ballY < 160) {
      ballY = 160;
      verticalSpeed = Math.abs(verticalSpeed);
    }
    if (ballY > 585) {
      ballY = 585;
      verticalSpeed = -Math.abs(verticalSpeed);
    }
    if (ballX > 900) {
      ballX = 900;
      horizontalSpeed = -Math.abs(horizontalSpeed);
    }
    if (horizontalSpeed < 0
        && old >= 76
        && ballX < 76
        && PaddlePhysics.intersectsPaddle(ballY, paddleTop)) {
      ballX = 76;
      horizontalSpeed = Math.abs(horizontalSpeed) + 8;
      verticalSpeed = PaddlePhysics.reflectedVerticalSpeed(ballY, paddleTop);
      context.addScore(1);
    }
    if (ballX < 20) context.end("Мяч ушёл в портал. F5 — заново");
    if (context.score() == 12) context.end("Портал защищён!");
  }
}
