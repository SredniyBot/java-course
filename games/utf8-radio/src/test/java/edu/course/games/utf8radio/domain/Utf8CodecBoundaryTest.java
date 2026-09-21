package edu.course.games.utf8radio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Utf8CodecBoundaryTest {
  @ParameterizedTest
  @CsvSource({"-128,128", "-1,255", "0,0", "127,127"})
  void unsignedPreservesEightBits(byte value, int expected) {
    assertEquals(expected, Utf8Codec.toUnsigned(value));
  }

  @Test
  void decoderHonorsCountAndRejectsMalformedSequences() {
    byte[] packet = {65, (byte) 255};
    assertEquals("A", Utf8Codec.decodePrefix(packet, 1));
    assertEquals("<ошибка>", Utf8Codec.decodePrefix(packet, 2));
    assertEquals("", Utf8Codec.decodePrefix(packet, 0));
    assertEquals("<ошибка>", Utf8Codec.decodePrefix(new byte[] {(byte) 0xD0}, 1));
    assertEquals("<ошибка>", Utf8Codec.decodePrefix(new byte[] {(byte) 0xC0, (byte) 0xAF}, 2));
    assertEquals("Я", Utf8Codec.decodePrefix(new byte[] {(byte) 0xD0, (byte) 0xAF}, 2));
  }
}
