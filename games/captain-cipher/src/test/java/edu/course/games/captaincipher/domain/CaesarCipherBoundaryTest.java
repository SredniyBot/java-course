package edu.course.games.captaincipher.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CaesarCipherBoundaryTest {
  @ParameterizedTest
  @CsvSource({"Z,1,A", "A,-1,Z", "!,7,!", "Z,2147483647,W", "A,-2147483648,C"})
  void shiftHandlesNegativeAndOverflowingOffsets(char input, int offset, char expected) {
    assertEquals(expected, CaesarCipher.shiftUppercase(input, offset));
  }

  @Test
  void cipherPreservesNonAlphabetCharacters() {
    assertEquals("BA-я😀", CaesarCipher.encode("AZ-я😀", 1));
    assertEquals("", CaesarCipher.encode("", 7));
  }
}
