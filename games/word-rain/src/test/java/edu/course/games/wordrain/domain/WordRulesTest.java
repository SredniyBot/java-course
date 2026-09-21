package edu.course.games.wordrain.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordRulesTest {
  @Test
  void normalizeMatchesPublishedExamples() {

    assertTrue(WordRules.normalizeInput("  MOON ").equals("moon"));
  }

  @Test
  void prefixMatchesPublishedExamples() {

    assertTrue(WordRules.isPrefix("moon", ""));
    assertFalse(WordRules.isPrefix("moon", "moons"));
  }
}
