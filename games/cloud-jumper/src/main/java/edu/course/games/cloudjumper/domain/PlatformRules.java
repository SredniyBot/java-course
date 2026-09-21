package edu.course.games.cloudjumper.domain;

/** Облачный прыгун. Правила игры. Контракты упражнений: README.md. */
public final class PlatformRules {
  private PlatformRules() {}

  /**
   * <b>WHAT / contract:</b> Посадка при движении вниз (vy&gt;0), пересечении высоты платформы снизу
   * экрана: oldBottom&lt;=platformY&lt;=newBottom; центр x в [platformX,platformX+140].
   *
   * <p><b>Constraints:</b> Конечные координаты/скорости abs ≤ 10^6; oldBottom и newBottom — низ
   * персонажа, y растёт вниз.
   *
   * <p><b>Examples:</b> crossesPlatform(90,110,20,150,100,100) → true; при vy=0 или -20 → false;
   * x=240 допустим, x=241 нет.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Недостаточно проверить новую высоту: персонаж мог быть ниже
   * платформы до шага.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean crossesPlatform(
      double oldBottom, double newBottom, double vy, double x, int platformX, double platformY) {
    // TODO cloud-jumper.crossesPlatform: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Платформа между кадрами»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "cloud-jumper.crossesPlatform", () -> false);
  }

  /**
   * <b>WHAT / contract:</b> Если x&lt;0, прибавить width; если x&gt;=width, вычесть width. За шаг
   * выход не больше width.
   *
   * <p><b>Constraints:</b> width ∈ (0,10^6]; x ∈ [-width,2*width). Разрешён выход не более одной
   * ширины.
   *
   * <p><b>Examples:</b> wrapHorizontal(-1,960) → 959; wrapHorizontal(960,960) → 0;
   * wrapHorizontal(0,960) → 0; wrapHorizontal(-960,960) → 0.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Правая граница исключена; % для отрицательных double не даёт
   * требуемый перенос.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static double wrapHorizontal(double x, double width) {
    // TODO cloud-jumper.wrapHorizontal: реализуйте WHAT/contract из Javadoc выше.
    // Исследование «Платформа между кадрами»: сценарий и обязательная новая часть — README.md.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "cloud-jumper.wrapHorizontal", () -> width / 2);
  }
}
