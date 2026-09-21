package edu.course.games.balloonrescue.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordMaskTest {
  @Test
  void maskMatchesPublishedExamples() {

    assertTrue(WordMask.revealGuessedLetters("JAVA", "A").equals("_ A _ A "));
  }

  @Test
  void solvedMatchesPublishedExamples() {

    assertTrue(WordMask.isFullyGuessed("JAVA", "JAV"));
    assertFalse(WordMask.isFullyGuessed("JAVA", "JA"));
  }
}
