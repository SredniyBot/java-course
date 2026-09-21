package edu.course.games.brickgarden.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BrickRulesBoundaryTest {
  @ParameterizedTest
  @CsvSource({
    "79,-1",
    "80,0",
    "173.9,0",
    "174,-1",
    "179.9,-1",
    "180,1",
    "780,7",
    "873.9,7",
    "874,-1",
    "880,-1"
  })
  void columnDistinguishesGaps(double x, int expected) {
    assertEquals(expected, BrickRules.columnAt(x));
  }

  @Test
  void remainingCountsOnlyPositiveValuesWithoutMutation() {
    int[][] b = {{1, 0}, {-1, 2}};
    assertEquals(2, BrickRules.countRemaining(b));
    assertArrayEquals(new int[] {-1, 2}, b[1]);
    assertEquals(0, BrickRules.countRemaining(new int[0][]));
  }
}
