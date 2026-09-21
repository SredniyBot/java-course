package edu.course.games.cats256.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TileRulesTest {
  @Test
  void mergeMatchesPublishedExamples() {

    int[] a = {2, 2, 2, 2};
    assertTrue(java.util.Arrays.equals(TileRules.mergeLeft(a), new int[] {4, 4, 0, 0}));
    assertTrue(a[0] == 2);
    assertTrue(
        java.util.Arrays.equals(
            TileRules.mergeLeft(new int[] {2, 0, 2, 4}), new int[] {4, 4, 0, 0}));
  }

  @Test
  void rotateMatchesPublishedExamples() {

    assertTrue(
        java.util.Arrays.deepEquals(
            TileRules.rotateClockwise(new int[][] {{1, 2}, {3, 4}}), new int[][] {{3, 1}, {4, 2}}));
  }
}
