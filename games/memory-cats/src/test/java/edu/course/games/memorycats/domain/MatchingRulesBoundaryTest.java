package edu.course.games.memorycats.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MatchingRulesBoundaryTest {
  @Test
  void pairUsesContentsButRequiresDifferentPositions() {
    String[] c = {new String("A"), new String("A"), "a"};
    assertTrue(MatchingRules.isMatchingPair(c, 0, 1));
    assertFalse(MatchingRules.isMatchingPair(c, 0, 0));
    assertFalse(MatchingRules.isMatchingPair(c, 0, 2));
  }

  @Test
  void completedCountsCardsNotPairs() {
    assertEquals(3, MatchingRules.countRevealedCards(new boolean[] {true, true, false, true}));
    assertEquals(0, MatchingRules.countRevealedCards(new boolean[0]));
  }
}
