package edu.course.games.wordmaze.ui;

import edu.course.games.wordmaze.domain.WordPathRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — WordMazeRenderer. */
public final class WordMazeGame implements DesktopGame {
  private char[][] letters = {
    {'J', 'A', 'M', 'O'}, {'T', 'V', 'A', 'O'}, {'P', 'I', 'X', 'L'}, {'C', 'O', 'D', 'E'}
  };
  private int[] path = new int[16];
  private int count;
  private String trail;
  private final GameSession context;

  public WordMazeGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "12. Буквенный лабиринт",
        "Пройдите по буквам слова JAVA, выбирая соседние клетки.",
        "Мышь — выбрать букву; Backspace — отменить путь");
  }

  @Override
  public void reset() {
    count = 0;
    trail = "";
  }

  @Override
  public void render(Graphics2D g) {
    WordMazeRenderer.draw(g, letters, path, count, trail);
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_BACK_SPACE) {
      count = 0;
      trail = "";
    }
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 270, 100), r = Math.floorDiv(my - 155, 100);
    if (c < 0 || c >= 4 || r < 0 || r >= 4) return;
    int i = r * 4 + c;
    for (int j = 0; j < count; j++) if (path[j] == i) return;
    if (count > 0 && !WordPathRules.areSideNeighbors(path[count - 1], i, 4)) return;
    path[count++] = i;
    trail = WordPathRules.readPath(letters, path, count);
    if (trail.equals("JAVA")) context.end("Путь найден!");
    else if (!"JAVA".startsWith(trail)) context.status("Не тот путь. Backspace — очистить");
  }
}
