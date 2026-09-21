package edu.course.games.unicodesafari.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UnicodeTextTest {
  @Test
  void pointsMatchesPublishedExamples() {

    assertEquals(2, UnicodeText.countCodePoints("A🐱"));
    assertEquals(2, UnicodeText.countCodePoints("é"));
    assertEquals(0, UnicodeText.countCodePoints(""));
  }

  @Test
  void bytesMatchesPublishedExamples() {

    assertEquals(5, UnicodeText.utf8Length("A🐱"));
    assertEquals(2, UnicodeText.utf8Length("Ж"));
  }

  @Test
  void firstMatchesPublishedExamples() {

    assertTrue(UnicodeText.prefixByCodePoints("A🐱B", 2).equals("A🐱"));
    assertTrue(UnicodeText.prefixByCodePoints("cat", 0).isEmpty());
  }
}
