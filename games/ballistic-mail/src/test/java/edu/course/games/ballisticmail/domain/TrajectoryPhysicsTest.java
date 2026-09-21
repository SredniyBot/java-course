package edu.course.games.ballisticmail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TrajectoryPhysicsTest {
  @ParameterizedTest
  @CsvSource({"0,10,10,0", "90,10,0,-10", "180,10,-10,0", "45,0,0,0"})
  void velocityUsesDegreesAndScreenYAxis(double angle, double speed, double x, double y) {
    Velocity v = TrajectoryPhysics.initialVelocity(angle, speed);
    assertEquals(x, v.x(), 1e-8);
    assertEquals(y, v.y(), 1e-8);
  }

  @Test
  void hitIncludesBothEdges() {
    assertTrue(TrajectoryPhysics.isWithinTarget(60, 100, 40));
    assertTrue(TrajectoryPhysics.isWithinTarget(140, 100, 40));
    assertFalse(TrajectoryPhysics.isWithinTarget(59, 100, 40));
    assertFalse(TrajectoryPhysics.isWithinTarget(141, 100, 40));
  }

  @Test
  void velocityRejectsNonFiniteComponents() {
    assertThrows(IllegalArgumentException.class, () -> new Velocity(Double.NaN, 0));
  }
}
