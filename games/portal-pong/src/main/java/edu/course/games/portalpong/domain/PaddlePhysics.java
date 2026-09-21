package edu.course.games.portalpong.domain;

/** Пинг-понг с порталом: операции над игровыми данными без интерфейса. */
public final class PaddlePhysics {
  private PaddlePhysics() {}

  /**
   * Проверяет попадание центра мяча в вертикальный интервал [top − 10, top + 120]. Расширение
   * относительно высоты ракетки учитывает радиус мяча.
   *
   * <p>ballY и top конечны, abs ≤ 10^6.
   *
   * @param ballY y центра мяча
   * @param top y верхнего края ракетки
   * @return true при пересечении области ракетки
   */
  public static boolean intersectsPaddle(double ballY, double top) {
    return ballY >= top - 10 && ballY <= top + 120;
  }

  /**
   * Вычисляет вертикальную скорость отскока как 5 × (ballY − (top + 55)). Удар в центр ракетки даёт
   * ноль; удар ниже центра — положительную скорость.
   *
   * <p>ballY и top конечны, abs ≤ 10^6.
   *
   * @param ballY y центра мяча при ударе
   * @param top y верхнего края ракетки высотой 110
   * @return вертикальная скорость после отскока
   */
  public static double reflectedVerticalSpeed(double ballY, double top) {
    // TODO portal-pong.reflectedVerticalSpeed: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "portal-pong.reflectedVerticalSpeed", () -> 0.0);
  }
}
