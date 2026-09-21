package edu.course.games.utf8radio.ui;

import static edu.course.platform.desktop.GameDrawing.text;

import edu.course.games.utf8radio.domain.Utf8Codec;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — Utf8RadioRenderer. */
public final class Utf8RadioGame implements DesktopGame {
  private String word;
  private byte[] pool, packet;
  private boolean[] used;
  private int count;
  private final GameSession context;

  public Utf8RadioGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "22. Радио UTF-8",
        "Соберите байты сообщения в правильном порядке. Пройдите 5 передач.",
        "Мышь — выбрать байт; Enter — декодировать; Backspace — очистить");
  }

  @Override
  public void reset() {
    word = "Кот";
    prepare();
  }

  @Override
  public void render(Graphics2D g) {
    Utf8RadioRenderer.draw(g, word, pool, packet, used, count, context.score());
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_BACK_SPACE) {
      count = 0;
      java.util.Arrays.fill(used, false);
    }
    if (key == KeyEvent.VK_ENTER) {
      String text = Utf8Codec.decodePrefix(packet, count);
      context.status("Принято: " + text);
      if (count == pool.length && text.equals(word)) {
        context.addScore(1);
        String[] words = {"Луна", "Мяу", "A🐱", "Я", "Кот"};
        word = words[context.random().nextInt(words.length)];
        prepare();
        if (context.score() == 5) context.end("Связь с Луной установлена!");
      }
    }
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 90, 100), r = Math.floorDiv(my - 250, 90), i = r * 8 + c;
    if (r < 0 || r > 1 || c < 0 || c >= 8 || i >= pool.length || used[i]) return;
    used[i] = true;
    packet[count++] = pool[i];
    context.status("Байт " + Utf8Codec.toUnsigned(pool[i]) + " добавлен");
  }

  private void prepare() {
    pool = word.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    for (int i = pool.length - 1; i > 0; i--) {
      int j = context.random().nextInt(i + 1);
      byte t = pool[i];
      pool[i] = pool[j];
      pool[j] = t;
    }
    packet = new byte[pool.length];
    used = new boolean[pool.length];
    count = 0;
  }
}
