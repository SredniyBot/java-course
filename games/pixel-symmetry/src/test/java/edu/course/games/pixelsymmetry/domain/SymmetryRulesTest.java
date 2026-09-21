package edu.course.games.pixelsymmetry.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SymmetryRulesTest {
  @Test
  void paintMatchesPublishedExamples() {

    int[][] a = {{0}};
    SymmetryRules.paintCell(a, -1, 0, 2);
    assertTrue(a[0][0] == 0);
    SymmetryRules.paintCell(a, 0, 0, 3);
    assertTrue(a[0][0] == 3);
  }

  @Test
  void mirrorMatchesPublishedExamples() {

    int[][] a = {{1, 2, 3, 4, 5}};
    SymmetryRules.mirrorLeftToRight(a);
    assertTrue(java.util.Arrays.equals(a[0], new int[] {1, 2, 3, 2, 1}));
  }

  @Test
  void symmetricMatchesPublishedExamples() {

    assertTrue(SymmetryRules.isHorizontallySymmetric(new int[][] {{1, 2, 1}}));
    assertFalse(SymmetryRules.isHorizontallySymmetric(new int[][] {{1, 0}}));
  }
}
