package edu.course.games.ballisticmail.domain;

/** Положение и скорость в экранных координатах: ось y направлена вниз. */
public record FlightState(double x, double y, double vx, double vy) {
  public FlightState {
    if (!Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(vx) || !Double.isFinite(vy))
      throw new IllegalArgumentException("Flight components must be finite");
  }
}
