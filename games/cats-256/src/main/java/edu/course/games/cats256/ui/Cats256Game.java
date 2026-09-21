package edu.course.games.cats256.ui;

import edu.course.games.cats256.domain.MoveDirection;
import edu.course.games.cats256.domain.TileBoard;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Objects;

/** Converts arrows into domain moves and supplies the random empty-cell choice. */
public final class Cats256Game implements DesktopGame {
  private final GameSession session;
  private TileBoard board;

  public Cats256Game(GameSession session) {
    this.session = Objects.requireNonNull(session);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "16. Котики 256",
        "Соберите плитку 256. Каждая плитка сливается не более одного раза за ход.",
        "Стрелки — сдвиг поля");
  }

  @Override
  public void reset() {
    board = new TileBoard(new int[][] {{2, 0, 0, 0}, {0, 0, 2, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
  }

  @Override
  public void render(Graphics2D graphics) {
    Cats256Renderer.draw(graphics, board.snapshot());
  }

  @Override
  public void onKeyPressed(int key) {
    MoveDirection direction =
        switch (key) {
          case KeyEvent.VK_LEFT -> MoveDirection.LEFT;
          case KeyEvent.VK_UP -> MoveDirection.UP;
          case KeyEvent.VK_RIGHT -> MoveDirection.RIGHT;
          case KeyEvent.VK_DOWN -> MoveDirection.DOWN;
          default -> null;
        };
    if (direction == null) return;
    if (board.slide(direction) && board.emptyCellCount() > 0)
      board.spawnTwo(session.random().nextInt(board.emptyCellCount()));
    if (board.reached(256)) session.end("Кот 256 найден!");
    else if (!board.hasLegalMove()) session.end("Нет ходов. F5 — новая партия");
  }
}
