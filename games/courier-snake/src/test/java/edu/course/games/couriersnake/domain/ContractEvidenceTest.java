package edu.course.games.couriersnake.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void threeTurnsPreservePairsAndInactiveCapacity() {
    int[] xs = {3, 2, 1, 99, 98}, ys = {1, 1, 1, 88, 87};
    SnakeRules.advanceBody(xs, ys, 3, 3, 2);
    SnakeRules.advanceBody(xs, ys, 3, 2, 2);
    SnakeRules.advanceBody(xs, ys, 3, 2, 3);
    assertArrayEquals(new int[] {2, 2, 3, 99, 98}, xs);
    assertArrayEquals(new int[] {3, 2, 2, 88, 87}, ys);
    assertFalse(SnakeRules.occupiesCell(xs, ys, 3, 99, 88));
  }
}
