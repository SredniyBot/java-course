package edu.course.games.utf8radio.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseContractTest {

  @Test
  void decodesOnlyRequestedBytesAndDoesNotChangeThem() throws Exception {
    byte[] packet = {(byte) 0xD0, (byte) 0xAF, (byte) 0xFF};
    assertEquals("Я", Utf8Codec.decodeStrict(packet, 2));
    assertEquals("", Utf8Codec.decodeStrict(packet, 0));
    assertArrayEquals(new byte[] {(byte) 0xD0, (byte) 0xAF, (byte) 0xFF}, packet);
    assertEquals(
        "A🐱", Utf8Codec.decodeStrict("A🐱".getBytes(java.nio.charset.StandardCharsets.UTF_8), 5));
  }

  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("brokenPackets")
  void rejectsMalformedAndTruncatedUtf8(byte[] packet) {
    assertThrows(
        java.nio.charset.CharacterCodingException.class,
        () -> Utf8Codec.decodeStrict(packet, packet.length));
    assertEquals("<ошибка>", Utf8Codec.decodePrefix(packet, packet.length));
  }

  static java.util.stream.Stream<byte[]> brokenPackets() {
    return java.util.stream.Stream.of(
        new byte[] {(byte) 0xD0},
        new byte[] {(byte) 0x80},
        new byte[] {(byte) 0xC0, (byte) 0xAF},
        new byte[] {(byte) 0xED, (byte) 0xA0, (byte) 0x80},
        new byte[] {(byte) 0xF4, (byte) 0x90, (byte) 0x80, (byte) 0x80});
  }

  @Test
  void argumentErrorsAreNotConvertedIntoRadioErrors() {
    for (int count : new int[] {-1, 2}) {
      assertThrows(
          IndexOutOfBoundsException.class, () -> Utf8Codec.decodeStrict(new byte[] {65}, count));
      assertThrows(
          IndexOutOfBoundsException.class, () -> Utf8Codec.decodePrefix(new byte[] {65}, count));
    }
    assertThrows(NullPointerException.class, () -> Utf8Codec.decodeStrict(null, 0));
  }
}
