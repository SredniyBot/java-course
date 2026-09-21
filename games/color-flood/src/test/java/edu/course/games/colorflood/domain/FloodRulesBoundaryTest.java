package edu.course.games.colorflood.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class FloodRulesBoundaryTest {
  @Test
  void floodDoesNotCrossDiagonalOrBarrier() {
    int[][] a = {{1, 2}, {2, 1}};
    FloodRules.fillFromOrigin(a, 9);
    assertTrue(Arrays.deepEquals(new int[][] {{9, 2}, {2, 1}}, a));
  }

  @Test
  void sameColorTerminatesAndLargeComponentDoesNotOverflowStack() {
    int[][] a = new int[100][100];
    FloodRules.fillFromOrigin(a, 0);
    FloodRules.fillFromOrigin(a, 7);
    assertTrue(FloodRules.isUniform(a));
    assertEquals(7, a[99][99]);
  }

  @Test
  void differentComponentMakesUniformFalse() {
    assertFalse(FloodRules.isUniform(new int[][] {{2, 2}, {2, 3}}));
  }
}
