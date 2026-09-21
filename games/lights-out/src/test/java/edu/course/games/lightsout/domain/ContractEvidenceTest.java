package edu.course.games.lightsout.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void cornerHasThreeLightsAndSecondPressRestores() {
    boolean[][] a = new boolean[2][3];
    LightRules.toggleCross(a, 0, 0);
    assertArrayEquals(new boolean[][] {{true, true, false}, {true, false, false}}, a);
    LightRules.toggleCross(a, 0, 0);
    assertTrue(LightRules.allLightsOff(a));
  }
}
