package edu.course.platform.desktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public final class GameDrawing {
  private GameDrawing() {}

  public static final Color INK = new Color(16, 24, 39),
      SLATE = new Color(48, 64, 86),
      BLUE = new Color(38, 86, 137),
      CYAN = new Color(55, 207, 218),
      GOLD = new Color(250, 191, 73),
      GREEN = new Color(53, 169, 121),
      RED = new Color(210, 79, 99),
      WHITE = new Color(234, 241, 250);
  private static final java.util.List<Color> PALETTE =
      java.util.List.of(SLATE, BLUE, GREEN, RED, new Color(151, 102, 204));

  public static Color palette(int index) {
    return PALETTE.get(index);
  }

  public static void box(Graphics2D g, int x, int y, int w, int h, Color c) {
    g.setColor(c);
    g.fillRoundRect(x, y, w, h, 10, 10);
  }

  public static void circle(Graphics2D g, int x, int y, int radius, Color c) {
    g.setColor(c);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }

  public static void text(Graphics2D g, String s, int x, int y, int size, Color c) {
    g.setFont(new Font("SansSerif", Font.BOLD, size));
    g.setColor(c);
    g.drawString(s, x, y);
  }

  public static void wrapped(Graphics2D g, String s, int x, int y, int width, int size, Color c) {
    g.setFont(new Font("SansSerif", Font.PLAIN, size));
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
    g.setColor(SLATE);
    for (int i = 0; i <= w; i++) g.drawLine(x + i * size, y, x + i * size, y + h * size);
    for (int i = 0; i <= h; i++) g.drawLine(x, y + i * size, x + w * size, y + i * size);
  }
}
