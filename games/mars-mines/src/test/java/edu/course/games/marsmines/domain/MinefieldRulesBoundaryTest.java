package edu.course.games.marsmines.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MinefieldRulesBoundaryTest {
  @Test
  void neighborsExcludeSelfAndClipCorners() {
    boolean[][] b = {{true, true, true}, {true, true, true}, {true, true, true}};
    assertEquals(8, MinefieldRules.countAdjacentMines(b, 1, 1));
    assertEquals(3, MinefieldRules.countAdjacentMines(b, 0, 0));
    assertEquals(0, MinefieldRules.countAdjacentMines(new boolean[][] {{true}}, 0, 0));
  }

  @Test
  void victoryRequiresOnlySafeCells() {
    assertTrue(
        MinefieldRules.allSafeCellsOpen(
            new boolean[][] {{true, false}}, new boolean[][] {{false, true}}));
    assertFalse(
        MinefieldRules.allSafeCellsOpen(
            new boolean[][] {{true, false}}, new boolean[][] {{true, false}}));
    assertTrue(
        MinefieldRules.allSafeCellsOpen(new boolean[][] {{true}}, new boolean[][] {{false}}));
  }
}
