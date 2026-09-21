package edu.course.games.timecanvas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void copiesProtectBothDirectionsAndHistoryBranches() {
    int[][] original = {{1, 2}, {3, 4}};
    int[][] copy = CanvasRules.copyPixels(original);
    original[0][0] = 9;
    assertEquals(1, copy[0][0]);
    copy[1][1] = 8;
    assertEquals(4, original[1][1]);
    PixelHistory h = new PixelHistory(new int[][] {{0}}, 3);
    h.commit(new int[][] {{1}});
    h.commit(new int[][] {{2}});
    assertTrue(h.undo());
    h.commit(new int[][] {{3}});
    assertFalse(h.redo());
    assertEquals(3, h.currentPixels()[0][0]);
  }
}
