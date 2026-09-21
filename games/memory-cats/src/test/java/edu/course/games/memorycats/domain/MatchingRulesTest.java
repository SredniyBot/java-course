package edu.course.games.memorycats.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MatchingRulesTest {
  @Test
  void pairMatchesPublishedExamples() {

    assertTrue(
        MatchingRules.isMatchingPair(new String[] {new String("cat"), new String("cat")}, 0, 1));
    assertFalse(MatchingRules.isMatchingPair(new String[] {"cat"}, 0, 0));
  }

  @Test
  void completedMatchesPublishedExamples() {

    assertEquals(2, MatchingRules.countRevealedCards(new boolean[] {true, false, true}));
  }
}
