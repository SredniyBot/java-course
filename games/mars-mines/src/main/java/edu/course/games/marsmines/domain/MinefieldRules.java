package edu.course.games.marsmines.domain;

/** Сапёр на Марсе: операции над игровыми данными без интерфейса. */
public final class MinefieldRules {
  private MinefieldRules() {}

  /**
   * Считает мины в соседних по стороне или диагонали клетках. Саму клетку (row, col) не учитывает.
   * Соседи за границей поля отсутствуют; поле не изменяется.
   *
   * <p>Непустая прямоугольная матрица; row,col внутри.
   *
   * @param mines прямоугольное поле мин
   * @param row строка исследуемой клетки
   * @param col столбец исследуемой клетки
   * @return число мин среди восьми соседей, без самой клетки
   */
  public static int countAdjacentMines(boolean[][] mines, int row, int col) {
    // TODO mars-mines.countAdjacentMines: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("mars-mines.countAdjacentMines", () -> 0);
  }

  /**
   * Проверяет, открыты ли все клетки без мин. Состояние клеток с минами не влияет на результат.
   * Если безопасных клеток нет, возвращает true.
   *
   * <p>Прямоугольные mines/open одинакового размера, строки не null; пустые поля допустимы.
   *
   * @param mines поле мин
   * @param open открытые клетки той же формы
   * @return true, если открыты все клетки без мин
   */
  public static boolean allSafeCellsOpen(boolean[][] mines, boolean[][] open) {
    for (int r = 0; r < mines.length; r++)
      for (int c = 0; c < mines[r].length; c++) if (!mines[r][c] && !open[r][c]) return false;
    return true;
  }
}
