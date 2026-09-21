package edu.course.games.timecanvas.ui;

import edu.course.games.timecanvas.domain.CanvasRules;
import edu.course.games.timecanvas.domain.PixelHistory;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Objects;

/** Maps input to history commands; pixels and undo/redo invariants belong to PixelHistory. */
public final class TimeCanvasGame implements DesktopGame {
  private final GameSession session;
  private PixelHistory history;
  private int selectedColor;

  public TimeCanvasGame(GameSession session) {
    this.session = Objects.requireNonNull(session);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "19. Холст времени",
        "Воспроизведите образец. Z — отмена, Y — возврат.",
        "Мышь — цвет клетки; 1–3 — цвет; Z/Y — undo/redo; Enter — проверка");
  }

  @Override
  public void reset() {
    history = new PixelHistory(new int[6][6], 100);
    selectedColor = 1;
  }

  @Override
  public void render(Graphics2D graphics) {
    TimeCanvasRenderer.draw(
        graphics,
        history.currentPixels(),
        history.currentIndex(),
        history.latestIndex(),
        selectedColor);
  }

  @Override
  public void onKeyPressed(int key) {
    if (key >= KeyEvent.VK_1 && key <= KeyEvent.VK_3) selectedColor = key - KeyEvent.VK_0;
    if (key == KeyEvent.VK_Z) history.undo();
    if (key == KeyEvent.VK_Y) history.redo();
    if (key == KeyEvent.VK_ENTER) {
      int[][] target = new int[6][6];
      for (int row = 0; row < 6; row++)
        for (int col = 0; col < 6; col++)
          target[row][col] = row == col ? 1 : row + col == 5 ? 2 : 0;
      int differences = CanvasRules.countDifferences(history.currentPixels(), target);
      if (differences == 0) session.end("Узор восстановлен во времени!");
      else session.status("Осталось клеток: " + differences);
    }
  }

  @Override
  public void onMousePressed(int x, int y, int button) {
    int row = Math.floorDiv(y - 160, 65), col = Math.floorDiv(x - 70, 65);
    if (row < 0 || row >= 6 || col < 0 || col >= 6) return;
    int[][] next = history.currentPixels();
    next[row][col] = selectedColor;
    history.commit(next);
  }
}
