package edu.course.games.cats256.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TileRulesBoundaryTest {
  static Stream<org.junit.jupiter.params.provider.Arguments> merges() {
    return Stream.of(
        org.junit.jupiter.params.provider.Arguments.of(
            new int[] {2, 2, 2, 2}, new int[] {4, 4, 0, 0}),
        org.junit.jupiter.params.provider.Arguments.of(
            new int[] {2, 2, 4, 0}, new int[] {4, 4, 0, 0}),
        org.junit.jupiter.params.provider.Arguments.of(new int[] {2, 0, 2}, new int[] {4, 0, 0}),
        org.junit.jupiter.params.provider.Arguments.of(new int[] {}, new int[] {}));
  }

  @ParameterizedTest
  @MethodSource("merges")
  void eachTileMergesAtMostOnce(int[] input, int[] expected) {
    int[] before = input.clone();
    int[] actual = TileRules.mergeLeft(input);
    assertArrayEquals(expected, actual);
    assertArrayEquals(before, input);
    assertNotSame(input, actual);
  }

  @Test
  void rotationAllocatesRows() {
    int[][] a = {{1, 2}, {3, 4}};
    int[][] b = TileRules.rotateClockwise(a);
    assertTrue(Arrays.deepEquals(new int[][] {{3, 1}, {4, 2}}, b));
    b[0][0] = 99;
    assertEquals(3, a[1][0]);
  }
}
