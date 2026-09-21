package edu.course.games.factoryrobot.domain;

/** Неверная команда, пустой текст или превышение лимита программы. */
public final class ProgramFormatException extends IllegalArgumentException {
  private final int offset;

  public ProgramFormatException(String message, int offset) {
    super(message);
    this.offset = offset;
  }

  /** Индекс ошибочного символа от нуля; для пустой программы — 0, для превышения лимита — 60. */
  public int offset() {
    return offset;
  }
}
