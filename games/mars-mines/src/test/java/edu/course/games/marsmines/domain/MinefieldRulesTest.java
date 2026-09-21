package edu.course.games.marsmines.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MinefieldRulesTest {
  @Test
  void neighborsMatchesPublishedExamples() {

    assertEquals(
        2, MinefieldRules.countAdjacentMines(new boolean[][] {{true, true}, {false, true}}, 0, 0));
  }

  @Test
  void wonMatchesPublishedExamples() {

    assertTrue(
        MinefieldRules.allSafeCellsOpen(
            new boolean[][] {{true, false}}, new boolean[][] {{false, true}}));
    assertFalse(
        MinefieldRules.allSafeCellsOpen(new boolean[][] {{false}}, new boolean[][] {{false}}));
  }
}
