package edu.course.games.factoryrobot.domain;

/** Ошибка чтения или закрытия источника; исходная IOException доступна через getCause(). */
public final class ProgramLoadException extends Exception {
  public ProgramLoadException(String message, java.io.IOException cause) {
    super(message, cause);
  }
}
