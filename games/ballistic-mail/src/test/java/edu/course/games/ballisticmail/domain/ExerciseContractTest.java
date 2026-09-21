package edu.course.games.ballisticmail.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void usesUpdatedVerticalSpeedForPositionAndLeavesInputUntouched() {
    FlightState before = new FlightState(100, 200, 10, -20);
    assertEquals(new FlightState(105, 230, 10, 60), TrajectoryPhysics.advance(before, .5));
    assertEquals(new FlightState(100, 200, 10, -20), before);
    assertEquals(before, TrajectoryPhysics.advance(before, 0));
    assertEquals(new FlightState(110, 340, 10, 140), TrajectoryPhysics.advance(before, 1));
  }

  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.ValueSource(
      doubles = {-1, 1.01, Double.NaN, Double.POSITIVE_INFINITY})
  void invalidDurationIsAnApiError(double dt) {
    FlightState state = new FlightState(0, 0, 0, 0);
    assertThrows(IllegalArgumentException.class, () -> TrajectoryPhysics.advance(state, dt));
    assertEquals(new FlightState(0, 0, 0, 0), state);
  }

  @Test
  void rejectsNullAndUnrepresentableResult() {
    assertThrows(NullPointerException.class, () -> TrajectoryPhysics.advance(null, .5));
    FlightState large = new FlightState(Double.MAX_VALUE, 0, Double.MAX_VALUE, 0);
    assertThrows(IllegalArgumentException.class, () -> TrajectoryPhysics.advance(large, 1));
  }
}
