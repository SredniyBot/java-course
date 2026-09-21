package edu.course.games.factoryrobot.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void wallsAndFourTurnsPreserveTheWorld() {
    int[][] map = {{0, 1}, {0, 0}};
    assertEquals(new Cell(0, 0), RobotRules.nextCell(map, 0, 0, 0));
    assertEquals(new Cell(1, 0), RobotRules.nextCell(map, 0, 0, 1));
    assertArrayEquals(new int[][] {{0, 1}, {0, 0}}, map);
    for (int initial = 0; initial < 4; initial++) {
      int d = initial;
      for (int i = 0; i < 4; i++) d = RobotRules.nextDirection(d, 'R');
      assertEquals(initial, d);
    }
    assertFalse(RobotRules.isValidProgram("F R"));
    assertFalse(RobotRules.isValidProgram(""));
  }
}
