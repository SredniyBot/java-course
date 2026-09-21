package edu.course.games.spacekitchen.domain;

/** Космическая кухня: операции над игровыми данными без интерфейса. */
public final class RecipeRules {
  private RecipeRules() {}

  /**
   * Разбивает заказ по запятым, удаляет краевые пробелы каждого поля и переводит поля в нижний
   * регистр с Locale.ROOT. Сохраняет порядок, повторения и пустые поля. Полностью пробельная строка
   * означает пустой заказ.
   *
   * <p>line не null; пустые поля сохраняются только для неblank строки.
   *
   * @param line ингредиенты, разделённые запятыми
   * @return нормализованные ингредиенты в исходном порядке
   */
  public static String[] parseIngredients(String line) {
    if (line.isBlank()) return new String[0];
    String[] a = line.split(",", -1);
    for (int i = 0; i < a.length; i++) a[i] = a[i].strip().toLowerCase(java.util.Locale.ROOT);
    return a;
  }

  /**
   * Сравнивает наборы ингредиентов без учёта порядка, но с учётом повторений. Строки сравниваются
   * точно, без нормализации. Входные массивы не изменяются.
   *
   * <p>a,b и их строки не null; сравнение точное и регистрозависимое.
   *
   * @param a первый набор ингредиентов
   * @param b второй набор ингредиентов
   * @return true, если совпадают значения и число повторений каждого ингредиента
   */
  public static boolean hasSameIngredients(String[] a, String[] b) {
    // TODO space-kitchen.hasSameIngredients: реализуйте действие по контракту выше.
    return edu.course.learning.ExercisePreview.unfinished(
        "space-kitchen.hasSameIngredients", () -> false);
  }
}
