package edu.course.games.colorflood.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void diagonalIslandAndLargeComponentStayDistinct() {
    int[][] a = {{1, 0, 1}, {1, 0, 1}, {0, 1, 1}};
    FloodRules.fillFromOrigin(a, 2);
    assertArrayEquals(new int[][] {{2, 0, 1}, {2, 0, 1}, {0, 1, 1}}, a);
    int[][] large = new int[120][170];
    FloodRules.fillFromOrigin(large, 4);
    assertTrue(FloodRules.isUniform(large));
    assertEquals(4, large[119][169]);
    FloodRules.fillFromOrigin(large, 4);
    assertEquals(4, large[0][0]);
  }
}
