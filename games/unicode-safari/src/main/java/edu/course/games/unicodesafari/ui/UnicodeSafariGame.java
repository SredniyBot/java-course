package edu.course.games.unicodesafari.ui;

import edu.course.games.unicodesafari.domain.UnicodeText;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — UnicodeSafariRenderer. */
public final class UnicodeSafariGame implements DesktopGame {
  private String[] labels = {"A", "Ж", "🐱", "A🐱", "é", "é"};
  private int target, mode;
  private final GameSession context;

  public UnicodeSafariGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "21. Unicode-сафари",
        "Поймайте 10 карточек, удовлетворяющих заказу по числу кодовых точек или байтов.",
        "Мышь — выбрать карточку");
  }

  @Override
  public void reset() {
    mode = 0;
    target = 1;
  }

  @Override
  public void render(Graphics2D g) {
    UnicodeSafariRenderer.draw(g, labels, target, mode, context.score());
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 135, 240), r = Math.floorDiv(my - 260, 140);
    if (r < 0 || r >= 2 || c < 0 || c >= 3) return;
    String s = labels[r * 3 + c];
    int n = mode == 0 ? UnicodeText.countCodePoints(s) : UnicodeText.utf8Length(s);
    if (n == target) {
      context.addScore(1);
      context.status("Поймано: " + UnicodeText.prefixByCodePoints(s, 1));
      mode = context.random().nextInt(2);
      String next = labels[context.random().nextInt(labels.length)];
      target =
          mode == 0
              ? next.codePointCount(0, next.length())
              : next.getBytes(java.nio.charset.StandardCharsets.UTF_8).length;
      if (context.score() == 10) context.end("Коллекция Unicode собрана!");
    } else context.status("У этой карточки значение " + n);
  }
}
