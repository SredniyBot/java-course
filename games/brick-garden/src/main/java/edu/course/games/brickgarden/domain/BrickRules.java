package edu.course.games.brickgarden.domain;

/** Кирпичный сад: операции над игровыми данными без интерфейса. */
public final class BrickRules {
  private BrickRules() {}

  /**
   * Находит кирпич под координатой удара. Восемь кирпичей начинаются с x=80, идут с шагом 100 и
   * имеют ширину 94. Левая граница поверхности включена, правая исключена.
   *
   * <p>x конечен, abs ≤ 10^6. Кирпич c занимает [80+100*c,174+100*c), c=0..7.
   *
   * @param x x точки удара
   * @return индекс кирпича 0..7 или -1 при попадании в щель либо за пределы стены
   */
  public static int columnAt(double x) {
    // TODO brick-garden.columnAt: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("brick-garden.columnAt", () -> -1);
  }

  /**
   * Считает клетки с положительной прочностью. Нулевые и отрицательные значения не считаются
   * кирпичами. Поле не изменяется.
   *
   * <p>Ненулевой объект массива, строки не null; прямоугольный, в том числе 0 строк или 0 столбцов.
   *
   * @param board поле кирпичей; положительное значение означает целый кирпич
   * @return число положительных клеток
   */
  public static int countRemaining(int[][] board) {
    int n = 0;
    for (int[] row : board) for (int v : row) if (v > 0) n++;
    return n;
  }
}
