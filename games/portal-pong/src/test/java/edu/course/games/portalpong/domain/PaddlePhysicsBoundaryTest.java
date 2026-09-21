package edu.course.games.portalpong.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PaddlePhysicsBoundaryTest {
  @ParameterizedTest
  @CsvSource({"89,false", "90,true", "155,true", "220,true", "221,false"})
  void paddleIncludesRadius(double y, boolean expected) {
    assertEquals(expected, PaddlePhysics.intersectsPaddle(y, 100));
  }

  @Test
  void bounceIsSignedAroundCenter() {
    assertEquals(0, PaddlePhysics.reflectedVerticalSpeed(155, 100));
    assertEquals(-50, PaddlePhysics.reflectedVerticalSpeed(145, 100));
    assertEquals(50, PaddlePhysics.reflectedVerticalSpeed(165, 100));
  }
}
