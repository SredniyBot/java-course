package edu.course.games.portalpong.domain;

/** Пинг-понг с порталом. Правила игры. Контракты упражнений: README.md. */
public final class PaddlePhysics {
  private PaddlePhysics() {}

  /**
   * <b>WHAT / contract:</b> Мяч попадает, если его центр находится в [top-10,top+120].
   *
   * <p><b>Constraints:</b> ballY и top конечны, abs ≤ 10^6.
   *
   * <p><b>Examples:</b> intersectsPaddle(90,100) → true; intersectsPaddle(220,100) → true; 89 и 221
   * → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Ширина интервала включает радиус мяча; top+110 — не верхняя граница
   * контракта.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean intersectsPaddle(double ballY, double top) {
    // TODO portal-pong.intersectsPaddle: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("portal-pong.intersectsPaddle");
  }

  /**
   * <b>WHAT / contract:</b> Вернуть (ballY-(top+55)) 5: угол отскока зависит от места попадания.
   *
   * <p><b>Constraints:</b> ballY и top конечны, abs ≤ 10^6.
   *
   * <p><b>Examples:</b> reflectedVerticalSpeed(155,100) → 0; reflectedVerticalSpeed(145,100) → -50;
   * reflectedVerticalSpeed(165,100) → 50.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Вычитать надо центр ракетки top+55; знак определяет движение
   * вверх/вниз.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static double reflectedVerticalSpeed(double ballY, double top) {
    // TODO portal-pong.reflectedVerticalSpeed: реализуйте WHAT/contract из Javadoc выше.
    // Сначала вычислите examples вручную, затем реализуйте формулу/условия контракта.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("portal-pong.reflectedVerticalSpeed");
  }
}
