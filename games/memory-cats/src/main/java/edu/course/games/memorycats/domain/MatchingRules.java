package edu.course.games.memorycats.domain;

/** Котики-близнецы: операции над игровыми данными без интерфейса. */
public final class MatchingRules {
  private MatchingRules() {}

  /**
   * Сравнивает подписи двух разных карточек по содержимому строк. Одинаковый индекс не образует
   * пару, даже если подпись совпадает. Массив не изменяется.
   *
   * <p>cards и строки не null; a,b — действительные индексы. Регистр значим.
   *
   * @param cards подписи карточек, не равные null
   * @param a индекс первой карточки
   * @param b индекс второй карточки
   * @return true для разных индексов с равными строковыми значениями
   */
  public static boolean isMatchingPair(String[] cards, int a, int b) {
    // TODO memory-cats.isMatchingPair: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "memory-cats.isMatchingPair", () -> false);
  }

  /**
   * Считает элементы со значением true. Массив не изменяется.
   *
   * <p>found не null; длина может быть 0.
   *
   * @param found признаки найденных карточек
   * @return число найденных карточек
   */
  public static int countRevealedCards(boolean[] found) {
    int n = 0;
    for (boolean v : found) if (v) n++;
    return n;
  }
}
