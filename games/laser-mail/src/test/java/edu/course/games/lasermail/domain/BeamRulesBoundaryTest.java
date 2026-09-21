package edu.course.games.lasermail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BeamRulesBoundaryTest {
  @ParameterizedTest
  @CsvSource({"0,3,1", "1,2,0", "2,1,3", "3,0,2"})
  void bothMirrorTablesAreComplete(int direction, int slash, int backslash) {
    assertEquals(slash, BeamRules.reflectDirection(direction, '/'));
    assertEquals(backslash, BeamRules.reflectDirection(direction, '\\'));
    assertEquals(direction, BeamRules.reflectDirection(direction, '.'));
  }

  @Test
  void insideIsHalfOpenInBothDimensions() {
    assertTrue(BeamRules.isInsideGrid(0, 0, 1, 1));
    assertFalse(BeamRules.isInsideGrid(-1, 0, 1, 1));
    assertFalse(BeamRules.isInsideGrid(0, -1, 1, 1));
    assertFalse(BeamRules.isInsideGrid(1, 0, 1, 1));
    assertFalse(BeamRules.isInsideGrid(0, 1, 1, 1));
    assertFalse(BeamRules.isInsideGrid(0, 0, 0, 1));
  }
}
