package edu.course.games.brickgarden.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void intervalOracleSeesEveryBrickAndGap() {
    for (int x = 70; x <= 890; x++) {
      int expected = -1;
      for (int col = 0; col < 8; col++)
        if (x >= 80 + 100 * col && x < 174 + 100 * col) expected = col;
      assertEquals(expected, BrickRules.columnAt(x), "x=" + x);
    }
  }
}
