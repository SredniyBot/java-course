package edu.course.games.timecanvas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PixelHistoryTest {
  @Test
  void ownsInputAndNeverExposesStoredArrays() {
    int[][] pixels = {{1}};
    PixelHistory history = new PixelHistory(pixels, 3);
    pixels[0][0] = 99;
    assertEquals(1, history.currentPixels()[0][0]);
    int[][] returned = history.currentPixels();
    returned[0][0] = 88;
    assertEquals(1, history.currentPixels()[0][0]);
  }

  @Test
  void editingAfterUndoDiscardsOnlyRedoBranch() {
    PixelHistory history = new PixelHistory(new int[][] {{1}}, 5);
    history.commit(new int[][] {{2}});
    history.commit(new int[][] {{3}});
    assertTrue(history.undo());
    history.commit(new int[][] {{4}});
    assertFalse(history.redo());
    assertTrue(history.undo());
    assertEquals(2, history.currentPixels()[0][0]);
    assertTrue(history.undo());
    assertEquals(1, history.currentPixels()[0][0]);
    assertFalse(history.undo());
  }

  @Test
  void boundedHistoryEvictsOldestSnapshotAndStillAllowsRedo() {
    PixelHistory history = new PixelHistory(new int[][] {{1}}, 2);
    history.commit(new int[][] {{2}});
    history.commit(new int[][] {{3}});
    assertTrue(history.undo());
    assertEquals(2, history.currentPixels()[0][0]);
    assertFalse(history.undo());
    assertTrue(history.redo());
    assertEquals(3, history.currentPixels()[0][0]);
    assertFalse(history.redo());
  }

  @Test
  void rejectsCapacityWithoutRoomForUndo() {
    assertThrows(IllegalArgumentException.class, () -> new PixelHistory(new int[][] {{1}}, 1));
  }
}
