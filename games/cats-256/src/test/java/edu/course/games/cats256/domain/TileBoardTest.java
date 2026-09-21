package edu.course.games.cats256.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class TileBoardTest {
  @Test
  void anEntirelyEmptyBoardHasNothingToMove() {
    assertFalse(new TileBoard(new int[2][2]).hasLegalMove());
  }

  @Test
  void rejectedOverflowLeavesTheLiveBoardUnchanged() {
    int[][] initial = {{1 << 29, 1 << 29}, {0, 0}};
    TileBoard board = new TileBoard(initial);
    assertThrows(ArithmeticException.class, () -> board.slide(MoveDirection.LEFT));
    assertTrue(Arrays.deepEquals(initial, board.snapshot()));
  }

  @ParameterizedTest
  @EnumSource(MoveDirection.class)
  void directionalSlidesPreserveSumAndDoNotSpawn(MoveDirection direction) {
    TileBoard board = new TileBoard(new int[][] {{2, 2}, {2, 2}});
    assertTrue(board.slide(direction));
    assertEquals(8, Arrays.stream(board.snapshot()).flatMapToInt(Arrays::stream).sum());
    assertEquals(2, board.emptyCellCount());
  }

  @Test
  void unchangedMoveDoesNotSpawnAndSnapshotsAreIndependent() {
    int[][] input = {{2, 0}, {0, 0}};
    TileBoard board = new TileBoard(input);
    input[0][0] = 4;
    assertFalse(board.slide(MoveDirection.LEFT));
    assertEquals(3, board.emptyCellCount());
    int[][] snapshot = board.snapshot();
    snapshot[0][0] = 8;
    assertEquals(2, board.snapshot()[0][0]);
  }

  @Test
  void choosesEmptyCellsByOrdinalAndRecognizesTerminalBoards() {
    TileBoard board = new TileBoard(new int[][] {{0, 4}, {8, 0}});
    board.spawnTwo(1);
    assertEquals(2, board.snapshot()[1][1]);
    assertTrue(board.hasLegalMove());
    board.spawnTwo(0);
    assertFalse(board.hasLegalMove());
    assertTrue(board.reached(8));
    assertFalse(board.reached(16));
    assertThrows(IllegalArgumentException.class, () -> board.spawnTwo(0));
  }

  @Test
  void upwardSlideActuallyMovesUp() {
    TileBoard board = new TileBoard(new int[][] {{0, 0}, {2, 4}});
    board.slide(MoveDirection.UP);
    assertTrue(Arrays.deepEquals(new int[][] {{2, 4}, {0, 0}}, board.snapshot()));
  }
}
