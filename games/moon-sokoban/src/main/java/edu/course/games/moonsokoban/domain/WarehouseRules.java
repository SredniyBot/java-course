package edu.course.games.moonsokoban.domain;

/** Склад лунного сыра: операции над игровыми данными без интерфейса. */
public final class WarehouseRules {
  private WarehouseRules() {}

  /**
   * Перемещает ящик из (r,c) на одну клетку в заданном направлении, если клетка назначения
   * свободна. При преграде или выходе за поле возвращает false без изменения поля. При успехе
   * старая клетка становится пустой, новая содержит ящик.
   *
   * <p>b непустой прямоугольный; (r,c) внутри и содержит 2; |dr|+|dc|=1; строки разные.
   *
   * @param b изменяемое поле: 0 — пусто, 1 — стена, 2 — ящик
   * @param r строка ящика
   * @param c столбец ящика
   * @param dr изменение строки на один ход
   * @param dc изменение столбца на один ход
   * @return true при перемещении ящика; false при преграде или выходе за поле
   */
  public static boolean tryPushBox(int[][] b, int r, int c, int dr, int dc) {
    // TODO moon-sokoban.tryPushBox: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("moon-sokoban.tryPushBox", () -> false);
  }

  /**
   * Проверяет, стоит ли ящик на каждой целевой клетке. Ящики вне целей не мешают успеху. Поля не
   * изменяются.
   *
   * <p>b/goals одинакового прямоугольного размера; строки не null.
   *
   * @param b поле ящиков
   * @param goals признаки целевых клеток той же формы
   * @return true, если на каждой цели стоит ящик
   */
  public static boolean allGoalsOccupied(int[][] b, boolean[][] goals) {
    for (int r = 0; r < b.length; r++)
      for (int c = 0; c < b[r].length; c++) if (goals[r][c] && b[r][c] != 2) return false;
    return true;
  }
}
