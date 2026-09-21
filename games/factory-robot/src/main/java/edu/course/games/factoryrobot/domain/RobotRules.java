package edu.course.games.factoryrobot.domain;

/** Робот на заводе. Правила игры. Контракты упражнений: README.md. */
public final class RobotRules {
  private RobotRules() {}

  /**
   * <b>WHAT / contract:</b> 0 вправо,1 вниз,2 влево,3 вверх. R поворачивает по часовой стрелке, L —
   * против. F сохраняет направление.
   *
   * <p><b>Constraints:</b> direction 0..3; command F,L,R.
   *
   * <p><b>Examples:</b> nextDirection(0,'L') → 3; nextDirection(3,'R') → 0; nextDirection(2,'F') →
   * 2.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Остаток отрицательного числа может быть -1; F не меняет
   * направление.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int nextDirection(int direction, char command) {
    // TODO factory-robot.nextDirection: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "factory-robot.nextDirection", () -> direction);
  }

  /**
   * <b>WHAT / contract:</b> Вернуть Cell(row, col) следующей клетки, если она внутри map и равна 0;
   * иначе Cell с прежними координатами. map не менять.
   *
   * <p><b>Constraints:</b> map непустая прямоугольная; row,col внутри; direction 0..3; 0=проход,
   * любое другое значение=преграда.
   *
   * <p><b>Examples:</b> nextCell([[0,0]],0,0,0) → Cell(0,1); nextCell([[0,1]],0,0,0) → Cell(0,0).
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> row и col не x/y; при запрете хода возвращаются прежние координаты;
   * map неизменна.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static Cell nextCell(int[][] map, int row, int col, int direction) {
    // TODO factory-robot.nextCell: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "factory-robot.nextCell", () -> new Cell(row, col));
  }

  /**
   * <b>WHAT / contract:</b> Непустая строка содержит только F,L,R. Регистр уже нормализован
   * интерфейсом.
   *
   * <p><b>Constraints:</b> program не null; регистр уже может быть нормализован UI, но метод сам
   * ничего не нормализует.
   *
   * <p><b>Examples:</b> isValidProgram("FFRFL") → true; isValidProgram("") → false;
   * isValidProgram("flr") → false; isValidProgram("F F") → false.
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Пустая программа невалидна; Character.isLetter пропускает лишние
   * команды.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean isValidProgram(String program) {
    // TODO factory-robot.isValidProgram: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "factory-robot.isValidProgram", () -> false);
  }
}
