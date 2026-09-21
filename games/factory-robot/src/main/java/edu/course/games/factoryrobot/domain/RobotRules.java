package edu.course.games.factoryrobot.domain;

/** Робот на заводе: операции над игровыми данными без интерфейса. */
public final class RobotRules {
  private RobotRules() {}

  /**
   * Применяет поворот R по часовой стрелке или L против неё. Команда F сохраняет направление.
   *
   * <p>direction 0..3; command F,L,R.
   *
   * @param direction текущее направление: 0..3
   * @param command команда F, L или R
   * @return новое направление: 0..3
   */
  public static int nextDirection(int direction, char command) {
    if (command == 'R') return (direction + 1) % 4;
    if (command == 'L') return (direction + 3) % 4;
    return direction;
  }

  /**
   * Находит клетку после одного шага вперёд. Если впереди препятствие или край карты, возвращает
   * прежние координаты. Карта не изменяется.
   *
   * <p>map непустая прямоугольная; row,col внутри; direction 0..3; 0=проход, любое другое
   * значение=преграда.
   *
   * @param map карта: 0 — проход, другое значение — препятствие
   * @param row текущая строка
   * @param col текущий столбец
   * @param direction направление: 0 вправо, 1 вниз, 2 влево, 3 вверх
   * @return следующая клетка или прежняя при препятствии
   */
  public static Cell nextCell(int[][] map, int row, int col, int direction) {
    int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    int r = row + dr[direction], c = col + dc[direction];
    if (r < 0 || r >= map.length || c < 0 || c >= map[r].length || map[r][c] != 0)
      return new Cell(row, col);
    return new Cell(r, c);
  }

  /**
   * Проверяет, что программа непуста и состоит только из F, L, R. Ничего не нормализует; пробелы и
   * строчные буквы недопустимы.
   *
   * <p>program не null; регистр уже может быть нормализован UI, но метод сам ничего не нормализует.
   *
   * @param program программа без предварительной нормализации
   * @return true для непустой последовательности команд F, L, R
   */
  public static boolean isValidProgram(String program) {
    if (program.isEmpty()) return false;
    for (int i = 0; i < program.length(); i++)
      if ("FLR".indexOf(program.charAt(i)) < 0) return false;
    return true;
  }

  /**
   * Читает от 1 до 60 команд F, L, R без пробелов и переводов строк. Останавливается на EOF или
   * первом нарушении. Возвращает программу только после успешного закрытия источника.
   *
   * <p>Принимает владение source: закрывает его ровно один раз при успехе и отказе. IOException
   * чтения или закрытия оборачивается в ProgramLoadException с сохранением исходного объекта в
   * cause.
   *
   * <p>При ошибках read и close ошибка закрытия остаётся в suppressed исходной IOException. При
   * ошибках формата и close основной остаётся ProgramFormatException, а ошибка закрытия — в его
   * suppressed.
   *
   * @param source источник команд; владение и обязанность закрытия передаются методу
   * @return программа после успешного чтения и закрытия источника
   * @throws NullPointerException если source равен null
   * @throws ProgramFormatException если программа пуста, содержит недопустимый символ или длиннее
   *     60 команд
   * @throws ProgramLoadException если чтение или закрытие завершилось IOException; исходное
   *     исключение сохранено в cause
   */
  public static String readProgram(java.io.Reader source) throws ProgramLoadException {
    // TODO factory-robot.readProgram: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished("factory-robot.readProgram", () -> "");
  }
}
