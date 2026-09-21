package edu.course.games.wordrain.domain;

/** Словопад: операции над игровыми данными без интерфейса. */
public final class WordRules {
  private WordRules() {}

  /**
   * Удаляет краевые пробельные символы по правилам String.strip и переводит текст в нижний регистр
   * с Locale.ROOT. Внутренние пробелы сохраняются.
   *
   * <p>text не null; используются правила String.strip и Locale.ROOT, внутренние пробелы
   * сохраняются.
   *
   * @param text введённый текст, не null
   * @return текст без краевых пробелов, в нижнем регистре Locale.ROOT
   */
  public static String normalizeInput(String text) {
    // TODO word-rain.normalizeInput: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("word-rain.normalizeInput", () -> text);
  }

  /**
   * Проверяет, начинается ли слово с input. Сравнение чувствительно к регистру; пустой ввод
   * является префиксом любого слова.
   *
   * <p>word и input не null; сравнение регистрозависимое, дополнительной нормализации нет.
   *
   * @param word слово для сравнения
   * @param input уже нормализованный ввод
   * @return true, если слово начинается с введённого текста
   */
  public static boolean isPrefix(String word, String input) {
    return word.startsWith(input);
  }
}
