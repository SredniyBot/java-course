package edu.course.games.pixelsymmetry.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SymmetryRulesBoundaryTest {
  @Test
  void mirrorKeepsCenterAndIsIdempotent() {
    int[][] a = {{1, 2, 3, 4, 5}, {}};
    SymmetryRules.mirrorLeftToRight(a);
    assertArrayEquals(new int[] {1, 2, 3, 2, 1}, a[0]);
    assertTrue(SymmetryRules.isHorizontallySymmetric(a));
    SymmetryRules.mirrorLeftToRight(a);
    assertArrayEquals(new int[] {1, 2, 3, 2, 1}, a[0]);
  }

  @Test
  void outOfBoundsPaintIsNoOp() {
    int[][] a = {{1, 2}};
    SymmetryRules.paintCell(a, -1, 0, 9);
    SymmetryRules.paintCell(a, 0, 2, 9);
    assertArrayEquals(new int[] {1, 2}, a[0]);
    assertFalse(SymmetryRules.isHorizontallySymmetric(a));
  }
}
