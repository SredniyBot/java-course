package edu.course.games.moonlander.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LanderPhysicsBoundaryTest {
  @ParameterizedTest
  @CsvSource({
    "385,55,true",
    "555,-55,true",
    "384,0,false",
    "556,0,false",
    "470,56,false",
    "470,-56,false"
  })
  void landingChecksEveryBoundary(double x, double nextVerticalSpeed, boolean expected) {
    assertEquals(expected, LanderPhysics.isSafeLanding(x, nextVerticalSpeed));
  }

  @Test
  void engineChangesAccelerationAndZeroTimePreservesSpeed() {
    assertEquals(23, LanderPhysics.nextVerticalSpeed(10, false, .2), 1e-9);
    assertEquals(-3, LanderPhysics.nextVerticalSpeed(10, true, .2), 1e-9);
    assertEquals(-5, LanderPhysics.nextVerticalSpeed(-5, true, 0));
  }
}
