package edu.course.games.captaincipher.domain;

/** Шифр капитана: операции над игровыми данными без интерфейса. */
public final class CaesarCipher {
  private CaesarCipher() {}

  /**
   * Сдвигает латинскую заглавную букву по кольцу A–Z. Другие символы возвращает без изменения.
   * Поддерживает любой offset, включая предельные значения int.
   *
   * <p>Любой char и любой int offset, включая MIN_VALUE и MAX_VALUE.
   *
   * @param ch символ для сдвига; меняются только A–Z
   * @param offset сдвиг; любое значение int
   * @return сдвинутая буква A–Z или неизменённый другой символ
   */
  public static char shiftUppercase(char ch, int offset) {
    if (ch < 'A' || ch > 'Z') return ch;
    return (char) ('A' + Math.floorMod(ch - 'A' + Math.floorMod(offset, 26), 26));
  }

  /**
   * Сдвигает каждую букву A–Z на offset по кольцу латинского алфавита. Остальные символы, включая
   * пробелы, переносы строк и суррогатные пары, сохраняются. Использует правила shiftUppercase.
   *
   * <p>text не null; любой offset; меняются только латинские A..Z.
   *
   * @param text исходный текст
   * @param offset сдвиг букв A–Z; любое значение int
   * @return текст после сдвига только букв A–Z
   */
  public static String encode(String text, int offset) {
    // TODO captain-cipher.encode: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("captain-cipher.encode", () -> text);
  }
}
