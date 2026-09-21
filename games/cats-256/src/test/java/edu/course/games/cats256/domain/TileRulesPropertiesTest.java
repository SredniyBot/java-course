package edu.course.games.cats256.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class TileRulesPropertiesTest {
  @Test
  void mergeConservesSumLengthAndInput() {
    Random random = new Random(16001);
    for (int trial = 0; trial < 500; trial++) {
      int[] a = new int[random.nextInt(20)];
      for (int i = 0; i < a.length; i++) a[i] = random.nextBoolean() ? 0 : 1 << random.nextInt(10);
      int[] before = a.clone(), b = TileRules.mergeLeft(a);
      assertEquals(a.length, b.length);
      assertEquals(Arrays.stream(a).sum(), Arrays.stream(b).sum(), "trial=" + trial);
      assertArrayEquals(before, a);
      boolean zero = false;
      for (int value : b) {
        if (value == 0) zero = true;
        else assertFalse(zero, "nonzero after zero, trial=" + trial);
      }
    }
  }
}
