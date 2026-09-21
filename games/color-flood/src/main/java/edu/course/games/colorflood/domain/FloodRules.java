package edu.course.games.colorflood.domain;

/** Цветной прилив. Правила игры. Контракты упражнений: README.md. */
public final class FloodRules {
  private FloodRules() {}

  /**
   * <b>WHAT / contract:</b> Перекрасить компоненту клетки [0][0] по четырём сторонам. Использовать
   * очередь из двух int[] размером h w. Помечать клетку новым цветом ДО добавления. Если цвет не
   * меняется, сразу выйти.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная матрица width&gt;0; h*w ≤ 10^6; строки разные;
   * любой int цвет.
   *
   * <p><b>Examples:</b> fillFromOrigin([[1,2],[2,1]],9) → [[9,2],[2,1]]; color=1 ничего не меняет.
   *
   * <p><b>Acceptance criteria:</b> O(h*w) времени/памяти; точные границы и отсутствие лишней
   * мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Диагональ не связана. Отмечайте посещение до добавления в очередь;
   * тот же цвет — немедленный выход.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static void fillFromOrigin(int[][] a, int color) {
    // TODO color-flood.fillFromOrigin: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("color-flood.fillFromOrigin");
  }

  /**
   * <b>WHAT / contract:</b> Все значения равны a[0][0]. Матрица непустая.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная матрица width&gt;0.
   *
   * <p><b>Examples:</b> isUniform([[2,2],[2,2]]) → true; isUniform([[2,3]]) → false.
   *
   * <p><b>Acceptance criteria:</b> O(h*w); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Не требуются определённые цвета, только равенство; вход
   * сохраняется.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isUniform(int[][] a) {
    // TODO color-flood.isUniform: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("color-flood.isUniform");
  }
}
