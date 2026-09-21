package edu.course.labs.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** This green happy-path is intentionally insufficient. Expand it before fixing production. */
class FuelTransferTest {
  @Test
  void transfersFuelInAnOrdinaryCase() {
    FuelTank a = new FuelTank(100), b = new FuelTank(50);
    FuelTransfer.transfer(a, b, 30);
    assertEquals(70, a.units());
    assertEquals(80, b.units());
  }
}
