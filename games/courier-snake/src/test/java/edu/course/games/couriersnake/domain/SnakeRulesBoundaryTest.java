package edu.course.games.couriersnake.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SnakeRulesBoundaryTest {
  @Test
  void moveShiftsBackwardsAndPreservesUnusedCapacity() {
    int[] x = {3, 2, 1, 99}, y = {4, 4, 4, 88};
    SnakeRules.advanceBody(x, y, 3, 4, 5);
    assertArrayEquals(new int[] {4, 3, 2, 99}, x);
    assertArrayEquals(new int[] {5, 4, 4, 88}, y);
  }

  @Test
  void singleHeadAndEmptySearch() {
    int[] x = {1}, y = {2};
    SnakeRules.advanceBody(x, y, 1, 9, 8);
    assertArrayEquals(new int[] {9}, x);
    assertArrayEquals(new int[] {8}, y);
    assertFalse(SnakeRules.occupiesCell(x, y, 0, 9, 8));
  }

  @Test
  void coordinatesMustBelongToSameSegment() {
    assertFalse(SnakeRules.occupiesCell(new int[] {1, 2}, new int[] {3, 4}, 2, 1, 4));
    assertFalse(SnakeRules.occupiesCell(new int[] {1, 2}, new int[] {3, 4}, 1, 2, 4));
  }
}
