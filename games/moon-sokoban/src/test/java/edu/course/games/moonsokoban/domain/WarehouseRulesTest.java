package edu.course.games.moonsokoban.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WarehouseRulesTest {
  @Test
  void pushMatchesPublishedExamples() {

    int[][] a = {{2, 0, 1}};
    assertTrue(WarehouseRules.tryPushBox(a, 0, 0, 0, 1));
    assertTrue(a[0][1] == 2 && a[0][0] == 0);
    assertFalse(WarehouseRules.tryPushBox(a, 0, 1, 0, 1));
  }

  @Test
  void completeMatchesPublishedExamples() {

    assertTrue(
        WarehouseRules.allGoalsOccupied(new int[][] {{2, 0}}, new boolean[][] {{true, false}}));
    assertFalse(WarehouseRules.allGoalsOccupied(new int[][] {{0}}, new boolean[][] {{true}}));
  }
}
