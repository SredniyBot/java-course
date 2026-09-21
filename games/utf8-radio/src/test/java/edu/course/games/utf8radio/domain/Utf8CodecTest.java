package edu.course.games.utf8radio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Utf8CodecTest {
  @Test
  void unsignedMatchesPublishedExamples() {

    assertEquals(208, Utf8Codec.toUnsigned((byte) 0xD0));
    assertEquals(0, Utf8Codec.toUnsigned((byte) 0));
  }

  @Test
  void decodeMatchesPublishedExamples() {

    assertTrue(Utf8Codec.decodePrefix(new byte[] {(byte) 0xD0, (byte) 0xAF, 0}, 2).equals("Я"));
    assertTrue(Utf8Codec.decodePrefix(new byte[] {(byte) 0xD0}, 1).equals("<ошибка>"));
  }
}
