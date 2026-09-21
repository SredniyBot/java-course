package edu.course.games.wordrain.domain;

/** Словопад. Правила игры. Контракты упражнений: README.md. */
public final class WordRules {
  private WordRules() {}

  /**
   * <b>WHAT / contract:</b> Убрать пробелы по краям и привести к нижнему регистру с Locale.ROOT.
   *
   * <p><b>Constraints:</b> text не null; используются правила String.strip и Locale.ROOT,
   * внутренние пробелы сохраняются.
   *
   * <p><b>Examples:</b> normalizeInput(" JAVA ") → "java"; normalizeInput("A B") → "a b";
   * normalizeInput("") → "".
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> trim и strip различаются; регистр не должен зависеть от системной
   * локали.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String normalizeInput(String text) {
    // TODO word-rain.normalizeInput: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("word-rain.normalizeInput");
  }

  /**
   * <b>WHAT / contract:</b> Вернуть true, если word начинается с input. Пустой input является
   * префиксом.
   *
   * <p><b>Constraints:</b> word и input не null; сравнение регистрозависимое, дополнительной
   * нормализации нет.
   *
   * <p><b>Examples:</b> isPrefix("java","") → true; isPrefix("java","jav") → true;
   * isPrefix("java","Java") → false.
   *
   * <p><b>Acceptance criteria:</b> O(input.length); точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Присутствие подстроки не означает префикс; пустая строка — префикс.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isPrefix(String word, String input) {
    // TODO word-rain.isPrefix: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("word-rain.isPrefix");
  }
}
