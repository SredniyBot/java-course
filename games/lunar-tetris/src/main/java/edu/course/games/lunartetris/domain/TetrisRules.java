package edu.course.games.lunartetris.domain;

/** Тетрис: стройка на Луне. Правила игры. Контракты упражнений: README.md. */
public final class TetrisRules {
  private TetrisRules() {}

  /**
   * <b>WHAT / contract:</b> Вернуть новую матрицу, повёрнутую на 90° по часовой стрелке.
   * Прямоугольная непустая матрица. Оригинал не менять.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная int-матрица, строки не null и ширина &gt;0.
   *
   * <p><b>Examples:</b> rotateClockwise([[1,2,3],[4,5,6]]) → [[4,1],[5,2],[6,3]].
   *
   * <p><b>Acceptance criteria:</b> O(h*w) времени/памяти; точные границы и отсутствие лишней
   * мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Поворот прямоугольника меняет размеры; новая внешняя матрица со
   * старыми строками недостаточна.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int[][] rotateClockwise(int[][] a) {
    // TODO lunar-tetris.rotateClockwise: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "lunar-tetris.rotateClockwise",
        () -> java.util.Arrays.stream(a).map(int[]::clone).toArray(int[][]::new));
  }

  /**
   * <b>WHAT / contract:</b> Все ненулевые клетки piece должны лежать внутри board и попадать в
   * нулевые клетки. y отрицательным не бывает.
   *
   * <p><b>Constraints:</b> board и piece непустые прямоугольные; x,y целые abs ≤ 10^6; board
   * 0=пусто, ненулевое=занято.
   *
   * <p><b>Examples:</b> board=[[0,0],[0,1]], piece=[[1]]: (0,0) → true; (1,1) → false; (-1,0) →
   * false. Пустые клетки piece не ограничивают размещение.
   *
   * <p><b>Acceptance criteria:</b> O(piece.h*piece.w); точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Сначала границы, затем индексирование; учитываются только ненулевые
   * клетки фигуры.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean canPlace(int[][] board, int[][] piece, int x, int y) {
    // TODO lunar-tetris.canPlace: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("lunar-tetris.canPlace", () -> false);
  }

  /**
   * <b>WHAT / contract:</b> На месте убрать полностью ненулевые строки; остальные опустить вниз,
   * верх заполнить нулями. Вернуть число удалённых строк.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная матрица ширины &gt;0; строки — разные объекты.
   *
   * <p><b>Examples:</b> [[1,1],[0,2],[3,3]] → [[0,0],[0,0],[0,2]], результат 2.
   *
   * <p><b>Acceptance criteria:</b> O(h*w), O(1) доп. памяти; точные границы и отсутствие лишней
   * мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> После удаления соседней полной строки нельзя пропустить следующую;
   * порядок неполных строк сохраняется.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int removeFullRows(int[][] b) {
    // TODO lunar-tetris.removeFullRows: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("lunar-tetris.removeFullRows", () -> 0);
  }
}
