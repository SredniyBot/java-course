package edu.course.games.cats256.domain;

/** Number of clockwise rotations needed to express a move as a left merge. */
public enum MoveDirection {
  LEFT(0),
  UP(3),
  RIGHT(2),
  DOWN(1);
  private final int clockwiseRotations;

  MoveDirection(int clockwiseRotations) {
    this.clockwiseRotations = clockwiseRotations;
  }

  int clockwiseRotations() {
    return clockwiseRotations;
  }
}
