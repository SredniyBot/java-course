package edu.course.games.unicodesafari.domain;

/** Unicode-сафари: операции над игровыми данными без интерфейса. */
public final class UnicodeText {
  private UnicodeText() {}

  /**
   * Считает кодовые точки по правилам String.codePointCount. Суррогатная пара считается одной
   * точкой; отдельный суррогат — также одной.
   *
   * <p>text не null; корректный UTF-16. Графемные кластеры специально не считаем.
   *
   * @param text текст, не null
   * @return число кодовых точек
   */
  public static int countCodePoints(String text) {
    return text.codePointCount(0, text.length());
  }

  /**
   * Вычисляет число байтов, необходимых для кодирования текста в UTF-8.
   *
   * <p>text не null; корректный UTF-16; кодировка UTF-8 без BOM.
   *
   * @param text корректный UTF-16 текст
   * @return длина кодирования UTF-8 в байтах
   */
  public static int utf8Length(String text) {
    return text.getBytes(java.nio.charset.StandardCharsets.UTF_8).length;
  }

  /**
   * Возвращает первые n кодовых точек текста, не разрывая суррогатную пару. Если точек меньше n,
   * возвращает весь текст; при n=0 — пустую строку.
   *
   * <p>Следует правилам String.codePointCount: одиночный суррогат считается одной точкой.
   * Комбинируемые знаки не объединяются с предыдущей буквой.
   *
   * @param text текст, не null
   * @param n максимальное число кодовых точек, неотрицательное
   * @return префикс без разрыва суррогатной пары; весь текст, если n достаточно велик
   * @throws NullPointerException если text равен null
   * @throws IllegalArgumentException если n отрицателен
   */
  public static String prefixByCodePoints(String text, int n) {
    // TODO unicode-safari.prefixByCodePoints: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "unicode-safari.prefixByCodePoints", () -> "");
  }
}
