package edu.course.games.factoryrobot.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void successfulLoadClosesExactlyOnceAndRunnerCanExecuteIt() throws Exception {
    Probe reader = new Probe("FRF", false, false);
    String program = RobotRules.readProgram(reader);
    assertEquals("FRF", program);
    assertEquals(1, reader.closes);
    RobotRunner runner = new RobotRunner(new int[][] {{0, 0}, {0, 0}}, new Cell(0, 0));
    assertTrue(runner.start(program));
    runner.step();
    runner.step();
    runner.step();
    assertEquals(new Cell(1, 1), runner.state().position());
    assertFalse(runner.state().running());
    assertEquals("F".repeat(60), RobotRules.readProgram(new java.io.StringReader("F".repeat(60))));
  }

  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.CsvSource(
      value = {"'':0", "F X:1", "f:0", "FX:1"},
      delimiter = ':')
  void rejectsFormatAndCloses(String text, int offset) {
    Probe reader = new Probe(text, false, false);
    ProgramFormatException failure =
        assertThrows(ProgramFormatException.class, () -> RobotRules.readProgram(reader));
    assertEquals(offset, failure.offset());
    assertEquals(1, reader.closes);
  }

  @Test
  void rejectsNewlinesAndReadsNoMoreThanTheLimitPlusOne() {
    assertThrows(
        ProgramFormatException.class,
        () -> RobotRules.readProgram(new java.io.StringReader("F\n")));
    Probe reader = new Probe("F".repeat(1000), false, false);
    assertEquals(
        60,
        assertThrows(ProgramFormatException.class, () -> RobotRules.readProgram(reader)).offset());
    assertEquals(61, reader.offset);
    assertEquals(1, reader.closes);
    assertThrows(NullPointerException.class, () -> RobotRules.readProgram(null));
  }

  @Test
  void preservesReadFailureAndItsSuppressedCloseFailure() {
    Probe reader = new Probe("F", true, true);
    ProgramLoadException failure =
        assertThrows(ProgramLoadException.class, () -> RobotRules.readProgram(reader));
    assertSame(reader.readFailure, failure.getCause());
    assertArrayEquals(new Throwable[] {reader.closeFailure}, failure.getCause().getSuppressed());
    assertEquals(0, failure.getSuppressed().length);
    assertEquals(1, reader.closes);
  }

  @Test
  void closeFailurePreventsSuccessfulReturn() {
    Probe reader = new Probe("F", false, true);
    ProgramLoadException failure =
        assertThrows(ProgramLoadException.class, () -> RobotRules.readProgram(reader));
    assertSame(reader.closeFailure, failure.getCause());
    assertEquals(1, reader.closes);
  }

  @Test
  void formatFailureStaysPrimaryAndOldExecutionSurvives() {
    RobotRunner runner = new RobotRunner(new int[][] {{0, 0}}, new Cell(0, 0));
    runner.start("F");
    ExecutionState before = runner.state();
    Probe reader = new Probe("X", false, true);
    ProgramFormatException failure =
        assertThrows(
            ProgramFormatException.class, () -> runner.start(RobotRules.readProgram(reader)));
    assertArrayEquals(new Throwable[] {reader.closeFailure}, failure.getSuppressed());
    assertEquals(before, runner.state());
    assertEquals(1, reader.closes);
  }

  private static final class Probe extends java.io.Reader {
    private final String text;
    private final boolean failRead, failClose;
    private final java.io.IOException readFailure = new java.io.IOException("read failed");
    private final java.io.IOException closeFailure = new java.io.IOException("close failed");
    private int offset, closes;

    Probe(String text, boolean failRead, boolean failClose) {
      this.text = text;
      this.failRead = failRead;
      this.failClose = failClose;
    }

    @Override
    public int read(char[] buffer, int start, int length) throws java.io.IOException {
      if (failRead) throw readFailure;
      if (length == 0) return 0;
      if (offset == text.length()) return -1;
      buffer[start] = text.charAt(offset++);
      return 1;
    }

    @Override
    public void close() throws java.io.IOException {
      closes++;
      if (failClose) throw closeFailure;
    }
  }
}
