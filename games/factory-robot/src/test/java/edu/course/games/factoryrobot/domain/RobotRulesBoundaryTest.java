package edu.course.games.factoryrobot.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RobotRulesBoundaryTest {
  @Test
  void fourRightTurnsAndOppositeTurnsRestoreDirection() {
    for (int direction = 0; direction < 4; direction++) {
      int d = direction;
      for (int i = 0; i < 4; i++) d = RobotRules.nextDirection(d, 'R');
      assertEquals(direction, d);
      assertEquals(
          direction, RobotRules.nextDirection(RobotRules.nextDirection(direction, 'L'), 'R'));
    }
  }

  @Test
  void verticalMovementUsesRows() {
    assertEquals(new Cell(0, 0), RobotRules.nextCell(new int[][] {{0}, {0}}, 1, 0, 3));
    assertEquals(new Cell(1, 0), RobotRules.nextCell(new int[][] {{0}, {0}}, 1, 0, 1));
  }
}
