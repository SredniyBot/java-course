package edu.course.games.moonsokoban.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void blockedPushPreservesTheEntireBoard() {
    int[][] a = {{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 0, 0, 1}};
    assertFalse(WarehouseRules.tryPushBox(a, 1, 1, 0, 1));
    assertArrayEquals(new int[][] {{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 0, 0, 1}}, a);
    assertTrue(WarehouseRules.tryPushBox(a, 1, 1, 1, 0));
    assertArrayEquals(new int[][] {{1, 1, 1, 1}, {1, 0, 2, 1}, {1, 2, 0, 1}}, a);
  }
}
