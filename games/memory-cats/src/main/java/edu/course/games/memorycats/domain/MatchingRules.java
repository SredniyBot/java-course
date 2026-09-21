package edu.course.games.memorycats.domain;

/** Котики-близнецы. Правила игры. Контракты упражнений: README.md. */
public final class MatchingRules {
  private MatchingRules() {}

  /**
   * <b>WHAT / contract:</b> Индексы валидны. Пара — разные индексы с одинаковым текстом. Сравнивать
   * содержимое, не ссылки.
   *
   * <p><b>Constraints:</b> cards и строки не null; a,b — действительные индексы. Регистр значим.
   *
   * <p><b>Examples:</b> isMatchingPair([new String("A"),new String("A")],0,1) → true; a=b → false.
   *
   * <p><b>Acceptance criteria:</b> O(длины строки); точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> == сравнивает ссылки; совпадение карточки с самой собой не пара.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isMatchingPair(String[] cards, int a, int b) {
    // TODO memory-cats.isMatchingPair: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("memory-cats.isMatchingPair");
  }

  /**
   * <b>WHAT / contract:</b> Посчитать найденные карточки.
   *
   * <p><b>Constraints:</b> found не null; длина может быть 0.
   *
   * <p><b>Examples:</b> countRevealedCards([true,false,true]) → 2; countRevealedCards([]) → 0.
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Возвращать число карточек, а не число пар; found не менять.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int countRevealedCards(boolean[] found) {
    // TODO memory-cats.countRevealedCards: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("memory-cats.countRevealedCards");
  }
}
