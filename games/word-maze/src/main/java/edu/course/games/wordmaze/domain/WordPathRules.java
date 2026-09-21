package edu.course.games.wordmaze.domain;

/** Буквенный лабиринт. Правила игры. Контракты упражнений: README.md. */
public final class WordPathRules {
  private WordPathRules() {}

  /**
   * <b>WHAT / contract:</b> Индексы одной сетки. Разрешено соседство только по стороне, без
   * переноса между строками.
   *
   * <p><b>Constraints:</b> width&gt;0, a,b ≥0, до 10^6; индексы одной сетки в построчной нумерации.
   *
   * <p><b>Examples:</b> areSideNeighbors(2,3,3) → false; areSideNeighbors(1,4,3) → true;
   * areSideNeighbors(1,1,3) → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Разность индексов 1 может пересекать границу строки; диагональ не
   * сосед.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean areSideNeighbors(int a, int b, int width) {
    // TODO word-maze.areSideNeighbors: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("word-maze.areSideNeighbors");
  }

  /**
   * <b>WHAT / contract:</b> Собрать буквы первых length индексов path в строку. Ширина
   * board[0].length.
   *
   * <p><b>Constraints:</b> board непустой прямоугольный, width&gt;0; path не null;
   * 0≤length≤path.length; первые length индексов внутри board.
   *
   * <p><b>Examples:</b> readPath([[J,A],[V,A]],[0,1,2,3],4) → "JAVA"; length=0 → "".
   *
   * <p><b>Acceptance criteria:</b> O(length); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Используется ширина, а не высота; элементы path после length не
   * читать.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String readPath(char[][] board, int[] path, int length) {
    // TODO word-maze.readPath: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("word-maze.readPath");
  }
}
