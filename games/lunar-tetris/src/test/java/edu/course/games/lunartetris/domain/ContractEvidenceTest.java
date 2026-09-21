package edu.course.games.lunartetris.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void adjacentRowsDisappearWithoutReorderingSurvivors() {
    int[][] b = {{1, 0, 0}, {2, 2, 2}, {3, 3, 3}, {0, 4, 0}};
    assertEquals(2, TetrisRules.removeFullRows(b));
    assertArrayEquals(new int[][] {{0, 0, 0}, {0, 0, 0}, {1, 0, 0}, {0, 4, 0}}, b);
    b[0][0] = 9;
    assertEquals(0, b[1][0]);
    int[][] source = {{1, 2, 3}, {4, 5, 6}};
    int[][] rotated = TetrisRules.rotateClockwise(source);
    assertArrayEquals(new int[][] {{4, 1}, {5, 2}, {6, 3}}, rotated);
    rotated[0][0] = 99;
    assertEquals(4, source[1][0]);
  }
}
