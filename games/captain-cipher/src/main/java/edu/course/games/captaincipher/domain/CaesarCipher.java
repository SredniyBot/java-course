package edu.course.games.captaincipher.domain;

/** Шифр капитана. Правила игры. Контракты упражнений: README.md. */
public final class CaesarCipher {
  private CaesarCipher() {}

  /**
   * <b>WHAT / contract:</b> Для A…Z циклический сдвиг на offset (может быть отрицательным).
   * Остальные символы не менять. Используйте Math.floorMod.
   *
   * <p><b>Constraints:</b> Любой char и любой int offset, включая MIN_VALUE и MAX_VALUE.
   *
   * <p><b>Examples:</b> shiftUppercase('Z',1) → A; shiftUppercase('A',-1) → Z;
   * shiftUppercase('!',7) → !; shiftUppercase('Z',MAX_VALUE) → W.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Сначала нормализуйте offset: ch+offset может переполниться.
   * Отрицательный % — не floorMod.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static char shiftUppercase(char ch, int offset) {
    // TODO captain-cipher.shiftUppercase: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "captain-cipher.shiftUppercase", () -> ch);
  }

  /**
   * <b>WHAT / contract:</b> Применить shiftUppercase к каждому char, собрать строку.
   *
   * <p><b>Constraints:</b> text не null; любой offset; меняются только латинские A..Z.
   *
   * <p><b>Examples:</b> encode("AZ-я",1) → "BA-я"; encode("",7) → "".
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> lowercase и Unicode-символы сохраняются; нормализация регистра
   * здесь запрещена.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String encode(String text, int offset) {
    // TODO captain-cipher.encode: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("captain-cipher.encode", () -> text);
  }
}
