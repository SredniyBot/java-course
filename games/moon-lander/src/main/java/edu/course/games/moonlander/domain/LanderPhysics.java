package edu.course.games.moonlander.domain;

/** Лунная доставка. Правила игры. Контракты упражнений: README.md. */
public final class LanderPhysics {
  private LanderPhysics() {}

  /**
   * <b>WHAT / contract:</b> Ускорение вниз 65, двигатель добавляет ускорение вверх 130. Вернуть
   * новую скорость.
   *
   * <p><b>Constraints:</b> current конечна, abs ≤ 10^6; dt ∈ [0,1], секунды; положительная скорость
   * направлена вниз.
   *
   * <p><b>Examples:</b> nextVerticalSpeed(10,false,0.2) → 23; nextVerticalSpeed(10,true,0.2) → -3;
   * dt=0 сохраняет current.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Двигатель меняет ускорение, а не устанавливает фиксированную
   * скорость.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static double nextVerticalSpeed(double current, boolean engine, double dt) {
    // TODO moon-lander.nextVerticalSpeed: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Посадка по приборам»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "moon-lander.nextVerticalSpeed", () -> 0.0);
  }

  /**
   * <b>WHAT / contract:</b> Успех: центр x в [385,555] и модуль скорости &lt;=55.
   *
   * <p><b>Constraints:</b> x и nextVerticalSpeed конечны, abs ≤ 10^6.
   *
   * <p><b>Examples:</b> isSafeLanding(385,55) → true; isSafeLanding(555,-55) → true;
   * isSafeLanding(384,0) → false; isSafeLanding(470,56) → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Проверяются обе границы площадки и модуль скорости, соединение
   * условий — AND.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isSafeLanding(double x, double nextVerticalSpeed) {
    // TODO moon-lander.isSafeLanding: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Посадка по приборам»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("moon-lander.isSafeLanding", () -> false);
  }
}
