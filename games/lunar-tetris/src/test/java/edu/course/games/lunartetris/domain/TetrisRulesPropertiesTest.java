package edu.course.games.lunartetris.domain;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class TetrisRulesPropertiesTest {
  @Test
  void fourRotationsPreserveArbitraryRectangles() {
    Random random = new Random(7001);
    for (int trial = 0; trial < 250; trial++) {
      int[][] a = new int[1 + random.nextInt(7)][1 + random.nextInt(7)];
      for (int[] row : a) for (int c = 0; c < row.length; c++) row[c] = random.nextInt();
      int[][] b = a;
      for (int i = 0; i < 4; i++) b = TetrisRules.rotateClockwise(b);
      assertTrue(Arrays.deepEquals(a, b), "trial=" + trial);
      assertNotSame(a, b);
    }
  }
}
