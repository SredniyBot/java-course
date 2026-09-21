package edu.course.games.balloonrescue.domain;

/** Спасите воздушный шар. Правила игры. Контракты упражнений: README.md. */
public final class WordMask {
  private WordMask() {}

  /**
   * <b>WHAT / contract:</b> Для каждой буквы word добавить саму букву, если она встречается в
   * guessed, иначе _. После каждой позиции добавить пробел.
   *
   * <p><b>Constraints:</b> word/guessed не null, состоят из BMP-букв без суррогатов. Регистр
   * значим; пустые строки допустимы.
   *
   * <p><b>Examples:</b> revealGuessedLetters("JAVA","A") → "_ A _ A "; revealGuessedLetters("","")
   * → "".
   *
   * <p><b>Acceptance criteria:</b> O(word.length*guessed.length); точные границы и отсутствие
   * лишней мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> После последнего символа тоже пробел; повторные буквы открываются
   * вместе.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String revealGuessedLetters(String word, String guessed) {
    // TODO balloon-rescue.revealGuessedLetters: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "balloon-rescue.revealGuessedLetters", () -> "_ ".repeat(word.length()));
  }

  /**
   * <b>WHAT / contract:</b> Все буквы word встречаются в guessed. Повторы не требуют повторных
   * догадок.
   *
   * <p><b>Constraints:</b> Те же ограничения на строки, что у revealGuessedLetters.
   *
   * <p><b>Examples:</b> isFullyGuessed("JAVA","JAV") → true; isFullyGuessed("JAVA","JA") → false;
   * isFullyGuessed("","") → true.
   *
   * <p><b>Acceptance criteria:</b> O(word.length*guessed.length); точные границы и отсутствие
   * лишней мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Количество догадок не равно количеству открытых букв; повторы
   * игнорируются.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isFullyGuessed(String word, String guessed) {
    // TODO balloon-rescue.isFullyGuessed: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "balloon-rescue.isFullyGuessed", () -> false);
  }
}
