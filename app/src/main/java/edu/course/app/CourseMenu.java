package edu.course.app;

import static edu.course.platform.desktop.GameDrawing.BORDER;
import static edu.course.platform.desktop.GameDrawing.CYAN;
import static edu.course.platform.desktop.GameDrawing.INK;
import static edu.course.platform.desktop.GameDrawing.MUTED;
import static edu.course.platform.desktop.GameDrawing.SURFACE;
import static edu.course.platform.desktop.GameDrawing.WHITE;
import static edu.course.platform.desktop.GameDrawing.box;
import static edu.course.platform.desktop.GameDrawing.font;
import static edu.course.platform.desktop.GameDrawing.prepare;
import static edu.course.platform.desktop.GameDrawing.text;

import edu.course.platform.desktop.GamePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/** Catalog screen; thumbnails never start game timers or retain running sessions. */
public final class CourseMenu extends JPanel {
  private final List<GameEntry> entries;
  private final JPanel cards = new JPanel(new GridLayout(0, 3, 16, 16));
  private final JLabel count = new JLabel();
  private final JTextField search = new JTextField();
  private final Consumer<GameEntry> launch;
  private final List<BufferedImage> thumbnails;

  public CourseMenu(List<GameEntry> entries, Consumer<GameEntry> launch) {
    this.entries = List.copyOf(entries);
    this.launch = launch;
    thumbnails = this.entries.stream().map(CourseMenu::thumbnail).toList();
    setLayout(new BorderLayout(0, 20));
    setBorder(BorderFactory.createEmptyBorder(28, 32, 20, 32));
    setBackground(INK);
    JPanel header = new JPanel(new BorderLayout(0, 16));
    header.setOpaque(false);
    JPanel title = new JPanel(new GridLayout(0, 1, 0, 6));
    title.setOpaque(false);
    title.add(label("JAVA COURSE   /   25 ПРАКТИК", 12, MUTED));
    title.add(label("Выберите свою следующую игру", 30, WHITE));
    title.add(label("Запустите сцену, изучите механику, восстановите правила.", 15, MUTED));
    header.add(title, BorderLayout.NORTH);
    JPanel filters = new JPanel(new BorderLayout(18, 0));
    filters.setOpaque(false);
    search.setFont(font(16, false));
    search.setForeground(WHITE);
    search.setBackground(SURFACE);
    search.setCaretColor(CYAN);
    search.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)));
    search.setToolTipText("Номер, название или тема игры");
    search.getAccessibleContext().setAccessibleName("Поиск игры по номеру, названию или теме");
    JPanel searchGroup = new JPanel(new BorderLayout(10, 0));
    searchGroup.setOpaque(false);
    searchGroup.add(label("Поиск", 14, MUTED), BorderLayout.WEST);
    searchGroup.add(search, BorderLayout.CENTER);
    filters.add(searchGroup, BorderLayout.CENTER);
    count.setForeground(MUTED);
    count.setFont(font(13, false));
    filters.add(count, BorderLayout.EAST);
    header.add(filters, BorderLayout.SOUTH);
    add(header, BorderLayout.NORTH);
    cards.setOpaque(false);
    JPanel topAligned = new JPanel(new BorderLayout());
    topAligned.setOpaque(false);
    topAligned.add(cards, BorderLayout.NORTH);
    JScrollPane scroll =
        new JScrollPane(
            topAligned,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBorder(BorderFactory.createEmptyBorder());
    scroll.getViewport().setBackground(INK);
    scroll.getVerticalScrollBar().setUnitIncrement(26);
    scroll.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
    scroll
        .getVerticalScrollBar()
        .setUI(
            new javax.swing.plaf.basic.BasicScrollBarUI() {
              @Override
              protected void configureScrollBarColors() {
                thumbColor = edu.course.platform.desktop.GameDrawing.SLATE;
                trackColor = INK;
              }

              private JButton emptyArrow() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
              }

              @Override
              protected JButton createDecreaseButton(int orientation) {
                return emptyArrow();
              }

              @Override
              protected JButton createIncreaseButton(int orientation) {
                return emptyArrow();
              }
            });
    add(scroll, BorderLayout.CENTER);
    add(
        label(
            "Задание: README в папке игры     •     F1 — помощь в игре     •     Java 21",
            13,
            MUTED),
        BorderLayout.SOUTH);
    search
        .getDocument()
        .addDocumentListener(
            new DocumentListener() {
              public void insertUpdate(DocumentEvent e) {
                filter();
              }

              public void removeUpdate(DocumentEvent e) {
                filter();
              }

              public void changedUpdate(DocumentEvent e) {
                filter();
              }
            });
    search.addActionListener(
        e -> {
          if (cards.getComponentCount() > 0 && cards.getComponent(0) instanceof JButton button)
            button.doClick();
        });
    filter();
  }

  public void setQuery(String value) {
    search.setText(value);
  }

  public int visibleGames() {
    return (int)
        java.util.Arrays.stream(cards.getComponents()).filter(JButton.class::isInstance).count();
  }

  private void filter() {
    String query = search.getText().strip().toLowerCase(Locale.ROOT);
    cards.removeAll();
    for (int i = 0; i < entries.size(); i++) {
      GameEntry entry = entries.get(i);
      if ((entry.title() + " " + entry.topic() + " " + entry.slug() + " " + entry.number())
          .toLowerCase(Locale.ROOT)
          .contains(query)) cards.add(new GameCard(entry, thumbnails.get(i)));
    }
    int shown = cards.getComponentCount();
    count.setText(shown + " / " + entries.size() + " игр");
    if (shown == 0) cards.add(label("Ничего не найдено", 16, MUTED));
    cards.revalidate();
    cards.repaint();
  }

  private static JLabel label(String value, int size, Color color) {
    JLabel label = new JLabel(value);
    label.setFont(font(size, size >= 28));
    label.setForeground(color);
    return label;
  }

  private static BufferedImage thumbnail(GameEntry entry) {
    GamePanel scene = new GamePanel(entry.factory(), 2026);
    scene.setSize(960, 720);
    scene.restart();
    BufferedImage source = new BufferedImage(960, 720, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = source.createGraphics();
    try {
      scene.paint(g);
    } finally {
      g.dispose();
    }
    BufferedImage thumb = new BufferedImage(288, 140, BufferedImage.TYPE_INT_RGB);
    g = thumb.createGraphics();
    try {
      prepare(g);
      g.setRenderingHint(
          java.awt.RenderingHints.KEY_INTERPOLATION,
          java.awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      g.drawImage(source, 0, 0, 288, 140, 0, 115, 960, 615, null);
    } finally {
      g.dispose();
    }
    return thumb;
  }

  private final class GameCard extends JButton {
    private final GameEntry entry;
    private final BufferedImage thumbnail;

    private GameCard(GameEntry entry, BufferedImage thumbnail) {
      this.entry = entry;
      this.thumbnail = thumbnail;
      setPreferredSize(new Dimension(294, 226));
      setBorderPainted(false);
      setContentAreaFilled(false);
      setFocusPainted(false);
      setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      setToolTipText("Открыть игру · задание: games/" + entry.slug() + "/README.md");
      getAccessibleContext()
          .setAccessibleName(entry.number() + ". " + entry.title() + ". Открыть игру");
      addActionListener(e -> launch.accept(entry));
    }

    @Override
    protected void paintComponent(Graphics base) {
      Graphics2D g = (Graphics2D) base.create();
      try {
        prepare(g);
        boolean active = getModel().isRollover() || hasFocus();
        box(g, 0, 0, getWidth() - 2, getHeight() - 2, active ? new Color(35, 48, 62) : SURFACE);
        java.awt.Shape inheritedClip = g.getClip();
        g.clipRect(8, 8, getWidth() - 18, 140);
        g.drawImage(thumbnail, 8, 8, getWidth() - 18, 140, null);
        g.setClip(inheritedClip);
        if (active) {
          g.setColor(CYAN);
          g.drawRoundRect(1, 1, getWidth() - 4, getHeight() - 4, 14, 14);
        }
        text(g, String.format(Locale.ROOT, "%02d", entry.number()), 15, 172, 12, CYAN);
        g.setFont(font(16, true));
        g.setColor(WHITE);
        String name = entry.title();
        while (g.getFontMetrics().stringWidth(name) > getWidth() - 60 && name.length() > 1)
          name = name.substring(0, name.length() - 1);
        if (!name.equals(entry.title())) name = name.stripTrailing() + "…";
        g.drawString(name, 46, 173);
        text(g, entry.topic(), 15, 198, 12, MUTED);
        text(g, "Открыть →  ·  " + entry.slug(), 15, 216, 11, active ? CYAN : MUTED);
      } finally {
        g.dispose();
      }
    }
  }
}
