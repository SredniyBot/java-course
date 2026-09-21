package edu.course.games.captaincipher.ui;

import edu.course.games.captaincipher.domain.CaesarCipher;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — CaptainCipherRenderer. */
public final class CaptainCipherGame implements DesktopGame {
  private String secret, encode, input;
  private int shiftUppercase;
  private final GameSession context;

  public CaptainCipherGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "23. Шифр капитана",
        "Расшифруйте пять приказов со сдвигом Цезаря.",
        "Space — получить приказ; ввод латиницей; Enter — ответ");
  }

  @Override
  public void reset() {
    secret = "MOON";
    encode = "Нажмите Space";
    input = "";
    shiftUppercase = 3;
  }

  @Override
  public void render(Graphics2D g) {
    CaptainCipherRenderer.draw(g, encode, input, shiftUppercase, context.score());
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_SPACE) encode = CaesarCipher.encode(secret, shiftUppercase);
    if (key == KeyEvent.VK_BACK_SPACE && !input.isEmpty())
      input = input.substring(0, input.length() - 1);
    if (key == KeyEvent.VK_ENTER) {
      if (input.equals(secret)) {
        context.addScore(1);
        String[] words = {"CAT", "STAR", "JAVA", "ARRAY", "ROCKET"};
        secret = words[context.random().nextInt(words.length)];
        shiftUppercase = 1 + context.random().nextInt(10);
        encode = CaesarCipher.encode(secret, shiftUppercase);
        input = "";
        if (context.score() == 5) context.end("Приказы расшифрованы!");
      } else context.status("Капитан ждёт другой ответ");
    }
  }

  @Override
  public void onCharacterTyped(char ch) {
    char c = Character.toUpperCase(ch);
    if (c >= 'A' && c <= 'Z' && input.length() < 20) input += c;
  }
}
