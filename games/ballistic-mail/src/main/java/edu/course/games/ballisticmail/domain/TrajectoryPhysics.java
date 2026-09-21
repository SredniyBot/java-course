package edu.course.games.ballisticmail.domain;

/** Баллистическая почта: операции над игровыми данными без интерфейса. */
public final class TrajectoryPhysics {
  private TrajectoryPhysics() {}

  /**
   * Разлагает скорость броска на горизонтальную и вертикальную компоненты. Угол задан в градусах;
   * положительный угол направляет бросок вверх, поэтому вертикальная компонента отрицательна.
   *
   * <p>angle конечен abs≤36000 градусов; speed конечен ∈[0,10^6].
   *
   * @param angle угол броска в градусах
   * @param speed начальный модуль скорости
   * @return компоненты скорости в экранных координатах
   */
  public static Velocity initialVelocity(double angle, double speed) {
    double rad = Math.toRadians(angle);
    return new Velocity(Math.cos(rad) * speed, -Math.sin(rad) * speed);
  }

  /**
   * Проверяет попадание x в интервал [target − halfWidth, target + halfWidth]. Обе границы
   * включены.
   *
   * <p>Конечные x,target abs≤10^6; halfWidth ∈[0,10^6].
   *
   * @param x x точки приземления
   * @param target x центра приёмника
   * @param halfWidth половина ширины приёмника
   * @return true при попадании в замкнутый интервал приёмника
   */
  public static boolean isWithinTarget(double x, double target, double halfWidth) {
    return Math.abs(x - target) <= halfWidth;
  }

  /**
   * Выполняет один шаг полёта с ускорением 160 единиц/с² вниз. Сначала вычисляет vyNext = vy + 160
   * × dt, затем xNext = x + vx × dt и yNext = y + vyNext × dt. Горизонтальная скорость сохраняется.
   *
   * <p>Возвращает новое значение состояния. Исходное состояние неизменно, в том числе при отказе.
   * При dt=0 результат равен исходному значению.
   *
   * @param state состояние перед шагом
   * @param dt длительность шага в секундах, от 0 до 1
   * @return состояние после одного шага
   * @throws NullPointerException если state равен null
   * @throws IllegalArgumentException если dt не конечен, вне [0,1] или результат содержит
   *     бесконечность
   */
  public static FlightState advance(FlightState state, double dt) {
    // TODO ballistic-mail.advance: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("ballistic-mail.advance", () -> state);
  }
}
