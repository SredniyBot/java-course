package edu.course.platform.desktop;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/** Shared visual language for all games: calm surfaces, clear accents and legible text. */
public final class GameDrawing {
  private GameDrawing() {}

  public static final Color INK = new Color(18, 24, 34),
      SURFACE = new Color(26, 34, 47),
      SLATE = new Color(45, 58, 75),
      BLUE = new Color(65, 105, 145),
      CYAN = new Color(100, 213, 195),
      GOLD = new Color(239, 193, 111),
      GREEN = new Color(69, 153, 128),
      RED = new Color(187, 93, 111),
      WHITE = new Color(233, 237, 241),
      MUTED = new Color(153, 168, 186),
      BORDER = new Color(57, 71, 89);
  private static final java.util.List<Color> PALETTE =
      java.util.List.of(SLATE, BLUE, GREEN, RED, new Color(135, 113, 173));

  public static Color palette(int index) {
    return PALETTE.get(index);
  }

  public static Font font(int size, boolean strong) {
    return new Font("SansSerif", strong ? Font.BOLD : Font.PLAIN, size);
  }

  public static void prepare(Graphics2D g) {
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setRenderingHint(
        RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
  }

  public static void box(Graphics2D g, int x, int y, int w, int h, Color c) {
    int radius = Math.max(3, Math.min(14, Math.min(w, h) / 4));
    if (w > 35 && h > 35) {
      g.setColor(new Color(0, 0, 0, 32));
      g.fillRoundRect(x, y + 2, w, h, radius, radius);
    }
    Color highlight =
        new Color(
            Math.min(255, c.getRed() + 7),
            Math.min(255, c.getGreen() + 7),
            Math.min(255, c.getBlue() + 7),
            c.getAlpha());
    g.setPaint(new GradientPaint(x, y, highlight, x, y + h, c));
    g.fillRoundRect(x, y, w, h, radius, radius);
    g.setColor(new Color(255, 255, 255, 22));
    g.setStroke(new BasicStroke(1));
    g.drawRoundRect(x, y, Math.max(0, w - 1), Math.max(0, h - 1), radius, radius);
    g.setColor(c);
  }

  public static void circle(Graphics2D g, int x, int y, int radius, Color c) {
    g.setColor(new Color(0, 0, 0, 32));
    g.fillOval(x - radius, y - radius + 2, radius * 2, radius * 2);
    g.setColor(c);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    g.setColor(new Color(255, 255, 255, 55));
    g.fillOval(x - radius / 2, y - radius / 2, Math.max(2, radius / 2), Math.max(2, radius / 2));
  }

  public static void text(Graphics2D g, String s, int x, int y, int size, Color c) {
    g.setFont(font(size, size >= 28));
    g.setColor(c);
    g.drawString(s, x, y);
  }

  public static void centered(
      Graphics2D g, String s, int x, int y, int w, int h, int size, Color c) {
    g.setFont(font(size, true));
    g.setColor(c);
    var fm = g.getFontMetrics();
    g.drawString(s, x + (w - fm.stringWidth(s)) / 2, y + (h - fm.getHeight()) / 2 + fm.getAscent());
  }

  public static void wrapped(Graphics2D g, String s, int x, int y, int width, int size, Color c) {
    g.setFont(font(size, false));
    g.setColor(c);
    String line = "";
    for (String word : s.split(" ")) {
      String next = line.isEmpty() ? word : line + " " + word;
      if (!line.isEmpty() && g.getFontMetrics().stringWidth(next) > width) {
        g.drawString(line, x, y);
        y += size + 5;
        line = word;
      } else line = next;
    }
    g.drawString(line, x, y);
  }

  public static void grid(Graphics2D g, int x, int y, int w, int h, int size) {
    g.setColor(new Color(255, 255, 255, 4));
    g.fillRoundRect(x, y, w * size, h * size, 12, 12);
    g.setStroke(new BasicStroke(1));
    g.setColor(new Color(130, 155, 180, 40));
    for (int i = 0; i <= w; i++) g.drawLine(x + i * size, y, x + i * size, y + h * size);
    for (int i = 0; i <= h; i++) g.drawLine(x, y + i * size, x + w * size, y + i * size);
  }
}
