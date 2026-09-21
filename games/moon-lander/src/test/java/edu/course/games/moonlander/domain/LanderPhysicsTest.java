package edu.course.games.moonlander.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LanderPhysicsTest {
  @Test
  void speedMatchesPublishedExamples() {

    assertTrue(Math.abs(LanderPhysics.nextVerticalSpeed(0, false, 1) - 65) < 1e-9);
    assertEquals(-55, LanderPhysics.nextVerticalSpeed(10, true, 1));
  }

  @Test
  void landingMatchesPublishedExamples() {

    assertTrue(LanderPhysics.isSafeLanding(385, 55));
    assertFalse(LanderPhysics.isSafeLanding(384, 0));
    assertFalse(LanderPhysics.isSafeLanding(470, -56));
  }
}
