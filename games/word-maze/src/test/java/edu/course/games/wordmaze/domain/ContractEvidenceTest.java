package edu.course.games.wordmaze.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void numericalNeighborAcrossRowIsNotGeometricalNeighbor() {
    assertFalse(WordPathRules.areSideNeighbors(2, 3, 3));
    assertTrue(WordPathRules.areSideNeighbors(2, 5, 3));
    char[][] b = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    assertEquals("CF", WordPathRules.readPath(b, new int[] {2, 5, 999}, 2));
    assertEquals("", WordPathRules.readPath(b, new int[] {999}, 0));
  }
}
