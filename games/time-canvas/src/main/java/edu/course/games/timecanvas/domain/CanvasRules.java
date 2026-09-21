package edu.course.games.timecanvas.domain;

/** Холст времени: операции над игровыми данными без интерфейса. */
public final class CanvasRules {
  private CanvasRules() {}

  /**
   * Создаёт глубокую копию пикселей. Копирует каждую строку отдельно, даже если две исходные строки
   * ссылаются на один массив. Допускает пустой массив, пустые строки и строки разной длины.
   *
   * <p>При null-строке отклоняет весь снимок. Ни успешный вызов, ни отказ не изменяют исходные
   * данные.
   *
   * @param a исходные строки пикселей; допустимы пустые и разной длины
   * @return независимая глубокая копия массива и каждой его строки
   * @throws NullPointerException если массив или любая его строка равен null
   */
  public static int[][] copyPixels(int[][] a) {
    // TODO time-canvas.copyPixels: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "time-canvas.copyPixels", () -> new int[a.length][a[0].length]);
  }

  /**
   * Считает позиции, в которых значения двух изображений различаются. Оба изображения остаются
   * неизменными.
   *
   * <p>a,b и строки не null; одинаковое число строк и попарные длины строк.
   *
   * @param a первое изображение
   * @param b второе изображение той же формы
   * @return число клеток с разными значениями
   */
  public static int countDifferences(int[][] a, int[][] b) {
    int n = 0;
    for (int r = 0; r < a.length; r++)
      for (int c = 0; c < a[r].length; c++) if (a[r][c] != b[r][c]) n++;
    return n;
  }

  /**
   * Проверяет наличие снимка непосредственно перед index. Для первого снимка возвращает false;
   * содержимое истории не меняется.
   *
   * <p>snapshots не null; 0≤index&lt;snapshots.length; элементы snapshots могут быть null.
   *
   * @param index индекс текущего снимка
   * @param snapshots массив снимков; неиспользованные элементы равны null
   * @return true, если существует предыдущий снимок
   */
  public static boolean hasPreviousSnapshot(int index, int[][][] snapshots) {
    return index > 0 && snapshots[index - 1] != null;
  }
}
