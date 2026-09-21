package edu.course.games.lightsout.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class LightRulesPropertiesTest {
  @Test
  void anyToggleIsItsOwnInverse() {
    Random random = new Random(15001);
    for (int trial = 0; trial < 250; trial++) {
      boolean[][] a = new boolean[1 + random.nextInt(9)][1 + random.nextInt(9)];
      for (boolean[] row : a) for (int c = 0; c < row.length; c++) row[c] = random.nextBoolean();
      boolean[][] before = new boolean[a.length][];
      for (int r = 0; r < a.length; r++) before[r] = a[r].clone();
      int r = random.nextInt(a.length), c = random.nextInt(a[0].length);
      LightRules.toggleCross(a, r, c);
      LightRules.toggleCross(a, r, c);
      assertTrue(Arrays.deepEquals(before, a), "trial=" + trial);
    }
  }
}
