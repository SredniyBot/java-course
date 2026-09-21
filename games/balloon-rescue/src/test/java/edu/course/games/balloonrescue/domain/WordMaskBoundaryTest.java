package edu.course.games.balloonrescue.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordMaskBoundaryTest {
  @Test
  void repeatedLettersAndTrailingSpaceAreExplicit() {
    assertEquals("_ A _ A ", WordMask.revealGuessedLetters("JAVA", "A"));
    assertEquals("", WordMask.revealGuessedLetters("", ""));
    assertTrue(WordMask.isFullyGuessed("JAVA", "JAV"));
    assertFalse(WordMask.isFullyGuessed("JAVA", "JA"));
    assertTrue(WordMask.isFullyGuessed("", ""));
  }
}
