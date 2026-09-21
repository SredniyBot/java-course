package edu.course.games.unicodesafari.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UnicodeTextBoundaryTest {
  @ParameterizedTest
  @CsvSource({"A😀,2,5", "Я,1,2", "é,2,3", "'',0,0"})
  void pointsDifferFromCharsAndBytes(String text, int countCodePoints, int utf8Length) {
    assertEquals(countCodePoints, UnicodeText.countCodePoints(text));
    assertEquals(utf8Length, UnicodeText.utf8Length(text));
  }

  @Test
  void firstKeepsSurrogatePairsButMaySplitGraphemes() {
    assertEquals("A😀", UnicodeText.prefixByCodePoints("A😀B", 2));
    assertEquals("", UnicodeText.prefixByCodePoints("A😀B", 0));
    assertEquals("A😀B", UnicodeText.prefixByCodePoints("A😀B", 99));
    assertEquals("e", UnicodeText.prefixByCodePoints("é", 1));
  }
}
