package edu.course.testing;

/** Fresh fixtures on every call; callers cannot contaminate later tests. */
public final class Boards {
  private Boards() {}

  public static int[][] numberedRectangle() {
    return new int[][] {{1, 2, 3}, {4, 5, 6}};
  }

  public static int[][] copy(int[][] source) {
    int[][] result = new int[source.length][];
    for (int i = 0; i < source.length; i++) result[i] = source[i].clone();
    return result;
  }
}
