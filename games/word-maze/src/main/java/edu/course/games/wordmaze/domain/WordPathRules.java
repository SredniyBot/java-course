package edu.course.games.wordmaze.domain;

/** Буквенный лабиринт: операции над игровыми данными без интерфейса. */
public final class WordPathRules {
  private WordPathRules() {}

  /**
   * Проверяет соседство двух линейных индексов по стороне. Конец одной строки и начало следующей не
   * являются соседями; диагональ также не учитывается.
   *
   * <p>width&gt;0, a,b ≥0, до 10^6; индексы одной сетки в построчной нумерации.
   *
   * @param a линейный индекс первой клетки
   * @param b линейный индекс второй клетки
   * @param width число столбцов поля
   * @return true для соседства по стороне
   */
  public static boolean areSideNeighbors(int a, int b, int width) {
    return Math.abs(a / width - b / width) + Math.abs(a % width - b % width) == 1;
  }

  /**
   * Собирает строку из первых length клеток пути. Линейный индекс переводится в строку и столбец по
   * ширине поля. Повторы и несоседние клетки допустимы.
   *
   * <p>Не читает хвост path после length и не изменяет входные данные. Проверку соседства выбранных
   * клеток выполняет вызывающий код.
   *
   * @param board прямоугольное поле букв
   * @param path линейные индексы клеток в порядке чтения
   * @param length число читаемых индексов; остальной хвост не используется
   * @return буквы активного пути без разделителей
   * @throws NullPointerException если board или path равен null
   * @throws IllegalArgumentException если поле пустое, содержит null-строки, непрямоугольно либо
   *     length вне 0..path.length
   * @throws IndexOutOfBoundsException если активный индекс пути не принадлежит полю
   */
  public static String readPath(char[][] board, int[] path, int length) {
    // TODO word-maze.readPath: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("word-maze.readPath", () -> "");
  }
}
