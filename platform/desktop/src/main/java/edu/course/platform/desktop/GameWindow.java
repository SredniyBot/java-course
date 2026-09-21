package edu.course.platform.desktop;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Function;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Creates one independent window; the panel owns its timer and input lifecycle. */
public final class GameWindow {
  private GameWindow() {}

  public static void open(Function<GameSession, DesktopGame> factory) {
    SwingUtilities.invokeLater(
        () -> {
          GamePanel panel = new GamePanel(factory, 2026);
          panel.restart();
          JFrame frame = new JFrame(panel.title());
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frame.setContentPane(panel);
          frame.pack();
          frame.setResizable(false);
          frame.setLocationRelativeTo(null);
          frame.addWindowListener(
              new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent event) {
                  panel.stop();
                }
              });
          frame.setVisible(true);
          panel.requestFocusInWindow();
          panel.start();
        });
  }
}
