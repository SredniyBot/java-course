package edu.course.games.timecanvas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CanvasRulesBoundaryTest {
  @Test
  void copyBreaksEveryRowAliasIncludingRaggedRows() {
    int[][] a = {{1}, {2, 3}, {}};
    int[][] b = CanvasRules.copyPixels(a);
    assertTrue(Arrays.deepEquals(a, b));
    assertNotSame(a, b);
    for (int i = 0; i < a.length; i++) assertNotSame(a[i], b[i]);
    b[1][1] = 9;
    assertEquals(3, a[1][1]);
  }

  @Test
  void differenceCountsCellsNotRows() {
    assertEquals(
        2, CanvasRules.countDifferences(new int[][] {{1, 2}, {3}}, new int[][] {{8, 9}, {3}}));
  }

  @Test
  void undoChecksPreviousSnapshotAndShortCircuitsAtZero() {
    int[][][] h = new int[3][][];
    assertFalse(CanvasRules.hasPreviousSnapshot(0, h));
    assertFalse(CanvasRules.hasPreviousSnapshot(1, h));
    h[0] = new int[][] {{1}};
    assertTrue(CanvasRules.hasPreviousSnapshot(1, h));
    assertFalse(CanvasRules.hasPreviousSnapshot(2, h));
  }
}
