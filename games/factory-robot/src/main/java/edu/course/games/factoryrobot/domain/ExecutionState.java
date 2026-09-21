package edu.course.games.factoryrobot.domain;

import java.util.Objects;

/** Immutable observation of one program execution; no map or mutable collection escapes. */
public record ExecutionState(Cell position, int direction, int nextInstruction, boolean running) {
  public ExecutionState {
    Objects.requireNonNull(position);
    if (direction < 0 || direction > 3 || nextInstruction < 0) {
      throw new IllegalArgumentException("Invalid execution state");
    }
  }
}
