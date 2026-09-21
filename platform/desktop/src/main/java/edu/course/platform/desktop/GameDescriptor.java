package edu.course.platform.desktop;

import java.util.Objects;

public record GameDescriptor(String title, String goal, String controls) {
  public GameDescriptor {
    Objects.requireNonNull(title);
    Objects.requireNonNull(goal);
    Objects.requireNonNull(controls);
  }
}
