package edu.course.games.wordmaze.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void readsOnlyTheActivePrefixWithoutEnforcingAdjacency() {
    char[][] board = {{'A', 'B'}, {'C', 'D'}};
    int[] path = {3, 0, 3, -1};
    assertEquals("DAD", WordPathRules.readPath(board, path, 3));
    assertEquals("", WordPathRules.readPath(board, path, 0));
    assertArrayEquals(new int[] {3, 0, 3, -1}, path);
    assertArrayEquals(new char[] {'A', 'B'}, board[0]);
  }

  @Test
  void separatesMalformedArgumentsFromCellIndexErrors() {
    char[][] board = {{'A'}};
    for (int index : new int[] {-1, 1, Integer.MAX_VALUE})
      assertThrows(
          IndexOutOfBoundsException.class,
          () -> WordPathRules.readPath(board, new int[] {index}, 1));
    for (int length : new int[] {-1, 2})
      assertThrows(
          IllegalArgumentException.class,
          () -> WordPathRules.readPath(board, new int[] {0}, length));
    for (char[][] invalid :
        new char[][][] {
          new char[0][],
          new char[][] {{}},
          new char[][] {null},
          new char[][] {{'A'}, null},
          new char[][] {{'A'}, {}}
        })
      assertThrows(
          IllegalArgumentException.class, () -> WordPathRules.readPath(invalid, new int[] {0}, 1));
    assertThrows(NullPointerException.class, () -> WordPathRules.readPath(null, new int[0], 0));
    assertThrows(NullPointerException.class, () -> WordPathRules.readPath(board, null, 0));
    assertEquals('A', board[0][0]);
  }
}
