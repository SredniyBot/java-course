package edu.course.games.marsmines.domain;

/** Сапёр на Марсе. Правила игры. Контракты упражнений: README.md. */
public final class MinefieldRules {
  private MinefieldRules() {}

  /**
   * <b>WHAT / contract:</b> Посчитать мины в восьми соседних клетках. Саму клетку не считать; не
   * выходить за границы.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная матрица; row,col внутри.
   *
   * <p><b>Examples:</b> countAdjacentMines([[true]],0,0) → 0; в полностью заминированном поле 3×3
   * центр → 8, угол → 3.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Центральная клетка не сосед; диагонали входят в восемь направлений.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int countAdjacentMines(boolean[][] mines, int row, int col) {
    // TODO mars-mines.countAdjacentMines: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("mars-mines.countAdjacentMines");
  }

  /**
   * <b>WHAT / contract:</b> Все клетки без мин открыты. Флаги не влияют на победу.
   *
   * <p><b>Constraints:</b> Прямоугольные mines/open одинакового размера, строки не null; пустые
   * поля допустимы.
   *
   * <p><b>Examples:</b> mines=[[true,false]], open=[[false,true]] → true; open=[[true,false]] →
   * false.
   *
   * <p><b>Acceptance criteria:</b> O(h*w); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Мины открывать для победы не нужно; на поле только с минами условие
   * выполнено.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean allSafeCellsOpen(boolean[][] mines, boolean[][] open) {
    // TODO mars-mines.allSafeCellsOpen: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("mars-mines.allSafeCellsOpen");
  }
}
