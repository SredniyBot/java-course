package edu.course.games.wordrain.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void normalizingTwiceIsStableAndEmptyPrefixIsValid() {
    assertEquals("i", WordRules.normalizeInput(" I "));
    for (String s : new String[] {"  Cat ", "", "A B", " SUN "})
      assertEquals(
          WordRules.normalizeInput(s), WordRules.normalizeInput(WordRules.normalizeInput(s)));
    assertTrue(WordRules.isPrefix("cat", ""));
    assertFalse(WordRules.isPrefix("cat", "cats"));
  }
}
