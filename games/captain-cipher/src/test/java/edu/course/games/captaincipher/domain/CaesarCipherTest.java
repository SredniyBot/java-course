package edu.course.games.captaincipher.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CaesarCipherTest {
  @Test
  void shiftMatchesPublishedExamples() {

    assertTrue(CaesarCipher.shiftUppercase('Z', 1) == 'A');
    assertTrue(CaesarCipher.shiftUppercase('A', -1) == 'Z');
    assertTrue(CaesarCipher.shiftUppercase('!', 3) == '!');
  }

  @Test
  void cipherMatchesPublishedExamples() {

    assertTrue(CaesarCipher.encode("ZOO!", 1).equals("APP!"));
    assertTrue(CaesarCipher.encode(CaesarCipher.encode("MOON", 7), -7).equals("MOON"));
  }
}
