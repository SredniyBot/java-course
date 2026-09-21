package edu.course.games.lightsout.domain;

/** Ночной город: операции над игровыми данными без интерфейса. */
public final class LightRules {
  private LightRules() {}

  /**
   * Инвертирует выбранную лампу и существующих соседей по стороне. Диагональные и прочие клетки
   * сохраняются. Изменяет поле на месте.
   *
   * <p>Непустая прямоугольная матрица; row,col внутри; строки разные.
   *
   * @param a изменяемое поле ламп
   * @param row строка центра переключения
   * @param col столбец центра переключения
   */
  public static void toggleCross(boolean[][] a, int row, int col) {
    // TODO lights-out.toggleCross: реализуйте действие по контракту выше.
    edu.course.learning.ExercisePreview.unfinished("lights-out.toggleCross", () -> null);
  }

  /**
   * Проверяет, выключены ли все лампы. Поле не изменяется.
   *
   * <p>a и строки не null; пустая матрица допустима.
   *
   * @param a поле ламп; true означает включённую лампу
   * @return true, если все лампы выключены
   */
  public static boolean allLightsOff(boolean[][] a) {
    for (boolean[] row : a) for (boolean v : row) if (v) return false;
    return true;
  }
}
