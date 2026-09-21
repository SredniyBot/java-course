package edu.course.games.marsmines.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void exhaustiveThreeByThreeHasEightNeighbors() {
    int[][] neighbors = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    for (int bits = 0; bits < 512; bits++) {
      boolean[][] b = new boolean[3][3];
      for (int i = 0; i < 9; i++) b[i / 3][i % 3] = (bits & (1 << i)) != 0;
      int expected = 0;
      for (int[] p : neighbors) if (b[p[0]][p[1]]) expected++;
      assertEquals(expected, MinefieldRules.countAdjacentMines(b, 1, 1), "bits=" + bits);
    }
  }
}
