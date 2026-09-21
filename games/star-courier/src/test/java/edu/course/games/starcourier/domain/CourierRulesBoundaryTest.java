package edu.course.games.starcourier.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CourierRulesBoundaryTest {
  @ParameterizedTest
  @CsvSource({"-1,0", "0,0", "4,4", "9,9", "10,9"})
  void clampsToClosedRange(double input, double expected) {
    assertEquals(expected, CourierRules.clampCoordinate(input, 0, 9));
  }

  @Test
  void degenerateRangeAndZeroRadius() {
    assertEquals(3, CourierRules.clampCoordinate(2, 3, 3));
    assertTrue(CourierRules.isWithinRadius(1, 2, 1, 2, 0));
    assertFalse(CourierRules.isWithinRadius(1, 2, 1, 3, 0));
  }

  @Test
  void detectsOutsideInEveryQuadrant() {
    assertFalse(CourierRules.isWithinRadius(0, 0, -3, -4, 4));
    assertTrue(CourierRules.isWithinRadius(0, 0, -3, -4, 5));
  }
}
