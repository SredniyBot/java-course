package edu.course.app;

import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameSession;
import java.util.function.Function;

/** Immutable catalog metadata, separate from live game sessions. */
public record GameEntry(
    int number,
    String slug,
    String title,
    String topic,
    Function<GameSession, DesktopGame> factory) {}
