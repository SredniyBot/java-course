package edu.course.games.pixelsymmetry.domain;

/** Мастерская симметрии: операции над игровыми данными без интерфейса. */
public final class SymmetryRules {
  private SymmetryRules() {}

  /**
   * Меняет цвет одной клетки. Координаты вне изображения игнорируются, остальные клетки
   * сохраняются.
   *
   * <p>image не null; строки не null, прямоугольность не обязательна; row,col любые int; color
   * любой int.
   *
   * @param image изменяемое изображение
   * @param row строка кисти
   * @param col столбец кисти
   * @param color значение нового цвета
   */
  public static void paintCell(int[][] image, int row, int col, int color) {
    if (row >= 0 && row < image.length && col >= 0 && col < image[row].length)
      image[row][col] = color;
  }

  /**
   * Копирует левую половину каждой строки в зеркальные позиции правой половины. Исходная левая
   * половина и средний столбец при нечётной ширине сохраняются. Изменяет существующие строки на
   * месте.
   *
   * <p>Строки не null и разные объекты; допустимы разная длина и пустые строки.
   *
   * @param image изображение, правая половина которого будет изменена
   */
  public static void mirrorLeftToRight(int[][] image) {
    // TODO pixel-symmetry.mirrorLeftToRight: реализуйте действие по контракту выше.
    edu.course.learning.ExercisePreview.unfinished("pixel-symmetry.mirrorLeftToRight", () -> null);
  }

  /**
   * Проверяет зеркальную симметрию каждой строки относительно её середины. Изображение не
   * изменяется.
   *
   * <p>image и строки не null, в том числе пустые и разной длины.
   *
   * @param image изображение для проверки
   * @return true, если строки зеркально симметричны
   */
  public static boolean isHorizontallySymmetric(int[][] image) {
    for (int[] row : image)
      for (int c = 0; c < row.length / 2; c++) if (row[c] != row[row.length - 1 - c]) return false;
    return true;
  }
}
