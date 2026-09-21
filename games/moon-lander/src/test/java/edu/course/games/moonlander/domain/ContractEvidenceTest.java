package edu.course.games.moonlander.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void constantAccelerationComposesAcrossSteps() {
    for (boolean engine : new boolean[] {true, false})
      for (int speed = -50; speed <= 50; speed += 5)
        assertEquals(
            LanderPhysics.nextVerticalSpeed(speed, engine, .4),
            LanderPhysics.nextVerticalSpeed(
                LanderPhysics.nextVerticalSpeed(speed, engine, .1), engine, .3),
            1e-12);
    assertFalse(LanderPhysics.isSafeLanding(470, -56));
    assertTrue(LanderPhysics.isSafeLanding(385, -55));
  }
}
