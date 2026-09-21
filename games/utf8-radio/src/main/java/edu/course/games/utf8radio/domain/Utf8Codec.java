package edu.course.games.utf8radio.domain;

/** Радио UTF-8. Правила игры. Контракты упражнений: README.md. */
public final class Utf8Codec {
  private Utf8Codec() {}

  /**
   * <b>WHAT / contract:</b> Представить byte как целое 0…255.
   *
   * <p><b>Constraints:</b> Любое значение byte от -128 до 127.
   *
   * <p><b>Examples:</b> toUnsigned((byte)-1) → 255; toUnsigned((byte)-128) → 128;
   * toUnsigned((byte)0) → 0.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Обычный cast в int сохраняет знак.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int toUnsigned(byte value) {
    // TODO utf8-radio.toUnsigned: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("utf8-radio.toUnsigned", () -> 0);
  }

  /**
   * <b>WHAT / contract:</b> Строго декодировать первые count байтов UTF-8. При
   * CharacterCodingException вернуть строку &lt;ошибка&gt;. Остаток массива не читать.
   *
   * <p><b>Constraints:</b> packet не null; 0≤count≤packet.length. При некорректном/обрезанном UTF-8
   * вернуть ровно &lt;ошибка&gt;.
   *
   * <p><b>Examples:</b> decodePrefix([0x41,0xFF],1) → "A"; count=2 → "&lt;ошибка&gt;"; count=0 →
   * ""; одиночный 0xD0 → "&lt;ошибка&gt;".
   *
   * <p><b>Acceptance criteria:</b> O(count); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> new String заменяет ошибочные байты без отказа; хвост после count
   * не декодировать.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String decodePrefix(byte[] packet, int count) {
    // TODO utf8-radio.decodePrefix: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "utf8-radio.decodePrefix", () -> "<не реализовано>");
  }
}
