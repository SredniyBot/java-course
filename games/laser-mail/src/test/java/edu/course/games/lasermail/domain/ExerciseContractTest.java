package edu.course.games.lasermail.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void revisitingACellFromAnotherSideIsNotALoop() {
    char[][] field = {
      {0, '\\', '/', '/'}, {'/', 0, '\\', '/'}, {'\\', '/', '\\', 0}, {'/', '/', 0, '\\'}
    };
    BeamTrace trace = BeamRules.trace(field, 0, 0, 0, 1, 2);
    assertEquals(BeamTrace.End.DELIVERED, trace.end());
    assertEquals(
        java.util.List.of(
            new BeamCell(0, 0),
            new BeamCell(0, 1),
            new BeamCell(1, 1),
            new BeamCell(2, 1),
            new BeamCell(2, 0),
            new BeamCell(1, 0),
            new BeamCell(1, 1),
            new BeamCell(1, 2)),
        trace.cells());
  }

  @Test
  void includesReceiverAndStopsBeforeReflectingThere() {
    char[][] board = {{0, 0, '/'}};
    BeamTrace trace = BeamRules.trace(board, 0, 0, 0, 0, 2);
    assertEquals(
        java.util.List.of(new BeamCell(0, 0), new BeamCell(0, 1), new BeamCell(0, 2)),
        trace.cells());
    assertEquals(BeamTrace.End.DELIVERED, trace.end());
    assertThrows(UnsupportedOperationException.class, () -> trace.cells().clear());
    assertEquals('/', board[0][2]);
    assertEquals(1, BeamRules.trace(board, 0, 2, 2, 0, 2).cells().size());
  }

  @Test
  void exitsAndDetectsACompleteDirectionalCycle() {
    assertEquals(BeamTrace.End.EXITED, BeamRules.trace(new char[][] {{0, 0}}, 0, 0, 2, 0, 1).end());
    char[][] loop = {{'/', '\\', 0}, {'\\', '/', 0}, {0, 0, 0}};
    BeamTrace trace = BeamRules.trace(loop, 0, 0, 3, 2, 2);
    assertEquals(BeamTrace.End.LOOP, trace.end());
    assertEquals(
        java.util.List.of(
            new BeamCell(0, 0), new BeamCell(0, 1), new BeamCell(1, 1), new BeamCell(1, 0)),
        trace.cells());
  }

  @Test
  void validatesTheWholeBoardAndEndpoints() {
    for (char[][] board :
        new char[][][] {
          new char[0][],
          new char[][] {{}},
          new char[][] {null},
          new char[][] {{0}, null},
          new char[][] {{0}, {}},
          new char[][] {{0, 'X'}}
        })
      assertThrows(IllegalArgumentException.class, () -> BeamRules.trace(board, 0, 0, 0, 0, 0));
    assertThrows(NullPointerException.class, () -> BeamRules.trace(null, 0, 0, 0, 0, 0));
    for (int[] v :
        new int[][] {
          {-1, 0, 0, 0, 0},
          {0, 1, 0, 0, 0},
          {0, 0, -1, 0, 0},
          {0, 0, 4, 0, 0},
          {0, 0, 0, -1, 0},
          {0, 0, 0, 0, 1}
        })
      assertThrows(
          IllegalArgumentException.class,
          () -> BeamRules.trace(new char[][] {{0}}, v[0], v[1], v[2], v[3], v[4]));
  }
}
