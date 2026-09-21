package edu.course.games.wordmaze.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordPathRulesTest {
  @Test
  void adjacentMatchesPublishedExamples() {

    assertTrue(WordPathRules.areSideNeighbors(0, 1, 4));
    assertFalse(WordPathRules.areSideNeighbors(3, 4, 4));
    assertFalse(WordPathRules.areSideNeighbors(0, 5, 4));
  }

  @Test
  void readMatchesPublishedExamples() {

    assertTrue(
        WordPathRules.readPath(new char[][] {{'J', 'A'}, {'V', 'A'}}, new int[] {0, 1, 3}, 3)
            .equals("JAA"));
  }
}
