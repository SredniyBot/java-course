package edu.course.games.unicodesafari.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void distinguishesCodePointsFromCharsAndGraphemes() {
    String text = "A🐱e\u0301";
    assertEquals("A🐱", UnicodeText.prefixByCodePoints(text, 2));
    assertEquals("A🐱e", UnicodeText.prefixByCodePoints(text, 3));
    assertEquals(text, UnicodeText.prefixByCodePoints(text, 100));
    assertEquals("", UnicodeText.prefixByCodePoints(text, 0));
    assertEquals("\uD800", UnicodeText.prefixByCodePoints("\uD800x", 1));
  }

  @Test
  void rejectsNegativeCountRatherThanClampingIt() {
    assertThrows(IllegalArgumentException.class, () -> UnicodeText.prefixByCodePoints("abc", -1));
    assertThrows(NullPointerException.class, () -> UnicodeText.prefixByCodePoints(null, 1));
  }
}
