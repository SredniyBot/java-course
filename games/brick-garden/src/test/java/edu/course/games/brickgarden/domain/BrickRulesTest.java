package edu.course.games.brickgarden.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BrickRulesTest {
  @Test
  void columnMatchesPublishedExamples() {

    assertEquals(0, BrickRules.columnAt(80));
    assertEquals(-1, BrickRules.columnAt(174));
    assertEquals(-1, BrickRules.columnAt(880));
  }

  @Test
  void remainingMatchesPublishedExamples() {

    assertEquals(2, BrickRules.countRemaining(new int[][] {{1, 0}, {2, 0}}));
  }
}
