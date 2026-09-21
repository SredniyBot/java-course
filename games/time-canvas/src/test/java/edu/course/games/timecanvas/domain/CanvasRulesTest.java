package edu.course.games.timecanvas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CanvasRulesTest {
  @Test
  void copyMatchesPublishedExamples() {

    int[][] a = {{1, 2}, {3, 4}}, b = CanvasRules.copyPixels(a);
    b[0][0] = 9;
    assertTrue(a[0][0] == 1);
    assertTrue(a != b && a[0] != b[0]);
  }

  @Test
  void differenceMatchesPublishedExamples() {

    assertEquals(1, CanvasRules.countDifferences(new int[][] {{1, 2}}, new int[][] {{1, 3}}));
  }

  @Test
  void canUndoMatchesPublishedExamples() {

    assertFalse(CanvasRules.hasPreviousSnapshot(0, new int[3][][]));
    assertFalse(CanvasRules.hasPreviousSnapshot(1, new int[3][][]));
    int[][][] s = new int[3][][];
    s[0] = new int[1][1];
    assertTrue(CanvasRules.hasPreviousSnapshot(1, s));
  }
}
