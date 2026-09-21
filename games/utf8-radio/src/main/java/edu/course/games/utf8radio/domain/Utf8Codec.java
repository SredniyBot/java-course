package edu.course.games.utf8radio.domain;

/** Радио UTF-8: операции над игровыми данными без интерфейса. */
public final class Utf8Codec {
  private Utf8Codec() {}

  /**
   * Представляет восемь бит byte как неотрицательное целое без изменения битового рисунка.
   *
   * <p>Любое значение byte от -128 до 127.
   *
   * @param value байт со знаком
   * @return значение байта от 0 до 255
   */
  public static int toUnsigned(byte value) {
    return value & 0xFF;
  }

  /**
   * Вызывает decodeStrict и преобразует только CharacterCodingException в строку «&lt;ошибка&gt;»
   * для интерфейса. Ошибки аргументов не перехватывает.
   *
   * <p>packet не null; 0≤count≤packet.length. При некорректном/обрезанном UTF-8 вернуть ровно
   * &lt;ошибка&gt;.
   *
   * @param packet буфер принятого сообщения
   * @param count число байтов для декодирования
   * @return декодированный текст или строка «&lt;ошибка&gt;» при ошибке UTF-8
   */
  public static String decodePrefix(byte[] packet, int count) {
    try {
      return decodeStrict(packet, count);
    } catch (java.nio.charset.CharacterCodingException ex) {
      return "<ошибка>";
    }
  }

  /**
   * Декодирует первые count байтов как полный текст UTF-8. Отклоняет некорректные и оборванные
   * последовательности, не подставляя символ замены.
   *
   * <p>Хвост массива не читается. Исходный массив не изменяется; count=0 даёт пустую строку.
   *
   * @param packet буфер принятого сообщения
   * @param count число байтов для декодирования
   * @return декодированный текст, в том числе пустая строка
   * @throws NullPointerException если packet равен null
   * @throws IndexOutOfBoundsException если count вне диапазона 0..packet.length
   * @throws java.nio.charset.CharacterCodingException если выбранный префикс не является полным
   *     корректным UTF-8
   */
  public static String decodeStrict(byte[] packet, int count)
      throws java.nio.charset.CharacterCodingException {
    // TODO utf8-radio.decodeStrict: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("utf8-radio.decodeStrict", () -> "");
  }
}
