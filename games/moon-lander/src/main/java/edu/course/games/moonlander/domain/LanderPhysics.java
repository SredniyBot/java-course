package edu.course.games.moonlander.domain;

/** Лунная доставка: операции над игровыми данными без интерфейса. */
public final class LanderPhysics {
  private LanderPhysics() {}

  /**
   * Вычисляет скорость после шага с постоянным ускорением. Гравитация даёт 65 единиц/с² вниз,
   * включённый двигатель — 130 единиц/с² вверх. При нулевом dt скорость сохраняется.
   *
   * <p>current конечна, abs ≤ 10^6; dt ∈ [0,1], секунды; положительная скорость направлена вниз.
   *
   * @param current скорость до шага; положительная направлена вниз
   * @param engine включена ли тяга двигателя
   * @param dt длительность шага в секундах, от 0 до 1
   * @return вертикальная скорость после шага
   */
  public static double nextVerticalSpeed(double current, boolean engine, double dt) {
    // TODO moon-lander.nextVerticalSpeed: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "moon-lander.nextVerticalSpeed", () -> 0.0);
  }

  /**
   * Проверяет условия мягкой посадки: x находится в [385, 555], а модуль вертикальной скорости не
   * превышает 55. Все границы включены.
   *
   * <p>x и nextVerticalSpeed конечны, abs ≤ 10^6.
   *
   * @param x x центра корабля
   * @param nextVerticalSpeed вертикальная скорость в момент посадки
   * @return true для безопасной посадки
   */
  public static boolean isSafeLanding(double x, double nextVerticalSpeed) {
    return x >= 385 && x <= 555 && Math.abs(nextVerticalSpeed) <= 55;
  }
}
