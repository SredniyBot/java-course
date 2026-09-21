package edu.course.games.memorycats.ui;

import edu.course.games.memorycats.domain.MatchingRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;

/** Контроллер ввода и анимации. Правила — domain, рисование — MemoryCatsRenderer. */
public final class MemoryCatsGame implements DesktopGame {
  private String[] cards;
  private boolean[] found;
  private int firstCardIndex, secondCardIndex;
  private double revealSeconds;
  private final GameSession context;

  public MemoryCatsGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "09. Котики-близнецы", "Найдите восемь пар карточек.", "Мышь — открыть карточку");
  }

  @Override
  public void reset() {
    cards =
        new String[] {
          "MISO", "MISO", "NORI", "NORI", "YUZU", "YUZU", "MOON", "MOON", "STAR", "STAR", "PAW",
          "PAW", "MILK", "MILK", "FISH", "FISH"
        };
    java.util.Collections.shuffle(java.util.Arrays.asList(cards), context.random());
    found = new boolean[16];
    firstCardIndex = -1;
    secondCardIndex = -1;
    revealSeconds = 0;
  }

  @Override
  public void render(Graphics2D g) {
    MemoryCatsRenderer.draw(g, cards, found, firstCardIndex, secondCardIndex);
  }

  @Override
  public void update(double dt) {
    if (secondCardIndex >= 0) {
      revealSeconds += dt;
      if (revealSeconds > .65) {
        if (MatchingRules.isMatchingPair(cards, firstCardIndex, secondCardIndex)) {
          found[firstCardIndex] = true;
          found[secondCardIndex] = true;
        }
        firstCardIndex = -1;
        secondCardIndex = -1;
        revealSeconds = 0;
        if (MatchingRules.countRevealedCards(found) == 16)
          context.end("Все котики нашли близнецов!");
      }
    }
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int c = Math.floorDiv(mx - 170, 155), r = Math.floorDiv(my - 150, 110);
    if (r < 0 || r >= 4 || c < 0 || c >= 4 || secondCardIndex >= 0) return;
    int i = r * 4 + c;
    if (found[i] || i == firstCardIndex) return;
    if (firstCardIndex < 0) firstCardIndex = i;
    else secondCardIndex = i;
  }
}
