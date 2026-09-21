package edu.course.games.wordrain.ui;

import edu.course.games.wordrain.domain.WordRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — WordRainRenderer. */
public final class WordRainGame implements DesktopGame {
  private String word, input;
  private double y;
  private int lives;
  private boolean isPrefix;
  private final GameSession context;

  public WordRainGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "10. Словопад",
        "Напечатайте 12 падающих слов до их приземления.",
        "Печатайте латиницей; Enter — отправить; Backspace — стереть");
  }

  @Override
  public void reset() {
    word = "moon";
    input = "";
    y = 165;
    lives = 3;
    isPrefix = true;
  }

  @Override
  public void render(Graphics2D g) {
    WordRainRenderer.draw(g, word, input, y, lives, isPrefix, context.score());
  }

  @Override
  public void update(double dt) {
    y += 24 * dt;
    if (y > 535) {
      lives--;
      nextWord();
      if (lives == 0) context.end("Словопад закончился. F5 — заново");
    }
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_BACK_SPACE && !input.isEmpty())
      input = input.substring(0, input.length() - 1);
    if (key == KeyEvent.VK_ENTER) {
      if (WordRules.normalizeInput(input).equals(word)) {
        context.addScore(1);
        nextWord();
        if (context.score() == 12) context.end("Все слова пойманы!");
      } else context.status("Слово не совпало");
    }
    isPrefix = WordRules.isPrefix(word, WordRules.normalizeInput(input));
  }

  @Override
  public void onCharacterTyped(char ch) {
    if (Character.isLetter(ch) && input.length() < 20) {
      input += ch;
      isPrefix = WordRules.isPrefix(word, WordRules.normalizeInput(input));
    }
  }

  private void nextWord() {
    String[] words = {"moon", "array", "pixel", "java", "space", "cat", "loop", "string"};
    word = words[context.random().nextInt(words.length)];
    input = "";
    y = 165;
    isPrefix = true;
  }
}
