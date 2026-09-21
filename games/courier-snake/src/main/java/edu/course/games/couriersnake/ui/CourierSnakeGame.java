package edu.course.games.couriersnake.ui;

import edu.course.games.couriersnake.domain.SnakeRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — CourierSnakeRenderer. */
public final class CourierSnakeGame implements DesktopGame {
  private int[] bodyColumns = new int[400], bodyRows = new int[400];
  private int bodyLength, columnStep, rowStep, foodColumn, foodRow;
  private double elapsedSeconds;
  private boolean turnQueued;
  private final GameSession context;

  public CourierSnakeGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "06. Змейка-курьер", "Съешьте 10 посылок, не столкнувшись с собой.", "Стрелки — поворот");
  }

  @Override
  public void reset() {
    bodyLength = 3;
    for (int i = 0; i < 3; i++) {
      bodyColumns[i] = 6 - i;
      bodyRows[i] = 6;
    }
    columnStep = 1;
    rowStep = 0;
    foodColumn = 12;
    foodRow = 6;
    elapsedSeconds = 0;
    turnQueued = false;
  }

  @Override
  public void render(Graphics2D g) {
    CourierSnakeRenderer.draw(
        g, bodyColumns, bodyRows, bodyLength, foodColumn, foodRow, context.score());
  }

  @Override
  public void update(double dt) {
    elapsedSeconds += dt;
    if (elapsedSeconds < .14) return;
    elapsedSeconds = 0;
    turnQueued = false;
    int nx = bodyColumns[0] + columnStep, ny = bodyRows[0] + rowStep;
    boolean grow = nx == foodColumn && ny == foodRow;
    if (nx < 0
        || nx >= 20
        || ny < 0
        || ny >= 16
        || SnakeRules.occupiesCell(bodyColumns, bodyRows, bodyLength - (grow ? 0 : 1), nx, ny)) {
      context.end("Маршрут оборвался. F5 — заново");
      return;
    }
    if (grow) bodyLength++;
    SnakeRules.advanceBody(bodyColumns, bodyRows, bodyLength, nx, ny);
    if (grow) {
      context.addScore(1);
      do {
        foodColumn = context.random().nextInt(20);
        foodRow = context.random().nextInt(16);
      } while (SnakeRules.occupiesCell(bodyColumns, bodyRows, bodyLength, foodColumn, foodRow));
      if (context.score() == 10) context.end("Все посылки собраны!");
    }
  }

  @Override
  public void onKeyPressed(int key) {
    if (turnQueued) return;
    if (key == KeyEvent.VK_LEFT && columnStep != 1) {
      columnStep = -1;
      rowStep = 0;
    }
    if (key == KeyEvent.VK_RIGHT && columnStep != -1) {
      columnStep = 1;
      rowStep = 0;
    }
    if (key == KeyEvent.VK_UP && rowStep != 1) {
      columnStep = 0;
      rowStep = -1;
    }
    if (key == KeyEvent.VK_DOWN && rowStep != -1) {
      columnStep = 0;
      rowStep = 1;
    }
    if (key >= 37 && key <= 40) turnQueued = true;
  }
}
