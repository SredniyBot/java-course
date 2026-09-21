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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;
import javax.swing.JPanel;
import javax.swing.Timer;

/** Готовая оболочка Swing. Учебные методы находятся в domain своей игры. */
public final class GamePanel extends JPanel {
  private final DesktopGame game;
  private final GameSession context;
  private String error = "";
  private final String title, goal, controls;
  private boolean paused;
  private boolean help;
  private final Timer timer;

  public GamePanel(Function<GameSession, DesktopGame> factory, long seed) {
    context = new GameSession(seed);
    game = java.util.Objects.requireNonNull(context.preview().call(() -> factory.apply(context)));
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
            paused = true;
            repaint();
            context.clearKeys();
          }
        });
  }

  private void guard(Runnable action) {
    try {
      context.preview().run(action);
    } catch (UnsupportedOperationException ex) {
      error = "Нужно реализовать: " + ex.getMessage();
    } catch (RuntimeException ex) {
      error = ex.getClass().getSimpleName() + ": " + ex.getMessage();
    }
  }

  public void restart() {
    context.reset();
    paused = false;
    help = false;
    error = "";
    guard(game::reset);
    repaint();
  }

  public void tick() {
    if (!paused && !help && !context.finished() && error.isEmpty()) guard(() -> game.update(.02));
    repaint();
  }

  public void press(int key) {
    if (key == KeyEvent.VK_F1) {
      help = !help;
      context.clearKeys();
      repaint();
      return;
    }
    if (key == KeyEvent.VK_F5) {
      restart();
      return;
    }
    if (key == KeyEvent.VK_F6) {
      paused = !paused;
      context.clearKeys();
      repaint();
      return;
    }
    context.key(key, true);
    if (!context.finished() && !paused && !help && error.isEmpty())
      guard(() -> game.onKeyPressed(key));
    repaint();
  }

  public void release(int key) {
    context.key(key, false);
  }

  public void type(char ch) {
    if (!context.finished() && !paused && !help && error.isEmpty() && !Character.isISOControl(ch))
      guard(() -> game.onCharacterTyped(ch));
    repaint();
  }

  public void tap(int x, int y, int button) {
    if (!context.finished() && !paused && !help && error.isEmpty())
      guard(() -> game.onMousePressed(x, y, button));
    repaint();
  }

  public java.util.List<String> missingTasks() {
    return context.preview().missingTasks();
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
    try {
      GameDrawing.prepare(g);
      g.setPaint(new java.awt.GradientPaint(0, 0, GameDrawing.SURFACE, 960, 720, INK));
      g.fillRect(0, 0, 960, 720);
      text(g, "JAVA COURSE  /  ПРАКТИКА", 28, 26, 11, GameDrawing.MUTED);
      text(g, title, 28, 61, 28, WHITE);
      wrapped(g, goal, 28, 88, 900, 15, GameDrawing.MUTED);
      g.setColor(GameDrawing.BORDER);
      g.drawLine(28, 104, 932, 104);
      // Original board coordinates remain unchanged: visual refresh does not alter hit testing.
      context.preview().run(() -> game.render(g));
      g.setColor(GameDrawing.SURFACE);
      g.fillRoundRect(16, 624, 928, 86, 16, 16);
      String status =
          context.status().isEmpty() ? "Выберите действие — управление ниже." : context.status();
      wrapped(g, status, 32, 648, 880, 15, context.finished() ? GOLD : WHITE);
      wrapped(g, controls, 32, 674, 880, 13, GameDrawing.MUTED);
      text(g, "F5  Заново     F6  Пауза     F1  Помощь", 32, 698, 12, GameDrawing.MUTED);
      if (context.preview().incomplete()) {
        box(g, 710, 14, 222, 27, new Color(72, 59, 39));
        text(g, "ДЕМО · " + missingTasks().size() + " TODO  /  F1", 724, 33, 12, GOLD);
      }
      if (context.finished() && error.isEmpty()) {
        overlay(g, "Сценарий завершён", context.status(), "F5 — попробовать снова");
      }
      if (paused)
        overlay(
            g,
            "Пауза",
            "Игра остановлена. Можно спокойно изучить сцену.",
            "F6 — продолжить · F5 — заново");
      if (help) {
        g.setColor(new Color(8, 12, 18, 220));
        g.fillRect(0, 0, 960, 720);
        box(g, 130, 155, 700, 390, GameDrawing.SURFACE);
        text(g, "Управление и задание", 164, 200, 26, WHITE);
        wrapped(g, controls, 164, 241, 626, 18, GameDrawing.MUTED);
        wrapped(
            g,
            "Задание находится в README выбранной игры. После изменения Java-кода пересоберите проект и откройте окно заново.",
            164,
            300,
            626,
            16,
            GameDrawing.MUTED);
        String task =
            missingTasks().isEmpty()
                ? "Вызванных заглушек пока нет. Это не означает, что все задания решены."
                : "Не завершено: " + String.join(", ", missingTasks());
        wrapped(g, task, 164, 370, 626, 15, GOLD);
        text(g, "F1 — закрыть помощь     F5 — заново     F6 — пауза", 164, 503, 14, WHITE);
      }
      if (!error.isEmpty())
        overlay(
            g,
            "Нужно исправить метод",
            error,
            "Ошибка не заменена демо. Исправьте код и пересоберите проект.");
    } catch (RuntimeException ex) {
      error = ex.getClass().getSimpleName() + ": " + ex.getMessage();
      overlay(g, "Ошибка отрисовки", error, "Проверьте свой код и перезапустите окно.");
    } finally {
      g.dispose();
    }
  }

  private void overlay(Graphics2D g, String heading, String body, String hint) {
    g.setColor(new Color(8, 12, 18, 205));
    g.fillRect(0, 105, 960, 515);
    box(g, 120, 235, 720, 220, GameDrawing.SURFACE);
    text(g, heading, 156, 280, 27, WHITE);
    wrapped(g, body, 156, 320, 640, 17, GameDrawing.MUTED);
    wrapped(g, hint, 156, 411, 640, 14, CYAN);
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
