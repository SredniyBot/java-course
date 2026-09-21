package edu.course.games.lasermail.domain;

import java.util.List;
import java.util.Objects;

/** Неизменяемый маршрут с причиной остановки луча. */
public record BeamTrace(List<BeamCell> cells, End end) {
  public enum End {
    DELIVERED,
    EXITED,
    LOOP
  }

  public BeamTrace {
    cells = List.copyOf(cells);
    Objects.requireNonNull(end);
  }
}
