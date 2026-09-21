package edu.course.games.timecanvas.domain;

/** Owns bounded, independent pixel snapshots and discards redo after a new edit. */
public final class PixelHistory {
  private final int[][][] snapshots;
  private int currentIndex;
  private int latestIndex;

  public PixelHistory(int[][] initialPixels, int capacity) {
    if (capacity < 2) throw new IllegalArgumentException("History capacity must be at least two");
    snapshots = new int[capacity][][];
    snapshots[0] = CanvasRules.copyPixels(initialPixels);
  }

  public int[][] currentPixels() {
    return CanvasRules.copyPixels(snapshots[currentIndex]);
  }

  public int currentIndex() {
    return currentIndex;
  }

  public int latestIndex() {
    return latestIndex;
  }

  public void commit(int[][] pixels) {
    // Prepare before changing history: failed copying must not discard redo.
    int[][] snapshot = CanvasRules.copyPixels(pixels);
    if (currentIndex == snapshots.length - 1) {
      System.arraycopy(snapshots, 1, snapshots, 0, snapshots.length - 1);
    } else {
      currentIndex++;
    }
    snapshots[currentIndex] = snapshot;
    latestIndex = currentIndex;
    java.util.Arrays.fill(snapshots, currentIndex + 1, snapshots.length, null);
  }

  public boolean undo() {
    if (!CanvasRules.hasPreviousSnapshot(currentIndex, snapshots)) return false;
    currentIndex--;
    return true;
  }

  public boolean redo() {
    if (currentIndex >= latestIndex) return false;
    currentIndex++;
    return true;
  }
}
