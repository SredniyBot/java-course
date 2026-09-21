package edu.course.games.cats256.domain;

import java.util.Arrays;
import java.util.Objects;

/** Owns a square tile board. Random selection belongs to the caller, not to this model. */
public final class TileBoard {
  private int[][] tiles;

  public TileBoard(int[][] initialTiles) {
    Objects.requireNonNull(initialTiles);
    if (initialTiles.length == 0) throw new IllegalArgumentException("Board must be nonempty");
    for (int[] row : initialTiles) {
      if (row == null || row.length != initialTiles.length)
        throw new IllegalArgumentException("Board must be square");
      for (int value : row) {
        if (value < 0 || value > (1 << 29) || (value != 0 && (value & (value - 1)) != 0)) {
          throw new IllegalArgumentException("Tiles must be zero or powers of two up to 2^29");
        }
      }
    }
    tiles = copy(initialTiles);
  }

  public int[][] snapshot() {
    return copy(tiles);
  }

  public boolean slide(MoveDirection direction) {
    Objects.requireNonNull(direction);
    // Candidate first: an unfinished student method cannot leave a partly rotated live board.
    int[][] candidate = snapshot();
    int turns = direction.clockwiseRotations();
    for (int count = 0; count < turns; count++) candidate = TileRules.rotateClockwise(candidate);
    for (int row = 0; row < candidate.length; row++)
      candidate[row] = TileRules.mergeLeft(candidate[row]);
    for (int count = 0; count < (4 - turns) % 4; count++)
      candidate = TileRules.rotateClockwise(candidate);
    for (int[] row : candidate)
      for (int value : row) {
        if (value > (1 << 29))
          throw new ArithmeticException("Tile exceeds the board's supported range");
      }
    if (Arrays.deepEquals(tiles, candidate)) return false;
    tiles = candidate;
    return true;
  }

  public int emptyCellCount() {
    int count = 0;
    for (int[] row : tiles) for (int value : row) if (value == 0) count++;
    return count;
  }

  /** Places a 2 in the zero-based ordinal empty cell in row-major order. */
  public void spawnTwo(int emptyCellOrdinal) {
    if (emptyCellOrdinal < 0 || emptyCellOrdinal >= emptyCellCount())
      throw new IllegalArgumentException("Empty cell ordinal is out of range");
    for (int row = 0; row < tiles.length; row++) {
      for (int col = 0; col < tiles.length; col++) {
        if (tiles[row][col] == 0 && emptyCellOrdinal-- == 0) {
          tiles[row][col] = 2;
          return;
        }
      }
    }
  }

  public boolean reached(int target) {
    for (int[] row : tiles) for (int value : row) if (value >= target) return true;
    return false;
  }

  public boolean hasLegalMove() {
    boolean hasEmptyCell = false;
    boolean hasTile = false;
    for (int row = 0; row < tiles.length; row++) {
      for (int col = 0; col < tiles.length; col++) {
        int value = tiles[row][col];
        if (value == 0) {
          hasEmptyCell = true;
          continue;
        }
        hasTile = true;
        if ((row + 1 < tiles.length && value == tiles[row + 1][col])
            || (col + 1 < tiles.length && value == tiles[row][col + 1])) return true;
      }
    }
    return hasEmptyCell && hasTile;
  }

  private static int[][] copy(int[][] source) {
    int[][] result = new int[source.length][];
    for (int row = 0; row < source.length; row++) result[row] = source[row].clone();
    return result;
  }
}
