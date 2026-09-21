package edu.course.games.captaincipher.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void longOracleCoversOverflowAndUnchangedCharacters() {
    for (int offset : new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, -27, -1, 0, 26, 27})
      for (char ch = 'A'; ch <= 'Z'; ch++) {
        char expected = (char) ('A' + Math.floorMod((long) ch - 'A' + offset, 26L));
        assertEquals(expected, CaesarCipher.shiftUppercase(ch, offset));
      }
    assertEquals("a🐱!", CaesarCipher.encode("a🐱!", Integer.MIN_VALUE));
  }
}
