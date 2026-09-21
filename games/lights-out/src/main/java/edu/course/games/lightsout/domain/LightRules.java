package edu.course.games.lightsout.domain;

/** Ночной город. Правила игры. Контракты упражнений: README.md. */
public final class LightRules {
  private LightRules() {}

  /**
   * <b>WHAT / contract:</b> Инвертировать выбранную клетку и соседей по стороне внутри матрицы. Не
   * трогать диагонали.
   *
   * <p><b>Constraints:</b> Непустая прямоугольная матрица; row,col внутри; строки разные.
   *
   * <p><b>Examples:</b> toggleCross на пустом по значениям поле 2×2 в (0,0) →
   * [[true,true],[true,false]]. Повторный вызов возвращает исходное поле.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Диагональ не переключать; центральную клетку переключить ровно один
   * раз.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static void toggleCross(boolean[][] a, int row, int col) {
    // TODO lights-out.toggleCross: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("lights-out.toggleCross");
  }

  /**
   * <b>WHAT / contract:</b> True, если нет ни одного true.
   *
   * <p><b>Constraints:</b> a и строки не null; пустая матрица допустима.
   *
   * <p><b>Examples:</b> allLightsOff([[false,false]]) → true; allLightsOff([[false,true]]) → false;
   * allLightsOff([]) → true.
   *
   * <p><b>Acceptance criteria:</b> O(h*w); точные границы и отсутствие лишней мутации. Добавьте
   * свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Проверка не меняет лампы; один true достаточен для false.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean allLightsOff(boolean[][] a) {
    // TODO lights-out.allLightsOff: реализуйте WHAT/contract из Javadoc выше.
    // Выберите алгоритм и запишите инвариант; соблюдайте constraints и владение массивами.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("lights-out.allLightsOff");
  }
}
