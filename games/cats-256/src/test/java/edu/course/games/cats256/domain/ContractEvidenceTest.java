package edu.course.games.cats256.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void newTileCannotMergeTwiceAndInputIsUntouched() {
    int[] a = {2, 2, 4, 0};
    assertArrayEquals(new int[] {4, 4, 0, 0}, TileRules.mergeLeft(a));
    assertArrayEquals(new int[] {2, 2, 4, 0}, a);
    assertArrayEquals(new int[] {4, 4, 0, 0}, TileRules.mergeLeft(new int[] {2, 2, 2, 2}));
    for (int x = 0; x <= 4; x += 2)
      for (int y = 0; y <= 4; y += 2) {
        int[] row = {x, 0, y, 0};
        int[] result = TileRules.mergeLeft(row);
        assertEquals(java.util.Arrays.stream(row).sum(), java.util.Arrays.stream(result).sum());
      }
  }
}
