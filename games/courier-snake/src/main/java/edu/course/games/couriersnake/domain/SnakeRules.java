package edu.course.games.couriersnake.domain;

/** Змейка-курьер. Правила игры. Контракты упражнений: README.md. */
public final class SnakeRules {
  private SnakeRules() {}

  /**
   * <b>WHAT / contract:</b> Сдвинуть первые length элементов вправо и записать новую голову в [0].
   * Сдвиг справа налево; length&gt;=1.
   *
   * <p><b>Constraints:</b> xs, ys не null и не один объект; 1 ≤ length ≤ min(xs.length,ys.length);
   * любые int координаты.
   *
   * <p><b>Examples:</b> xs=[3,2,1,99], ys=[4,4,4,88], length=3, новая голова=(4,4) → xs=[4,3,2,99],
   * ys без изменений.
   *
   * <p><b>Acceptance criteria:</b> O(length), O(1) доп. памяти; точные границы и отсутствие лишней
   * мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Сдвиг слева направо затирает тело. Хвост массивов с index≥length не
   * менять.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static void advanceBody(int[] xs, int[] ys, int length, int nx, int ny) {
    // TODO courier-snake.advanceBody: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("courier-snake.advanceBody");
  }

  /**
   * <b>WHAT / contract:</b> Есть ли координата (x,y) среди первых length элементов. length может
   * быть 0.
   *
   * <p><b>Constraints:</b> xs, ys не null; 0 ≤ length ≤ min длин.
   *
   * <p><b>Examples:</b> occupiesCell([2,8],[3,9],1,8,9) → false; length=2 → true; length=0 → false.
   *
   * <p><b>Acceptance criteria:</b> O(length); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Обе координаты должны совпасть в одной позиции, не в разных
   * сегментах.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean occupiesCell(int[] xs, int[] ys, int length, int x, int y) {
    // TODO courier-snake.occupiesCell: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("courier-snake.occupiesCell");
  }
}
