package edu.course.games.unicodesafari.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void combiningMarksAreCodePointsNotGraphemeClusters() {
    String s = "A🐱Б";
    assertEquals(3, UnicodeText.countCodePoints(s));
    assertEquals(7, UnicodeText.utf8Length(s));
    assertEquals("A🐱", UnicodeText.prefixByCodePoints(s, 2));
    assertEquals(2, UnicodeText.countCodePoints("é"));
    assertEquals("e", UnicodeText.prefixByCodePoints("é", 1));
  }
}
