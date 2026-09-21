package edu.course.games.couriersnake.domain;

/** Змейка-курьер: операции над игровыми данными без интерфейса. */
public final class SnakeRules {
  private SnakeRules() {}

  /**
   * Перемещает тело змейки на один ход. Новая голова записывается в индекс 0; каждый следующий
   * активный сегмент получает прежние координаты предыдущего. Неактивный хвост массивов
   * сохраняется.
   *
   * <p>При недопустимых аргументах бросает исключение до изменения любого из массивов. Ссылки на
   * массивы должны различаться.
   *
   * @param xs x сегментов, начиная с головы
   * @param ys y сегментов, начиная с головы
   * @param length число активных сегментов
   * @param nx x новой головы
   * @param ny y новой головы
   * @throws NullPointerException если xs или ys равен null
   * @throws IllegalArgumentException если массивы совпадают по ссылке или length вне диапазона
   *     1..min(xs.length, ys.length)
   */
  public static void advanceBody(int[] xs, int[] ys, int length, int nx, int ny) {
    // TODO courier-snake.advanceBody: реализуйте действие по контракту выше.
    edu.course.learning.ExercisePreview.unfinished("courier-snake.advanceBody", () -> null);
  }

  /**
   * Проверяет, занята ли клетка одним из первых length сегментов. Координаты x и y должны совпадать
   * у одного сегмента; неактивный хвост не учитывается.
   *
   * <p>xs, ys не null; 0 ≤ length ≤ min длин.
   *
   * @param xs x сегментов
   * @param ys y сегментов
   * @param length число активных сегментов
   * @param x x искомой клетки
   * @param y y искомой клетки
   * @return true, если клетка занята активным сегментом
   */
  public static boolean occupiesCell(int[] xs, int[] ys, int length, int x, int y) {
    for (int i = 0; i < length; i++) if (xs[i] == x && ys[i] == y) return true;
    return false;
  }
}
