package edu.course.games.lasermail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BeamRulesTest {
  @Test
  void reflectMatchesPublishedExamples() {

    assertEquals(3, BeamRules.reflectDirection(0, '/'));
    assertEquals(1, BeamRules.reflectDirection(0, '\\'));
    assertEquals(2, BeamRules.reflectDirection(2, 'x'));
  }

  @Test
  void insideMatchesPublishedExamples() {

    assertTrue(BeamRules.isInsideGrid(0, 0, 2, 3));
    assertFalse(BeamRules.isInsideGrid(2, 0, 2, 3));
  }
}
