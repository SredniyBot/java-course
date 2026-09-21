package edu.course.games.ballisticmail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void cardinalAnglesFixSignsAndUnits() {
    Velocity horizontal = TrajectoryPhysics.initialVelocity(0, 10);
    assertEquals(10, horizontal.x(), 1e-12);
    assertEquals(0, horizontal.y(), 1e-12);
    Velocity up = TrajectoryPhysics.initialVelocity(90, 10);
    assertEquals(0, up.x(), 1e-12);
    assertEquals(-10, up.y(), 1e-12);
    assertTrue(TrajectoryPhysics.isWithinTarget(110, 100, 10));
    assertFalse(TrajectoryPhysics.isWithinTarget(111, 100, 10));
  }
}
