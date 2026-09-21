package edu.course.games.couriersnake.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void rejectsBeforeEitherCoordinateArrayChanges() {
    int[] xs = {4, 3, 2}, ys = {8, 8};
    assertThrows(IllegalArgumentException.class, () -> SnakeRules.advanceBody(xs, ys, 3, 9, 9));
    assertArrayEquals(new int[] {4, 3, 2}, xs);
    assertArrayEquals(new int[] {8, 8}, ys);
    assertThrows(IllegalArgumentException.class, () -> SnakeRules.advanceBody(xs, xs, 2, 9, 9));
    assertArrayEquals(new int[] {4, 3, 2}, xs);
    for (int length : new int[] {-1, 0, 4}) {
      assertThrows(
          IllegalArgumentException.class, () -> SnakeRules.advanceBody(xs, ys, length, 9, 9));
      assertArrayEquals(new int[] {4, 3, 2}, xs);
      assertArrayEquals(new int[] {8, 8}, ys);
    }
    assertThrows(NullPointerException.class, () -> SnakeRules.advanceBody(xs, null, 1, 9, 9));
    assertArrayEquals(new int[] {4, 3, 2}, xs);
    assertThrows(NullPointerException.class, () -> SnakeRules.advanceBody(null, ys, 1, 9, 9));
  }

  @Test
  void movesBothCoordinatesAndPreservesInactiveTail() {
    int[] xs = {3, 2, 1, 99}, ys = {4, 5, 6, 88};
    SnakeRules.advanceBody(xs, ys, 3, 7, 8);
    assertArrayEquals(new int[] {7, 3, 2, 99}, xs);
    assertArrayEquals(new int[] {8, 4, 5, 88}, ys);
  }
}
