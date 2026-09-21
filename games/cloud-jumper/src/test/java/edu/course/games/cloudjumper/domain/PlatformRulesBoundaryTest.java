package edu.course.games.cloudjumper.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlatformRulesBoundaryTest {
  @ParameterizedTest
  @CsvSource({"-960,0", "-1,959", "0,0", "959,959", "960,0", "1919,959"})
  void wrapUsesHalfOpenInterval(double x, double expected) {
    assertEquals(expected, PlatformRules.wrapHorizontal(x, 960));
  }

  @Test
  void landingRequiresCrossingDownwardAndHorizontalOverlap() {
    assertTrue(PlatformRules.crossesPlatform(100, 100, 1, 100, 100, 100));
    assertTrue(PlatformRules.crossesPlatform(90, 110, 1, 240, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 110, 0, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 110, -1, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(101, 110, 1, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 99, 1, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 110, 1, 99, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 110, 1, 241, 100, 100));
  }
}
