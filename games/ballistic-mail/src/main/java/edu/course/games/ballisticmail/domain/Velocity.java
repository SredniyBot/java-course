package edu.course.games.ballisticmail.domain;

/** Velocity in screen coordinates, pixels per second; positive y points down. */
public record Velocity(double x, double y) {
  public Velocity {
    if (!Double.isFinite(x) || !Double.isFinite(y))
      throw new IllegalArgumentException("Velocity must be finite");
  }
}
