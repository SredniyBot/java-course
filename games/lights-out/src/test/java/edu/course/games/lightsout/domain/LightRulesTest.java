package edu.course.games.lightsout.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LightRulesTest {
  @Test
  void toggleMatchesPublishedExamples() {

    boolean[][] a = new boolean[2][2];
    LightRules.toggleCross(a, 0, 0);
    assertTrue(a[0][0] && a[0][1] && a[1][0] && !a[1][1]);
    LightRules.toggleCross(a, 0, 0);
    assertFalse(a[0][0]);
  }

  @Test
  void darkMatchesPublishedExamples() {

    assertTrue(LightRules.allLightsOff(new boolean[2][2]));
    assertFalse(LightRules.allLightsOff(new boolean[][] {{true}}));
  }
}
