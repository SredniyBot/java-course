package edu.course.games.couriersnake.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SnakeRulesTest {
  @Test
  void moveMatchesPublishedExamples() {

    int[] x = {3, 2, 1}, y = {4, 4, 4};
    SnakeRules.advanceBody(x, y, 3, 4, 4);
    assertTrue(java.util.Arrays.equals(x, new int[] {4, 3, 2}));
  }

  @Test
  void occupiedMatchesPublishedExamples() {

    assertTrue(SnakeRules.occupiesCell(new int[] {2, 3}, new int[] {4, 5}, 2, 3, 5));
    assertFalse(SnakeRules.occupiesCell(new int[] {2}, new int[] {4}, 0, 2, 4));
  }
}
