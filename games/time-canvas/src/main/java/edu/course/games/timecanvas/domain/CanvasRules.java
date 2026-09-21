package edu.course.games.timecanvas.domain;

/** Холст времени. Правила игры. Контракты упражнений: README.md. */
public final class CanvasRules {
  private CanvasRules() {}

  /**
   * <b>WHAT / contract:</b> Вернуть независимую копию прямоугольной матрицы int, включая копии всех
   * строк.
   *
   * <p><b>Constraints:</b> a и строки не null; пустые и неодинаковые по длине строки допустимы.
   *
   * <p><b>Examples:</b> copyPixels([[1],[2,3]]) → равные значения; изменение copyPixels[0][0] не
   * меняет a[0][0].
   *
   * <p><b>Acceptance criteria:</b> O(числа элементов) времени/памяти; точные границы и отсутствие
   * лишней мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Копирование внешнего массива не копирует строки; даже строки длины
   * 0 должны быть отдельными.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int[][] copyPixels(int[][] a) {
    // TODO time-canvas.copyPixels: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("time-canvas.copyPixels");
  }

  /**
   * <b>WHAT / contract:</b> Посчитать позиции с разными значениями. Размеры совпадают.
   *
   * <p><b>Constraints:</b> a,b и строки не null; одинаковое число строк и попарные длины строк.
   *
   * <p><b>Examples:</b> countDifferences([[1,2]],[[1,3]]) → 1; равные матрицы → 0.
   *
   * <p><b>Acceptance criteria:</b> O(числа элементов); точные границы и отсутствие лишней мутации.
   * Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Сравнивать значения клеток, не ссылки; обе матрицы сохранить.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static int countDifferences(int[][] a, int[][] b) {
    // TODO time-canvas.countDifferences: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("time-canvas.countDifferences");
  }

  /**
   * <b>WHAT / contract:</b> Вернуть true, если index&gt;0 и предыдущий снимок не null. В новом
   * массиве ссылок неиспользованные элементы равны null. Индекс внутри snapshots.
   *
   * <p><b>Constraints:</b> snapshots не null; 0≤index&lt;snapshots.length; элементы snapshots могут
   * быть null.
   *
   * <p><b>Examples:</b> hasPreviousSnapshot(0,[null]) → false; hasPreviousSnapshot(1,[[[1]],null])
   * → true; hasPreviousSnapshot(1,[null,null]) → false.
   *
   * <p><b>Acceptance criteria:</b> O(1); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Не читать index-1 до проверки index&gt;0; текущее значение
   * snapshots[index] не определяет возможность undo.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean hasPreviousSnapshot(int index, int[][][] snapshots) {
    // TODO time-canvas.hasPreviousSnapshot: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    throw new UnsupportedOperationException("time-canvas.hasPreviousSnapshot");
  }
}
