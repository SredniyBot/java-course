package edu.course.games.ballisticmail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrajectoryPhysicsBoundaryTest {
  @Test
  void velocityPreservesMagnitudeAcrossAngles() {
    for (int angle = -360; angle <= 360; angle += 7) {
      Velocity v = TrajectoryPhysics.initialVelocity(angle, 123);
      assertEquals(123, Math.hypot(v.x(), v.y()), 1e-8, "angle=" + angle);
    }
  }

  @Test
  void zeroWidthHitRequiresExactPosition() {
    assertTrue(TrajectoryPhysics.isWithinTarget(3, 3, 0));
    assertFalse(TrajectoryPhysics.isWithinTarget(3.01, 3, 0));
  }
}
