package edu.course.games.starcourier.ui;

import edu.course.games.starcourier.domain.CourierRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — StarCourierRenderer. */
public final class StarCourierGame implements DesktopGame {
  private double shipX, shipY;
  private int starX, starY;
  private final GameSession context;

  public StarCourierGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "01. Звёздный курьер", "Соберите 10 звёзд, не вылетая за границы.", "Стрелки — полёт");
  }

  @Override
  public void reset() {
    shipX = 450;
    shipY = 350;
    starX = 170;
    starY = 200;
  }

  @Override
  public void render(Graphics2D g) {
    StarCourierRenderer.draw(g, shipX, shipY, starX, starY, context.score());
  }

  @Override
  public void update(double dt) {
    shipX =
        CourierRules.clampCoordinate(
            shipX + (context.held(KeyEvent.VK_RIGHT) - context.held(KeyEvent.VK_LEFT)) * 240 * dt,
            45,
            915);
    shipY =
        CourierRules.clampCoordinate(
            shipY + (context.held(KeyEvent.VK_DOWN) - context.held(KeyEvent.VK_UP)) * 240 * dt,
            165,
            580);
    if (CourierRules.isWithinRadius(shipX, shipY, starX, starY, 29)) {
      context.addScore(1);
      starX = 70 + context.random().nextInt(820);
      starY = 180 + context.random().nextInt(370);
      if (context.score() == 10) context.end("Все звёзды доставлены!");
    }
  }
}
