package edu.course.games.starcourier.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void translationAndBoundaryHaveIndependentAnchors() {
    assertTrue(CourierRules.isWithinRadius(3, 4, 0, 0, 5));
    assertFalse(CourierRules.isWithinRadius(4, 4, 0, 0, 5));
    for (int shift = -20; shift <= 20; shift++) {
      assertEquals(
          CourierRules.isWithinRadius(3, 4, 0, 0, 5),
          CourierRules.isWithinRadius(3 + shift, 4 + shift, shift, shift, 5));
      assertEquals(shift, CourierRules.clampCoordinate(shift, shift, shift));
    }
  }
}
