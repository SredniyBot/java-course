package edu.course.labs.testing;

/** Deliberately faulty candidate for the testing lecture. See README contract before editing. */
public final class FuelTransfer {
  private FuelTransfer() {}

  public static void transfer(FuelTank from, FuelTank to, long amount) {
    from.changeTo(from.units() - amount);
    to.changeTo(to.units() + amount);
  }
}
