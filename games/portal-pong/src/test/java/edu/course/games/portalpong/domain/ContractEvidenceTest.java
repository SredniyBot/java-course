package edu.course.games.portalpong.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void translatedPaddleKeepsCalibratedRebound() {
    for (int top = -100; top <= 100; top++) {
      assertEquals(-100, PaddlePhysics.reflectedVerticalSpeed(top + 35, top));
      assertEquals(0, PaddlePhysics.reflectedVerticalSpeed(top + 55, top));
      assertEquals(100, PaddlePhysics.reflectedVerticalSpeed(top + 75, top));
      assertTrue(PaddlePhysics.intersectsPaddle(top - 10, top));
      assertFalse(PaddlePhysics.intersectsPaddle(top - 11, top));
    }
  }
}
