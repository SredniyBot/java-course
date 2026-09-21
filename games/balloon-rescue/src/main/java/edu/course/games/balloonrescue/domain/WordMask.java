package edu.course.games.balloonrescue.domain;

/** Спасите воздушный шар: операции над игровыми данными без интерфейса. */
public final class WordMask {
  private WordMask() {}

  /**
   * Строит маску слова: угаданные символы сохраняются, остальные заменяются подчёркиванием. После
   * каждого символа, включая последний, добавляется один пробел. Все вхождения угаданной буквы
   * открываются одновременно.
   *
   * <p>word/guessed не null, состоят из BMP-букв без суррогатов. Регистр значим; пустые строки
   * допустимы.
   *
   * @param word слово из символов BMP
   * @param guessed угаданные символы; повторы допускаются
   * @return открытые буквы и подчёркивания; после каждого символа стоит пробел
   */
  public static String revealGuessedLetters(String word, String guessed) {
    // TODO balloon-rescue.revealGuessedLetters: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "balloon-rescue.revealGuessedLetters", () -> "_ ".repeat(word.length()));
  }

  /**
   * Проверяет, входит ли каждый символ слова в guessed. Порядок и повторения угаданных символов не
   * влияют на результат. Для пустого слова возвращает true.
   *
   * <p>Те же ограничения на строки, что у revealGuessedLetters.
   *
   * @param word слово из символов BMP
   * @param guessed угаданные символы
   * @return true, если угаданы все буквы слова
   */
  public static boolean isFullyGuessed(String word, String guessed) {
    for (int i = 0; i < word.length(); i++) if (guessed.indexOf(word.charAt(i)) < 0) return false;
    return true;
  }
}
