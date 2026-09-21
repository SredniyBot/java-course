package edu.course.games.starcourier.domain;

/** Звёздный курьер: операции над игровыми данными без интерфейса. */
public final class CourierRules {
  private CourierRules() {}

  /**
   * Ограничивает координату замкнутым интервалом. Значение внутри интервала возвращается без
   * изменения.
   *
   * <p>Все числа конечны, abs ≤ 10^6; min ≤ max.
   *
   * @param value исходная координата
   * @param min нижняя граница включительно
   * @param max верхняя граница включительно
   * @return координата в заданном замкнутом интервале
   */
  public static double clampCoordinate(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }

  /**
   * Проверяет, попадает ли центр груза в круг подбора вокруг курьера. Точка на окружности считается
   * попаданием; нулевой радиус допускает только совпадающие центры.
   *
   * <p>Конечные координаты с abs ≤ 10^6; radius от 0 до 10^6.
   *
   * @param x x центра курьера
   * @param y y центра курьера
   * @param tx x центра груза
   * @param ty y центра груза
   * @param radius радиус подбора, неотрицательный
   * @return true, если расстояние до груза не превышает радиус
   */
  public static boolean isWithinRadius(double x, double y, double tx, double ty, double radius) {
    // TODO star-courier.isWithinRadius: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "star-courier.isWithinRadius", () -> false);
  }
}
