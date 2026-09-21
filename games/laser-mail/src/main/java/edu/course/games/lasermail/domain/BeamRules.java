package edu.course.games.lasermail.domain;

/** Лазерная почта. Правила игры. Контракты упражнений: README.md. */
public final class BeamRules {
  private BeamRules() {}

  /**
   * <b>WHAT / contract:</b> Направления: 0 вправо,1 вниз,2 влево,3 вверх. Для /: 0→3,1→2,2→1,3→0;
   * для обратного слеша: 0→1,1→0,2→3,3→2. Иначе направление не менять.
   *
   * <p><b>Constraints:</b> direction ∈ {0,1,2,3}; mirror любой char.
   *
   * <p><b>Examples:</b> reflectDirection(0,'/') → 3; reflectDirection(3,'\\') → 2;
   * reflectDirection(2,'.') → 2.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Перепутать / и \ легко; два отражения одним зеркалом возвращают
   * направление.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int reflectDirection(int direction, char mirror) {
    // TODO laser-mail.reflectDirection: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("laser-mail.reflectDirection");
  }

  /**
   * <b>WHAT / contract:</b> Проверить обе координаты: 0&lt;=r&lt;h и 0&lt;=c&lt;w.
   *
   * <p><b>Constraints:</b> h,w ≥0; r,c любые int.
   *
   * <p><b>Examples:</b> isInsideGrid(0,0,1,1) → true; isInsideGrid(1,0,1,1) → false;
   * isInsideGrid(0,0,0,1) → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Правая/нижняя границы исключены; отрицательные координаты
   * недопустимы.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isInsideGrid(int r, int c, int h, int w) {
    // TODO laser-mail.isInsideGrid: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("laser-mail.isInsideGrid");
  }
}
