package edu.course.games.balloonrescue.ui;

import edu.course.games.balloonrescue.domain.WordMask;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — BalloonRescueRenderer. */
public final class BalloonRescueGame implements DesktopGame {
  private String secret, guessed, maskedWord;
  private int misses;
  private final GameSession context;

  public BalloonRescueGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "11. Спасите воздушный шар",
        "Откройте секретное слово до шести ошибок.",
        "Печатайте латинские буквы");
  }

  @Override
  public void reset() {
    String[] words = {"ARRAY", "STRING", "PIXEL", "PLANET"};
    secret = words[context.random().nextInt(words.length)];
    guessed = "";
    maskedWord = "_ ".repeat(secret.length());
    misses = 0;
  }

  @Override
  public void render(Graphics2D g) {
    BalloonRescueRenderer.draw(g, guessed, maskedWord, misses);
  }

  @Override
  public void onCharacterTyped(char ch) {
    char c = Character.toUpperCase(ch);
    if (c < 'A' || c > 'Z' || guessed.indexOf(c) >= 0) return;
    guessed += c;
    if (secret.indexOf(c) < 0) misses++;
    maskedWord = WordMask.revealGuessedLetters(secret, guessed);
    if (WordMask.isFullyGuessed(secret, guessed)) context.end("Шар спасён!");
    else if (misses >= 6) context.end("Слово было: " + secret);
  }
}
