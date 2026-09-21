package edu.course.games.cats256.domain;

/** Котики 256. Правила игры. Контракты упражнений: README.md. */
public final class TileRules {
  private TileRules() {}

  /**
   * <b>WHAT / contract:</b> Вернуть новый ряд: убрать нули, слить соседние равные числа один раз
   * слева направо, дополнить нулями. Оригинал не менять.
   *
   * <p><b>Constraints:</b> row не null; элементы 0 либо степени 2 ≤2^29; пустой ряд допустим.
   *
   * <p><b>Examples:</b> mergeLeft([2,2,2,2]) → [4,4,0,0]; mergeLeft([2,2,4,0]) → [4,4,0,0];
   * mergeLeft([2,0,2]) → [4,0,0].
   *
   * <p><b>Acceptance criteria:</b> O(n) времени/памяти; точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Полученный результат не сливается повторно в том же ходе; вход
   * должен остаться прежним.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int[] mergeLeft(int[] row) {
    // TODO cats-256.mergeLeft: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished("cats-256.mergeLeft", () -> row.clone());
  }

  /**
   * <b>WHAT / contract:</b> Новая квадратная матрица, повёрнутая по часовой стрелке.
   *
   * <p><b>Constraints:</b> Квадратная матрица, строки не null; допустима матрица 0×0.
   *
   * <p><b>Examples:</b> rotateClockwise([[1,2],[3,4]]) → [[3,1],[4,2]].
   *
   * <p><b>Acceptance criteria:</b> O(n²) времени/памяти; точные границы и отсутствие лишней
   * мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Это новый снимок; четыре поворота восстанавливают значения, но не
   * ссылки.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int[][] rotateClockwise(int[][] a) {
    // TODO cats-256.rotateClockwise: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "cats-256.rotateClockwise",
        () -> java.util.Arrays.stream(a).map(int[]::clone).toArray(int[][]::new));
  }
}
