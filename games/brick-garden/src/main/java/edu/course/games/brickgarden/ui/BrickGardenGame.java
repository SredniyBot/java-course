package edu.course.games.brickgarden.ui;

import edu.course.games.brickgarden.domain.BrickRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — BrickGardenRenderer. */
public final class BrickGardenGame implements DesktopGame {
  private int[][] bricks = new int[3][8];
  private double ballX, ballY, horizontalSpeed, verticalSpeed, paddleLeft;
  private final GameSession context;

  public BrickGardenGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "05. Кирпичный сад", "Разбейте все 24 кирпича.", "Стрелки влево/вправо — платформа");
  }

  @Override
  public void reset() {
    for (int[] row : bricks) java.util.Arrays.fill(row, 1);
    ballX = 450;
    ballY = 400;
    horizontalSpeed = 150;
    verticalSpeed = -230;
    paddleLeft = 410;
  }

  @Override
  public void render(Graphics2D g) {
    BrickGardenRenderer.draw(g, bricks, ballX, ballY, paddleLeft);
  }

  @Override
  public void update(double dt) {
    paddleLeft =
        Math.max(
            40,
            Math.min(
                800,
                paddleLeft
                    + (context.held(KeyEvent.VK_RIGHT) - context.held(KeyEvent.VK_LEFT))
                        * 360
                        * dt));
    ballX += horizontalSpeed * dt;
    ballY += verticalSpeed * dt;
    if (ballX < 40 || ballX > 920) horizontalSpeed = -horizontalSpeed;
    if (ballY < 145) {
      ballY = 145;
      verticalSpeed = Math.abs(verticalSpeed);
    }
    int c = BrickRules.columnAt(ballX);
    int r = (int) Math.floor((ballY - 160) / 35);
    if (r >= 0 && r < 3 && c >= 0 && ballY < 160 + r * 35 + 28 && bricks[r][c] > 0) {
      bricks[r][c] = 0;
      verticalSpeed = -verticalSpeed;
      ballY += Math.signum(verticalSpeed) * 14;
    }
    if (verticalSpeed > 0
        && ballY >= 555
        && ballY < 580
        && ballX >= paddleLeft - 9
        && ballX <= paddleLeft + 129) {
      ballY = 554;
      verticalSpeed = -Math.abs(verticalSpeed);
    }
    if (ballY > 620) context.end("Мяч потерян. F5 — новый сад");
    if (BrickRules.countRemaining(bricks) == 0) context.end("Сад свободен!");
  }
}
