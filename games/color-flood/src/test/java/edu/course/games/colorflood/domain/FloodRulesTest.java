package edu.course.games.colorflood.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FloodRulesTest {
  @Test
  void floodMatchesPublishedExamples() {

    int[][] a = {{1, 2}, {2, 1}};
    FloodRules.fillFromOrigin(a, 3);
    assertTrue(java.util.Arrays.deepEquals(a, new int[][] {{3, 2}, {2, 1}}));
    FloodRules.fillFromOrigin(a, 3);
    assertTrue(a[0][0] == 3);
  }

  @Test
  void uniformMatchesPublishedExamples() {

    assertTrue(FloodRules.isUniform(new int[][] {{2, 2}, {2, 2}}));
    assertFalse(FloodRules.isUniform(new int[][] {{1, 2}}));
  }
}
