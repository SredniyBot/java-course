package edu.course.games.cloudjumper.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlatformRulesTest {
  @Test
  void landedMatchesPublishedExamples() {

    assertTrue(PlatformRules.crossesPlatform(90, 110, 5, 50, 0, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 110, -5, 50, 0, 100));
    assertFalse(PlatformRules.crossesPlatform(101, 110, 5, 50, 0, 100));
  }

  @Test
  void wrapMatchesPublishedExamples() {

    assertEquals(957, PlatformRules.wrapHorizontal(-3, 960));
    assertEquals(0, PlatformRules.wrapHorizontal(960, 960));
  }
}
