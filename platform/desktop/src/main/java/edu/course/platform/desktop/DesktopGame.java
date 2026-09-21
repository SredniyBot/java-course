package edu.course.platform.desktop;

import java.awt.Graphics2D;

/** A game has no window or timer. Callbacks are owned by the host on the EDT. */
public interface DesktopGame {
  GameDescriptor info();

  void reset();

  void render(Graphics2D graphics);

  default void update(double seconds) {}

  default void onKeyPressed(int key) {}

  default void onMousePressed(int x, int y, int button) {}

  default void onCharacterTyped(char character) {}
}
