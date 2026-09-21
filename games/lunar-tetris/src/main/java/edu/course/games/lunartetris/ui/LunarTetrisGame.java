package edu.course.games.lunartetris.ui;

import edu.course.games.lunartetris.domain.TetrisRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — LunarTetrisRenderer. */
public final class LunarTetrisGame implements DesktopGame {
  private int[][] board = new int[16][10], piece;
  private int pieceColumn, pieceRow;
  private double elapsedSeconds;
  private final GameSession context;

  public LunarTetrisGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "07. Тетрис: стройка на Луне",
        "Соберите 5 полных горизонтальных линий.",
        "Влево/вправо — сдвиг; вверх — поворот; вниз — ускорение");
  }

  @Override
  public void reset() {
    board = new int[16][10];
    spawn();
    elapsedSeconds = 0;
  }

  @Override
  public void render(Graphics2D g) {
    LunarTetrisRenderer.draw(g, board, piece, pieceColumn, pieceRow, context.score());
  }

  @Override
  public void update(double dt) {
    elapsedSeconds += dt;
    if (elapsedSeconds < (context.held(KeyEvent.VK_DOWN) == 1 ? .05 : .55)) return;
    elapsedSeconds = 0;
    if (TetrisRules.canPlace(board, piece, pieceColumn, pieceRow + 1)) pieceRow++;
    else {
      for (int r = 0; r < piece.length; r++)
        for (int c = 0; c < piece[r].length; c++)
          if (piece[r][c] > 0) board[pieceRow + r][pieceColumn + c] = 1;
      context.addScore(TetrisRules.removeFullRows(board));
      spawn();
      if (!TetrisRules.canPlace(board, piece, pieceColumn, pieceRow))
        context.end("Стройка дошла до потолка");
      if (context.score() >= 5) context.end("Лунная станция построена!");
    }
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_LEFT && TetrisRules.canPlace(board, piece, pieceColumn - 1, pieceRow))
      pieceColumn--;
    if (key == KeyEvent.VK_RIGHT && TetrisRules.canPlace(board, piece, pieceColumn + 1, pieceRow))
      pieceColumn++;
    if (key == KeyEvent.VK_UP) {
      int[][] p = TetrisRules.rotateClockwise(piece);
      if (TetrisRules.canPlace(board, p, pieceColumn, pieceRow)) piece = p;
    }
  }

  private void spawn() {
    int[][][] shapes = {
      {{1, 1, 1, 1}}, {{1, 1}, {1, 1}}, {{0, 1, 0}, {1, 1, 1}}, {{1, 0}, {1, 0}, {1, 1}}
    };
    piece = shapes[context.random().nextInt(shapes.length)];
    pieceColumn = 3;
    pieceRow = 0;
  }
}
