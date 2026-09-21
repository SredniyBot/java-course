package edu.course.games.memorycats.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void distinctObjectsMatchButSameIndexNeverDoes() {
    String[] cards = {new String("cat"), new String("cat"), "dog"};
    assertNotSame(cards[0], cards[1]);
    assertTrue(MatchingRules.isMatchingPair(cards, 0, 1));
    assertFalse(MatchingRules.isMatchingPair(cards, 0, 0));
    assertFalse(MatchingRules.isMatchingPair(cards, 0, 2));
  }
}
