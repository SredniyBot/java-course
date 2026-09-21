package edu.course.games.captaincipher.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

class CaesarCipherPropertiesTest {
  @Test
  void everyIntOffsetMatchesLongArithmeticOracle() {
    Random random = new Random(23001);
    for (int trial = 0; trial < 10000; trial++) {
      int offset = random.nextInt();
      char ch = (char) ('A' + random.nextInt(26));
      char expected = (char) ('A' + Math.floorMod((long) ch - 'A' + offset, 26L));
      assertEquals(
          expected, CaesarCipher.shiftUppercase(ch, offset), "char=" + ch + ", offset=" + offset);
    }
  }
}
