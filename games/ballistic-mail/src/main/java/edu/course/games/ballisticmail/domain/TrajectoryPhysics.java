package edu.course.games.ballisticmail.domain;

/** Баллистическая почта. Правила игры. Контракты упражнений: README.md. */
public final class TrajectoryPhysics {
  private TrajectoryPhysics() {}

  /**
   * <b>WHAT / contract:</b> Вернуть Velocity(x, y): vx=cos(toRadians(angle))*speed,
   * vy=-sin(toRadians(angle))*speed. Ось y экрана направлена вниз.
   *
   * <p><b>Constraints:</b> angle конечен abs≤36000 градусов; speed конечен ∈[0,10^6].
   *
   * <p><b>Examples:</b> initialVelocity(0,10) → Velocity(10,0); initialVelocity(90,10) →
   * Velocity(≈0,-10). Допуск проверок 1e-8.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> sin/cos принимают радианы; результат — value object, не массив с
   * магическими индексами.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static Velocity initialVelocity(double angle, double speed) {
    // TODO ballistic-mail.initialVelocity: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("ballistic-mail.initialVelocity");
  }

  /**
   * <b>WHAT / contract:</b> Попадание при |x-target|&lt;=halfWidth.
   *
   * <p><b>Constraints:</b> Конечные x,target abs≤10^6; halfWidth ∈[0,10^6].
   *
   * <p><b>Examples:</b> isWithinTarget(60,100,40) → true; isWithinTarget(140,100,40) → true;
   * isWithinTarget(141,100,40) → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Обе границы включены; направление экранной y здесь не участвует.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isWithinTarget(double x, double target, double halfWidth) {
    // TODO ballistic-mail.isWithinTarget: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("ballistic-mail.isWithinTarget");
  }
}
