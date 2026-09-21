package edu.course.games.starcourier.domain;

/** Звёздный курьер. Правила игры. Контракты упражнений: README.md. */
public final class CourierRules {
  private CourierRules() {}

  /**
   * <b>WHAT / contract:</b> Вернуть value в замкнутом диапазоне [min,max]. min &lt;= max.
   *
   * <p><b>Constraints:</b> Все числа конечны, abs ≤ 10^6; min ≤ max.
   *
   * <p><b>Examples:</b> clampCoordinate(-2,0,9) → 0; clampCoordinate(4,0,9) → 4;
   * clampCoordinate(15,0,9) → 9; clampCoordinate(2,3,3) → 3.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Нельзя возвращать min для любого значения; равные границы
   * допустимы.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static double clampCoordinate(double value, double min, double max) {
    // TODO star-courier.clampCoordinate: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Груз у кромки экрана»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "star-courier.clampCoordinate", () -> (min + max) / 2);
  }

  /**
   * <b>WHAT / contract:</b> Центры касаются, если квадрат расстояния &lt;= radius². Считать касание
   * границы попаданием.
   *
   * <p><b>Constraints:</b> Конечные координаты с abs ≤ 10^6; radius от 0 до 10^6.
   *
   * <p><b>Examples:</b> isWithinRadius(0,0,3,4,5) → true; radius=4 → false; совпавшие центры и
   * radius=0 → true.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Граница включена: &lt;=, не &lt;; сравнивайте величины в одинаковых
   * единицах.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isWithinRadius(double x, double y, double tx, double ty, double radius) {
    // TODO star-courier.isWithinRadius: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Груз у кромки экрана»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "star-courier.isWithinRadius", () -> false);
  }
}
