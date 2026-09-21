package edu.course.games.pixelsymmetry.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.course.testing.Boards;
import java.util.Random;
import org.junit.jupiter.api.Test;

class SymmetryRulesPropertiesTest {
  @Test
  void mirroringAlwaysProducesSymmetryWithoutChangingLeftHalf() {
    Random random = new Random(13001);
    for (int trial = 0; trial < 250; trial++) {
      int[][] a = new int[1 + random.nextInt(8)][random.nextInt(9)];
      for (int[] row : a) for (int c = 0; c < row.length; c++) row[c] = random.nextInt();
      int[][] before = Boards.copy(a);
      SymmetryRules.mirrorLeftToRight(a);
      assertTrue(SymmetryRules.isHorizontallySymmetric(a), "trial=" + trial);
      for (int r = 0; r < a.length; r++)
        for (int c = 0; c < (a[r].length + 1) / 2; c++) assertEquals(before[r][c], a[r][c]);
    }
  }
}
