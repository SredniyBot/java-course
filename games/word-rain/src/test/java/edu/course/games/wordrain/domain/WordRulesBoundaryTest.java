package edu.course.games.wordrain.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordRulesBoundaryTest {
  @Test
  void normalizationUsesUnicodeStripAndPreservesInternalSpaces() {
    assertEquals("a  b", WordRules.normalizeInput("\u2003A  B\u2003"));
    assertEquals("", WordRules.normalizeInput(""));
  }

  @ParameterizedTest
  @CsvSource({
    "java,'',true",
    "java,jav,true",
    "java,ava,false",
    "java,Java,false",
    "java,javascript,false"
  })
  void prefixIsNotSubstring(String word, String input, boolean expected) {
    assertEquals(expected, WordRules.isPrefix(word, input));
  }
}
