package edu.course.labs.testing;

/** Single-threaded mutable tank; production ownership is local to the exercise. */
public final class FuelTank {
  private long units;

  public FuelTank(long units) {
    if (units < 0) throw new IllegalArgumentException("negative initial fuel");
    this.units = units;
  }

  public long units() {
    return units;
  }

  void changeTo(long value) {
    units = value;
  }
}
