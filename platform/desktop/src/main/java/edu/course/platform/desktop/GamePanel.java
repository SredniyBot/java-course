package edu.course.platform.desktop;

import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.GOLD;
import static edu.course.platform.desktop.GameDrawing.INK;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.text;
import static edu.course.platform.desktop.GameDrawing.wrapped;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;
import javax.swing.JPanel;
import javax.swing.Timer;

/** Готовая оболочка Swing. Студентам достаточно менять GameLogic своей игры. */
public final class GamePanel extends JPanel {
  private final DesktopGame game;
  private final GameSession context;
  private String error = "";
  private final String title, goal, controls;
  private boolean paused;
  private final Timer timer;

  public GamePanel(Function<GameSession, DesktopGame> factory, long seed) {
    context = new GameSession(seed);
    game = java.util.Objects.requireNonNull(factory.apply(context));
    GameDescriptor info = game.info();
    title = info.title();
    goal = info.goal();
    controls = info.controls();
    setPreferredSize(new Dimension(960, 720));
    setFocusable(true);
    setBackground(INK);
    timer = new Timer(20, e -> tick());
    addKeyListener(
        new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            press(e.getKeyCode());
          }

          public void keyReleased(KeyEvent e) {
            release(e.getKeyCode());
          }

          public void keyTyped(KeyEvent e) {
            type(e.getKeyChar());
          }
        });
    addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent e) {
            requestFocusInWindow();
            tap(e.getX(), e.getY(), e.getButton());
          }
        });
    addFocusListener(
        new FocusAdapter() {
          public void focusLost(FocusEvent e) {
            context.clearKeys();
          }
        });
  }

  private void guard(Runnable action) {
    try {
      action.run();
    } catch (UnsupportedOperationException ex) {
      error = "Нужно реализовать: " + ex.getMessage();
    } catch (RuntimeException ex) {
      error = ex.getClass().getSimpleName() + ": " + ex.getMessage();
    }
  }

  public void restart() {
    context.reset();
    paused = false;
    error = "";
    guard(game::reset);
    repaint();
  }

  public void tick() {
    if (!paused && !context.finished() && error.isEmpty()) guard(() -> game.update(.02));
    repaint();
  }

  public void press(int key) {
    if (key == KeyEvent.VK_F5) {
      restart();
      return;
    }
    if (key == KeyEvent.VK_F6) {
      paused = !paused;
      return;
    }
    context.key(key, true);
    if (!context.finished() && !paused && error.isEmpty()) guard(() -> game.onKeyPressed(key));
    repaint();
  }

  public void release(int key) {
    context.key(key, false);
  }

  public void type(char ch) {
    if (!context.finished() && !paused && error.isEmpty() && !Character.isISOControl(ch))
      guard(() -> game.onCharacterTyped(ch));
    repaint();
  }

  public void tap(int x, int y, int button) {
    if (!context.finished() && !paused && error.isEmpty())
      guard(() -> game.onMousePressed(x, y, button));
    repaint();
  }

  public String problem() {
    return error;
  }

  public boolean done() {
    return context.finished();
  }

  public String message() {
    return context.status();
  }

  @Override
  protected void paintComponent(Graphics base) {
    super.paintComponent(base);
    Graphics2D g = (Graphics2D) base.create();
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setRenderingHint(
        RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    box(g, 0, 0, 960, 6, CYAN);
    text(g, title, 30, 43, 26, WHITE);
    wrapped(g, goal, 30, 72, 900, 17, new Color(164, 188, 214));
    try {
      game.render(g);
    } catch (RuntimeException ex) {
      error = ex.toString();
    }
    box(g, 0, 620, 960, 100, new Color(23, 35, 52));
    wrapped(
        g,
        context.status().isEmpty() ? "Играйте и проверяйте свою реализацию" : context.status(),
        30,
        649,
        900,
        19,
        context.finished() ? GOLD : WHITE);
    wrapped(
        g,
        controls + "  |  F5 — заново  |  F6 — пауза",
        30,
        690,
        900,
        15,
        new Color(164, 188, 214));
    if (paused) {
      box(g, 290, 285, 380, 100, INK);
      text(g, "ПАУЗА · F6", 370, 347, 28, GOLD);
    }
    if (!error.isEmpty()) {
      box(g, 90, 270, 780, 175, new Color(70, 36, 48));
      wrapped(g, error, 115, 309, 730, 21, WHITE);
      wrapped(
          g,
          "Откройте GameLogic.java, заполните метод и перезапустите программу.",
          115,
          395,
          730,
          18,
          GOLD);
    }
    g.dispose();
  }

  public String title() {
    return title;
  }

  public void start() {
    timer.start();
  }

  public void stop() {
    timer.stop();
  }
}
