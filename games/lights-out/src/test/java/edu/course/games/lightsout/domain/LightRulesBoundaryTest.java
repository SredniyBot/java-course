package edu.course.games.lightsout.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LightRulesBoundaryTest {
  @Test
  void cornerChangesExactlyThreeCells() {
    boolean[][] a = new boolean[2][2];
    LightRules.toggleCross(a, 0, 0);
    assertTrue(Arrays.deepEquals(new boolean[][] {{true, true}, {true, false}}, a));
    LightRules.toggleCross(a, 0, 0);
    assertTrue(LightRules.allLightsOff(a));
  }

  @Test
  void emptyBoardIsDark() {
    assertTrue(LightRules.allLightsOff(new boolean[0][]));
    assertFalse(LightRules.allLightsOff(new boolean[][] {{false, true}}));
  }
}
