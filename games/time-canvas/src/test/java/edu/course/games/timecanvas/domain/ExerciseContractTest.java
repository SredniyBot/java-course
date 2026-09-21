package edu.course.games.timecanvas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void copiedRowsAreIndependentEvenIfSourceRowsAlias() {
    int[] row = {1, 2};
    int[][] source = {row, row, new int[0]};
    int[][] copy = CanvasRules.copyPixels(source);
    assertNotSame(source, copy);
    assertNotSame(row, copy[0]);
    assertNotSame(copy[0], copy[1]);
    row[0] = 9;
    assertArrayEquals(new int[] {1, 2}, copy[0]);
    copy[0][1] = 7;
    assertArrayEquals(new int[] {1, 2}, copy[1]);
    assertEquals(0, copy[2].length);
    assertEquals(0, CanvasRules.copyPixels(new int[0][]).length);
  }

  @Test
  void failedSnapshotPreservesHistoryAndRedo() {
    PixelHistory history = new PixelHistory(new int[][] {{1}}, 4);
    history.commit(new int[][] {{2}});
    history.undo();
    int current = history.currentIndex(), latest = history.latestIndex();
    assertThrows(NullPointerException.class, () -> history.commit(new int[][] {{9}, null}));
    assertEquals(current, history.currentIndex());
    assertEquals(latest, history.latestIndex());
    assertArrayEquals(new int[] {1}, history.currentPixels()[0]);
    assertTrue(history.redo());
    assertArrayEquals(new int[] {2}, history.currentPixels()[0]);
    assertThrows(NullPointerException.class, () -> CanvasRules.copyPixels(null));
  }
}
