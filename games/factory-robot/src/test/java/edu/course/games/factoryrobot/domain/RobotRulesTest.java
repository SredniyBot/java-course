package edu.course.games.factoryrobot.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RobotRulesTest {
  @ParameterizedTest
  @CsvSource({"0,L,3", "3,R,0", "2,F,2", "1,L,0", "0,R,1"})
  void turnFollowsCommand(int direction, char command, int result) {
    assertEquals(result, RobotRules.nextDirection(direction, command));
  }

  @Test
  void forwardStopsAtWallsAndDoesNotMutateMap() {
    int[][] map = {{0, 1}, {0, 0}};
    assertEquals(new Cell(0, 0), RobotRules.nextCell(map, 0, 0, 0));
    assertEquals(new Cell(1, 0), RobotRules.nextCell(map, 0, 0, 1));
    assertEquals(new Cell(0, 0), RobotRules.nextCell(map, 0, 0, 2));
    assertEquals(new Cell(0, 0), RobotRules.nextCell(map, 0, 0, 3));
    assertArrayEquals(new int[] {0, 1}, map[0]);
    assertArrayEquals(new int[] {0, 0}, map[1]);
  }

  @ParameterizedTest
  @CsvSource({"FFRFL,true", "'',false", "FX,false", "flr,false", "F F,false"})
  void onlyNonemptyUppercaseCommandsAreValid(String program, boolean isValidProgram) {
    assertEquals(isValidProgram, RobotRules.isValidProgram(program));
  }
}
