package edu.course.games.moonsokoban.domain;

/** Склад лунного сыра. Правила игры. Контракты упражнений: README.md. */
public final class WarehouseRules {
  private WarehouseRules() {}

  /**
   * <b>WHAT / contract:</b> Клетка (r,c) содержит ящик 2. Если следующая по направлению клетка
   * внутри поля и равна 0, перенести ящик туда и вернуть true; иначе оставить поле и вернуть false.
   *
   * <p><b>Constraints:</b> b непустой прямоугольный; (r,c) внутри и содержит 2; |dr|+|dc|=1; строки
   * разные.
   *
   * <p><b>Examples:</b> tryPushBox([[2,0]],0,0,0,1) → true, поле [[0,2]]; для [[2,1]] → false и
   * поле неизменно.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> При заблокированном ходе нельзя сначала стереть исходный ящик;
   * диагонали не входят в контракт.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean tryPushBox(int[][] b, int r, int c, int dr, int dc) {
    // TODO moon-sokoban.tryPushBox: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("moon-sokoban.tryPushBox", () -> false);
  }

  /**
   * <b>WHAT / contract:</b> Каждая целевая клетка содержит ящик 2.
   *
   * <p><b>Constraints:</b> b/goals одинакового прямоугольного размера; строки не null.
   *
   * <p><b>Examples:</b> b=[[2,0]], goals=[[true,false]] → true; goals=[[false,true]] → false; без
   * целей → true.
   *
   * <p><b>Acceptance criteria:</b> O(h*w); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Вне целей могут быть лишние ящики; они не мешают выполнению этого
   * условия.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean allGoalsOccupied(int[][] b, boolean[][] goals) {
    // TODO moon-sokoban.allGoalsOccupied: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "moon-sokoban.allGoalsOccupied", () -> false);
  }
}
