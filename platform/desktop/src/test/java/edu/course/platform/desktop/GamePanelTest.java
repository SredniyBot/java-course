package edu.course.platform.desktop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Graphics2D;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.Test;

class GamePanelTest {
  private static class Probe implements DesktopGame {
    int steps;
    final GameSession context;

    Probe(GameSession context) {
      this.context = context;
    }

    public GameDescriptor info() {
      return new GameDescriptor("Probe", "goal", "keys");
    }

    public void reset() {
      steps = 0;
    }

    public void render(Graphics2D g) {}

    public void update(double seconds) {
      steps++;
    }
  }

  @Test
  void pauseFinishAndRestartControlCallbacks() throws Exception {
    SwingUtilities.invokeAndWait(
        () -> {
          AtomicReference<Probe> ref = new AtomicReference<>();
          GamePanel host =
              new GamePanel(
                  c -> {
                    var game = new Probe(c);
                    ref.set(game);
                    return game;
                  },
                  9);
          host.restart();
          host.tick();
          assertEquals(1, ref.get().steps);
          host.press(117);
          host.tick();
          assertEquals(1, ref.get().steps);
          host.press(117);
          host.tick();
          assertEquals(2, ref.get().steps);
          ref.get().context.end("done");
          host.tick();
          assertEquals(2, ref.get().steps);
          host.press(116);
          assertFalse(host.done());
          assertEquals(0, ref.get().steps);
        });
  }

  @Test
  void sessionsDoNotShareKeysScoresOrRandom() {
    GameSession a = new GameSession(19), b = new GameSession(19);
    a.key(37, true);
    a.addScore(2);
    assertEquals(0, b.held(37));
    assertEquals(0, b.score());
    int first = a.random().nextInt();
    assertEquals(first, b.random().nextInt());
    a.reset();
    assertEquals(first, a.random().nextInt());
    assertEquals(0, a.held(37));
    assertEquals(0, a.score());
  }

  @Test
  void unfinishedExerciseStopsUpdatesButRestartClearsError() throws Exception {
    SwingUtilities.invokeAndWait(
        () -> {
          GamePanel host =
              new GamePanel(
                  c ->
                      new Probe(c) {
                        @Override
                        public void update(double dt) {
                          throw new UnsupportedOperationException("exercise");
                        }
                      },
                  2);
          host.restart();
          host.tick();
          assertTrue(host.problem().contains("exercise"));
          host.restart();
          assertEquals("", host.problem());
        });
  }
}
