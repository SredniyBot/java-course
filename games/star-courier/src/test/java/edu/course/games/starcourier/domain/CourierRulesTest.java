package edu.course.games.starcourier.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CourierRulesTest {
  @Test
  void limitMatchesPublishedExamples() {

    assertEquals(0, CourierRules.clampCoordinate(-2, 0, 9));
    assertEquals(9, CourierRules.clampCoordinate(15, 0, 9));
    assertEquals(4, CourierRules.clampCoordinate(4, 0, 9));
  }

  @Test
  void touchesMatchesPublishedExamples() {

    assertTrue(CourierRules.isWithinRadius(0, 0, 3, 4, 5));
    assertFalse(CourierRules.isWithinRadius(0, 0, 3, 4, 4));
  }
}
