package edu.course.games.brickgarden.domain;

/** Кирпичный сад. Правила игры. Контракты упражнений: README.md. */
public final class BrickRules {
  private BrickRules() {}

  /**
   * <b>WHAT / contract:</b> Кирпичи начинаются с x=80, шаг 100, ширина 94, всего 8. Вернуть индекс
   * или -1, включая промежутки.
   *
   * <p><b>Constraints:</b> x конечен, abs ≤ 10^6. Кирпич c занимает [80+100*c,174+100*c), c=0..7.
   *
   * <p><b>Examples:</b> columnAt(80) → 0; columnAt(173.9) → 0; columnAt(174) → -1; columnAt(180) →
   * 1; columnAt(874) → -1.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Промежуток — не кирпич; приведение отрицательного double к int не
   * заменяет floor.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int columnAt(double x) {
    // TODO brick-garden.columnAt: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("brick-garden.columnAt");
  }

  /**
   * <b>WHAT / contract:</b> Посчитать элементы &gt;0; массив прямоугольный, не null.
   *
   * <p><b>Constraints:</b> Ненулевой объект массива, строки не null; прямоугольный, в том числе 0
   * строк или 0 столбцов.
   *
   * <p><b>Examples:</b> countRemaining([[1,0],[-1,2]]) → 2; countRemaining([]) → 0.
   *
   * <p><b>Acceptance criteria:</b> O(h*w); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Ненулевое отрицательное значение не считается кирпичом; вход не
   * изменять.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int countRemaining(int[][] board) {
    // TODO brick-garden.countRemaining: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("brick-garden.countRemaining");
  }
}
