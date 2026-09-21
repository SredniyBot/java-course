package edu.course.games.utf8radio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void everyBoundaryOfFourByteCharacterIsStrict() {
    byte[] packet = {(byte) 0xf0, (byte) 0x9f, (byte) 0x90, (byte) 0xb1, (byte) 0xff};
    assertEquals("", Utf8Codec.decodePrefix(packet, 0));
    for (int n = 1; n < 4; n++) assertEquals("<ошибка>", Utf8Codec.decodePrefix(packet, n));
    assertEquals("🐱", Utf8Codec.decodePrefix(packet, 4));
    assertEquals("<ошибка>", Utf8Codec.decodePrefix(packet, 5));
    for (int i = -128; i <= 127; i++)
      assertEquals(i < 0 ? i + 256 : i, Utf8Codec.toUnsigned((byte) i));
  }
}
