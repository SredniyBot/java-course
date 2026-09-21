package edu.course.games.balloonrescue.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void repeatedLettersNeedOnlyOneGuessButKeepEveryPosition() {
    assertEquals("A _ A ", WordMask.revealGuessedLetters("ABA", "A"));
    assertEquals(
        WordMask.revealGuessedLetters("ABA", "A"), WordMask.revealGuessedLetters("ABA", "AAA"));
    assertTrue(WordMask.isFullyGuessed("ABA", "BA"));
    assertFalse(WordMask.isFullyGuessed("ABA", "A"));
  }
}
