package edu.course.games.spacekitchen.domain;

/** Космическая кухня. Правила игры. Контракты упражнений: README.md. */
public final class RecipeRules {
  private RecipeRules() {}

  /**
   * <b>WHAT / contract:</b> Разделить непустую строку по запятым с сохранением пустых полей; каждый
   * фрагмент strip + lowercase ROOT. Пустая или blank строка даёт массив длины 0.
   *
   * <p><b>Constraints:</b> line не null; пустые поля сохраняются только для неblank строки.
   *
   * <p><b>Examples:</b> parseIngredients(" A,,B, ") → ["a","","b",""]; parseIngredients(" ") → [].
   *
   * <p><b>Acceptance criteria:</b> O(n); точные границы и отсутствие лишней мутации. Добавьте свой
   * случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> split без отрицательного limit удаляет хвостовые пустые поля;
   * Locale.ROOT обязателен.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static String[] parseIngredients(String line) {
    // TODO space-kitchen.parseIngredients: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "space-kitchen.parseIngredients", () -> new String[] {line});
  }

  /**
   * <b>WHAT / contract:</b> Проверить одинаковый набор с учётом повторов, порядок не важен.
   * Исходные массивы не менять. Можно сортировать копии.
   *
   * <p><b>Constraints:</b> a,b и их строки не null; сравнение точное и регистрозависимое.
   *
   * <p><b>Examples:</b> hasSameIngredients(["a","b","a"],["b","a","a"]) → true; ["a","a"] против
   * ["a"] → false.
   *
   * <p><b>Acceptance criteria:</b> O(n log n+m log m), O(n+m) памяти; точные границы и отсутствие
   * лишней мутации. Добавьте свой случай из допустимого домена.
   *
   * <p><b>Typical pitfalls:</b> Set теряет повторы; сортировать входные массивы запрещено.
   *
   * <p>Входы вне constraints не специфицированы. См. README.md.
   */
  public static boolean hasSameIngredients(String[] a, String[] b) {
    // TODO space-kitchen.hasSameIngredients: реализуйте WHAT/contract из Javadoc выше.
    // Спроектируйте внутренний API в DESIGN.md; этот метод — адаптер для готового UI.
    // Acceptance: примеры, границы, допустимая мутация и сложность — README.md.
    return edu.course.learning.ExercisePreview.unfinished(
        "space-kitchen.hasSameIngredients", () -> false);
  }
}
