package edu.course.games.portalpong.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PaddlePhysicsTest {
  @Test
  void inPaddleMatchesPublishedExamples() {

    assertTrue(PaddlePhysics.intersectsPaddle(90, 100));
    assertFalse(PaddlePhysics.intersectsPaddle(89, 100));
  }

  @Test
  void bounceYMatchesPublishedExamples() {

    assertEquals(0, PaddlePhysics.reflectedVerticalSpeed(155, 100));
    assertEquals(-275, PaddlePhysics.reflectedVerticalSpeed(100, 100));
  }
}
