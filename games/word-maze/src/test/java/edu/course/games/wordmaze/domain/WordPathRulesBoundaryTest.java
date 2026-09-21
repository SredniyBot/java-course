package edu.course.games.wordmaze.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordPathRulesBoundaryTest {
  @ParameterizedTest
  @CsvSource({"2,3,3,false", "1,4,3,true", "1,1,3,false", "0,4,3,false", "4,1,3,true"})
  void adjacentUsesCoordinates(int a, int b, int width, boolean expected) {
    assertEquals(expected, WordPathRules.areSideNeighbors(a, b, width));
  }

  @Test
  void readUsesWidthAndOnlyRequestedPrefix() {
    char[][] b = {{'J', 'A', 'V'}, {'X', 'Y', 'A'}};
    assertEquals("JAVA", WordPathRules.readPath(b, new int[] {0, 1, 2, 5, -1}, 4));
    assertEquals("", WordPathRules.readPath(b, new int[] {-1}, 0));
  }
}
