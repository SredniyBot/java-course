package edu.course.games.cloudjumper.domain;

/** Облачный прыгун: операции над игровыми данными без интерфейса. */
public final class PlatformRules {
  private PlatformRules() {}

  /**
   * Проверяет пересечение верхней грани платформы за один шаг вниз. Требуются vy &gt; 0, oldBottom
   * ≤ platformY ≤ newBottom и x в [platformX, platformX + 140]. Касание любого края считается
   * пересечением.
   *
   * <p>Конечные координаты/скорости abs ≤ 10^6; oldBottom и newBottom — низ персонажа, y растёт
   * вниз.
   *
   * @param oldBottom нижняя граница персонажа до шага
   * @param newBottom нижняя граница персонажа после шага
   * @param vy вертикальная скорость; вниз — положительная
   * @param x x персонажа
   * @param platformX левый край платформы шириной 140
   * @param platformY высота верхней грани платформы
   * @return true, если персонаж пересёк верхнюю грань при движении вниз
   */
  public static boolean crossesPlatform(
      double oldBottom, double newBottom, double vy, double x, int platformX, double platformY) {
    // TODO cloud-jumper.crossesPlatform: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "cloud-jumper.crossesPlatform", () -> false);
  }

  /**
   * Переносит координату через край экрана не более одного раза. Левая граница включена, правая
   * исключена.
   *
   * <p>width ∈ (0,10^6]; x ∈ [-width,2*width). Разрешён выход не более одной ширины.
   *
   * @param x координата до переноса
   * @param width положительная ширина экрана
   * @return координата после переноса через край экрана
   */
  public static double wrapHorizontal(double x, double width) {
    if (x < 0) return x + width;
    if (x >= width) return x - width;
    return x;
  }
}
