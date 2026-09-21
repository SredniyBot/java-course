package edu.course.games.lasermail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void mirrorTablesAreAnchoredAndReversible() {
    int[] slash = {3, 2, 1, 0}, back = {1, 0, 3, 2};
    for (int d = 0; d < 4; d++) {
      assertEquals(slash[d], BeamRules.reflectDirection(d, '/'));
      assertEquals(back[d], BeamRules.reflectDirection(d, (char) 92));
      assertEquals(d, BeamRules.reflectDirection(BeamRules.reflectDirection(d, '/'), '/'));
    }
    assertFalse(BeamRules.isInsideGrid(2, 0, 2, 3));
    assertTrue(BeamRules.isInsideGrid(1, 2, 2, 3));
  }
}
