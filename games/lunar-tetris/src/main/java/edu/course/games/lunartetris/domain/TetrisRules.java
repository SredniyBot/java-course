package edu.course.games.lunartetris.domain;

/** Тетрис: стройка на Луне: операции над игровыми данными без интерфейса. */
public final class TetrisRules {
  private TetrisRules() {}

  /**
   * Возвращает повёрнутую на 90° по часовой стрелке матрицу. Исходная матрица не изменяется, строки
   * результата не разделяют с ней память.
   *
   * <p>Непустая прямоугольная int-матрица, строки не null и ширина &gt;0.
   *
   * @param a исходная матрица; строки не равны null
   * @return новая матрица без общих строк с исходной
   */
  public static int[][] rotateClockwise(int[][] a) {
    int h = a.length, w = a[0].length;
    int[][] b = new int[w][h];
    for (int r = 0; r < h; r++) for (int c = 0; c < w; c++) b[c][h - 1 - r] = a[r][c];
    return b;
  }

  /**
   * Проверяет, помещаются ли занятые клетки фигуры на свободных клетках поля. Нулевые клетки фигуры
   * игнорируются, в том числе за границей поля. Оба массива остаются неизменными.
   *
   * <p>board и piece непустые прямоугольные; x,y целые abs ≤ 10^6; board 0=пусто, ненулевое=занято.
   *
   * @param board поле: 0 означает свободную клетку
   * @param piece фигура: ненулевые элементы заняты
   * @param x столбец левого верхнего угла фигуры
   * @param y строка левого верхнего угла фигуры
   * @return true, если занятые клетки фигуры помещаются на свободных клетках поля
   */
  public static boolean canPlace(int[][] board, int[][] piece, int x, int y) {
    for (int r = 0; r < piece.length; r++)
      for (int c = 0; c < piece[r].length; c++)
        if (piece[r][c] != 0) {
          int yy = y + r, xx = x + c;
          if (yy < 0 || yy >= board.length || xx < 0 || xx >= board[0].length || board[yy][xx] != 0)
            return false;
        }
    return true;
  }

  /**
   * Удаляет полностью заполненные строки и сдвигает оставшиеся вниз, сохраняя их порядок.
   * Освободившиеся верхние строки заполняются нулями. Меняет значения в существующих массивах,
   * сохраняя ссылки на строки.
   *
   * <p>Непустая прямоугольная матрица ширины &gt;0; строки — разные объекты.
   *
   * @param b изменяемое прямоугольное поле; 0 — пустая клетка
   * @return число удалённых строк
   */
  public static int removeFullRows(int[][] b) {
    // TODO lunar-tetris.removeFullRows: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("lunar-tetris.removeFullRows", () -> 0);
  }
}
