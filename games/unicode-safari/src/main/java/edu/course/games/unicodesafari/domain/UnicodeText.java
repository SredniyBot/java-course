package edu.course.games.unicodesafari.domain;

/** Unicode-сафари. Правила игры. Контракты упражнений: README.md. */
public final class UnicodeText {
  private UnicodeText() {}

  /**
   * <b>WHAT / contract:</b> Посчитать Unicode-кодовые точки, не char. Используйте codePointCount на
   * всей строке.
   *
   * <p><b>Constraints:</b> text не null; корректный UTF-16. Графемные кластеры специально не
   * считаем.
   *
   * <p><b>Examples:</b> countCodePoints("A😀") → 2; countCodePoints("é") → 2; countCodePoints("")
   * → 0.
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> char, code point и видимый символ — три разных понятия.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int countCodePoints(String text) {
    // TODO unicode-safari.countCodePoints: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("unicode-safari.countCodePoints");
  }

  /**
   * <b>WHAT / contract:</b> Число байтов при кодировании UTF-8; кодировку задать явно.
   *
   * <p><b>Constraints:</b> text не null; корректный UTF-16; кодировка UTF-8 без BOM.
   *
   * <p><b>Examples:</b> utf8Length("A😀") → 5; utf8Length("Я") → 2; utf8Length("") → 0.
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Не использовать defaultCharset; размер в памяти UTF-16 — не размер
   * UTF-8.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int utf8Length(String text) {
    // TODO unicode-safari.utf8Length: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("unicode-safari.utf8Length");
  }

  /**
   * <b>WHAT / contract:</b> Вернуть первые n кодовых точек, не разрывая суррогатные пары. Если n
   * больше количества, вернуть всю строку; n&gt;=0.
   *
   * <p><b>Constraints:</b> text корректный UTF-16, не null; n≥0.
   *
   * <p><b>Examples:</b> prefixByCodePoints("A😀B",2) → "A😀"; n=0 → ""; n=99 → вся строка.
   *
   * <p><b>Acceptance criteria:</b> O(text.length); точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> substring(0,n) индексирует char; составная графема может
   * разделиться по контракту.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String prefixByCodePoints(String text, int n) {
    // TODO unicode-safari.prefixByCodePoints: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("unicode-safari.prefixByCodePoints");
  }
}
