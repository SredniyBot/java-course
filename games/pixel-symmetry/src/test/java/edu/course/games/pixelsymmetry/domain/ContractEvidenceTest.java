package edu.course.games.pixelsymmetry.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void oddCenterAndSourceHalfSurviveIdempotentMirror() {
    int[][] a = {{1, 2, 7, 8, 9}, {3, 4, 6, 0, 0}};
    SymmetryRules.mirrorLeftToRight(a);
    assertArrayEquals(new int[][] {{1, 2, 7, 2, 1}, {3, 4, 6, 4, 3}}, a);
    SymmetryRules.mirrorLeftToRight(a);
    assertArrayEquals(new int[][] {{1, 2, 7, 2, 1}, {3, 4, 6, 4, 3}}, a);
    SymmetryRules.paintCell(a, -1, 0, 9);
    assertEquals(1, a[0][0]);
  }
}
