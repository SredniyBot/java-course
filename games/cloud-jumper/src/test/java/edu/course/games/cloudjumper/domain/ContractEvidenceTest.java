package edu.course.games.cloudjumper.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void skippedFrameCrossesButAnOldPositionBelowDoesNot() {
    assertTrue(PlatformRules.crossesPlatform(90, 130, 40, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(101, 130, 40, 150, 100, 100));
    assertFalse(PlatformRules.crossesPlatform(90, 130, -40, 150, 100, 100));
    assertEquals(0, PlatformRules.wrapHorizontal(960, 960));
  }
}
