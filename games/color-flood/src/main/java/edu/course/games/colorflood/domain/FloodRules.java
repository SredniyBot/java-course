package edu.course.games.colorflood.domain;

/** Цветной прилив: операции над игровыми данными без интерфейса. */
public final class FloodRules {
  private FloodRules() {}

  /**
   * Перекрашивает в color связную область исходного цвета, содержащую клетку (0,0). Связность
   * определяется только соседством по стороне. Другие области сохраняются; при совпадении цветов
   * поле не меняется.
   *
   * <p>Непустая прямоугольная матрица width&gt;0; h*w ≤ 10^6; строки разные; любой int цвет.
   *
   * @param a изменяемое прямоугольное поле цветов
   * @param color новый цвет связной области
   */
  public static void fillFromOrigin(int[][] a, int color) {
    // TODO color-flood.fillFromOrigin: реализуйте действие по контракту выше.
    edu.course.learning.ExercisePreview.unfinished("color-flood.fillFromOrigin", () -> null);
  }

  /**
   * Проверяет, имеют ли все клетки цвет клетки (0,0). Поле не изменяется.
   *
   * <p>Непустая прямоугольная матрица width&gt;0.
   *
   * @param a поле цветов
   * @return true, если все клетки одного цвета
   */
  public static boolean isUniform(int[][] a) {
    for (int[] row : a) for (int v : row) if (v != a[0][0]) return false;
    return true;
  }
}
