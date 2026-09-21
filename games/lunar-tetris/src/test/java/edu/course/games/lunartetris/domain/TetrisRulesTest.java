package edu.course.games.lunartetris.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TetrisRulesTest {
  @Test
  void rotateMatchesPublishedExamples() {

    int[][] a = {{1, 2, 3}, {4, 5, 6}};
    assertTrue(
        java.util.Arrays.deepEquals(
            TetrisRules.rotateClockwise(a), new int[][] {{4, 1}, {5, 2}, {6, 3}}));
    assertTrue(a[0][0] == 1);
  }

  @Test
  void fitsMatchesPublishedExamples() {

    assertTrue(TetrisRules.canPlace(new int[2][2], new int[][] {{1}}, 1, 1));
    assertFalse(TetrisRules.canPlace(new int[2][2], new int[][] {{1}}, 2, 1));
  }

  @Test
  void clearLinesMatchesPublishedExamples() {

    int[][] b = {{0, 1}, {1, 1}, {1, 1}};
    assertEquals(2, TetrisRules.removeFullRows(b));
    assertTrue(java.util.Arrays.deepEquals(b, new int[][] {{0, 0}, {0, 0}, {0, 1}}));
  }
}
