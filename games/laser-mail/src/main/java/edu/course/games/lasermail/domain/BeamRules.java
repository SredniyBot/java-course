package edu.course.games.lasermail.domain;

/** Лазерная почта: операции над игровыми данными без интерфейса. */
public final class BeamRules {
  private BeamRules() {}

  /**
   * Отражает направление луча от зеркала. В пустой клетке направление сохраняется.
   *
   * <p>direction ∈ {0,1,2,3}; mirror любой char.
   *
   * @param direction направление: 0 вправо, 1 вниз, 2 влево, 3 вверх
   * @param mirror зеркало / или \; другое значение означает пустую клетку
   * @return направление после отражения
   */
  public static int reflectDirection(int direction, char mirror) {
    if (mirror == '/') return 3 - direction;
    if (mirror == '\\') return direction ^ 1;
    return direction;
  }

  /**
   * Проверяет принадлежность координат прямоугольному полю с индексами от нуля.
   *
   * <p>h,w ≥0; r,c любые int.
   *
   * @param r проверяемая строка
   * @param c проверяемый столбец
   * @param h число строк
   * @param w число столбцов
   * @return true для координат внутри поля
   */
  public static boolean isInsideGrid(int r, int c, int h, int w) {
    return r >= 0 && r < h && c >= 0 && c < w;
  }

  /**
   * Рассчитывает маршрут луча до приёмника, выхода за поле или петли. В маршрут включаются
   * начальная клетка и достигнутый приёмник. Приёмник проверяется до отражения от зеркала.
   *
   * <p>Петля — повтор тройки (строка, столбец, входящее направление). Повторное состояние в маршрут
   * не добавляется. Возвращает независимый неизменяемый маршрут; поле не меняется.
   *
   * @param mirrors поле зеркал
   * @param row строка старта
   * @param col столбец старта
   * @param direction входящее направление на старте: 0..3
   * @param targetRow строка приёмника
   * @param targetCol столбец приёмника
   * @return неизменяемый маршрут и причина остановки
   * @throws NullPointerException если mirrors равен null
   * @throws IllegalArgumentException если нарушена форма поля, алфавит клеток, координаты
   *     начала/цели или направление
   */
  public static BeamTrace trace(
      char[][] mirrors, int row, int col, int direction, int targetRow, int targetCol) {
    // TODO laser-mail.trace: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "laser-mail.trace", () -> new BeamTrace(java.util.List.of(), BeamTrace.End.EXITED));
  }
}
