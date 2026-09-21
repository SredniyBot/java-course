package edu.course.games.moonsokoban.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WarehouseRulesBoundaryTest {
  @Test
  void pushRejectsEveryOuterEdgeWithoutChangingBox() {
    int[][] board = {{2}};
    assertFalse(WarehouseRules.tryPushBox(board, 0, 0, 0, 1));
    assertFalse(WarehouseRules.tryPushBox(board, 0, 0, 0, -1));
    assertFalse(WarehouseRules.tryPushBox(board, 0, 0, 1, 0));
    assertFalse(WarehouseRules.tryPushBox(board, 0, 0, -1, 0));
    assertEquals(2, board[0][0]);
  }

  @Test
  void blockedPushIsAtomic() {
    int[][] b = {{2, 1}};
    assertFalse(WarehouseRules.tryPushBox(b, 0, 0, 0, 1));
    assertFalse(WarehouseRules.tryPushBox(b, 0, 0, -1, 0));
    assertTrue(Arrays.deepEquals(new int[][] {{2, 1}}, b));
  }

  @Test
  void successfulPushMovesExactlyOneBox() {
    int[][] b = {{2, 0, 1}};
    assertTrue(WarehouseRules.tryPushBox(b, 0, 0, 0, 1));
    assertArrayEquals(new int[] {0, 2, 1}, b[0]);
    assertTrue(WarehouseRules.allGoalsOccupied(b, new boolean[][] {{false, true, false}}));
    assertFalse(WarehouseRules.allGoalsOccupied(b, new boolean[][] {{true, false, false}}));
    assertTrue(WarehouseRules.allGoalsOccupied(b, new boolean[1][3]));
  }
}
