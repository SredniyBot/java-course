package edu.course.games.lunartetris.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.course.testing.Boards;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TetrisRulesBoundaryTest {
  @Test
  void rectangularRotationIsIndependent() {
    int[][] a = Boards.numberedRectangle();
    int[][] b = TetrisRules.rotateClockwise(a);
    assertTrue(Arrays.deepEquals(new int[][] {{4, 1}, {5, 2}, {6, 3}}, b));
    b[0][0] = 99;
    assertEquals(4, a[1][0]);
  }

  @Test
  void consecutiveLinesAreRemovedStably() {
    int[][] b = {{1, 1}, {0, 2}, {3, 3}};
    assertEquals(2, TetrisRules.removeFullRows(b));
    assertTrue(Arrays.deepEquals(new int[][] {{0, 0}, {0, 0}, {0, 2}}, b));
  }

  @Test
  void emptyPieceCellsMayLieOutsideBoard() {
    assertTrue(TetrisRules.canPlace(new int[][] {{0}}, new int[][] {{0, 1}}, -1, 0));
    assertFalse(TetrisRules.canPlace(new int[][] {{0}}, new int[][] {{1}}, 0, -1));
    assertFalse(TetrisRules.canPlace(new int[][] {{1}}, new int[][] {{1}}, 0, 0));
  }

  @Test
  void noFullRowsMeansNoChange() {
    int[][] b = {{0, 1}, {1, 0}};
    assertEquals(0, TetrisRules.removeFullRows(b));
    assertTrue(Arrays.deepEquals(new int[][] {{0, 1}, {1, 0}}, b));
  }
}
