package edu.course.games.factoryrobot.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RobotRunnerTest {
  @Test
  void executesProgramWithoutClockAndStopsAtItsEnd() {
    RobotRunner runner = new RobotRunner(new int[][] {{0, 0}, {0, 0}}, new Cell(0, 0));
    assertTrue(runner.start("FRF"));
    assertEquals(new Cell(0, 1), runner.step().position());
    assertEquals(1, runner.step().direction());
    ExecutionState finished = runner.step();
    assertEquals(new Cell(1, 1), finished.position());
    assertEquals(3, finished.nextInstruction());
    assertFalse(finished.running());
    assertEquals(finished, runner.step());
  }

  @Test
  void mapIsOwnedAndBlockedCommandStillConsumesOneInstruction() {
    int[][] map = {{0, 1}};
    RobotRunner runner = new RobotRunner(map, new Cell(0, 0));
    map[0][1] = 0;
    runner.start("F");
    assertEquals(new ExecutionState(new Cell(0, 0), 0, 1, false), runner.step());
  }

  @Test
  void invalidStartDoesNotResetExistingExecutionAndValidStartDoes() {
    RobotRunner runner = new RobotRunner(new int[][] {{0, 0}}, new Cell(0, 0));
    runner.start("FF");
    ExecutionState before = runner.step();
    assertFalse(runner.start("FX"));
    assertEquals(before, runner.state());
    assertTrue(runner.start("L"));
    assertEquals(new Cell(0, 0), runner.state().position());
    assertEquals(3, runner.step().direction());
  }

  @Test
  void rejectsMalformedMapsAndBlockedOrigins() {
    assertThrows(
        IllegalArgumentException.class, () -> new RobotRunner(new int[0][], new Cell(0, 0)));
    assertThrows(
        IllegalArgumentException.class,
        () -> new RobotRunner(new int[][] {{0}, {0, 0}}, new Cell(0, 0)));
    assertThrows(
        IllegalArgumentException.class, () -> new RobotRunner(new int[][] {{1}}, new Cell(0, 0)));
  }
}
