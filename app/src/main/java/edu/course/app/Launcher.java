package edu.course.app;

import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameSession;
import edu.course.platform.desktop.GameWindow;
import java.util.List;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Launcher {
  private Launcher() {}

  private record Entry(String label, Function<GameSession, DesktopGame> factory) {}

  public static void main(String[] args) {
    List<Entry> games =
        List.of(
            new Entry("01. Звёздный курьер", edu.course.games.starcourier.ui.StarCourierGame::new),
            new Entry("02. Лунная доставка", edu.course.games.moonlander.ui.MoonLanderGame::new),
            new Entry("03. Облачный прыгун", edu.course.games.cloudjumper.ui.CloudJumperGame::new),
            new Entry(
                "04. Пинг-понг с порталом", edu.course.games.portalpong.ui.PortalPongGame::new),
            new Entry("05. Кирпичный сад", edu.course.games.brickgarden.ui.BrickGardenGame::new),
            new Entry("06. Змейка-курьер", edu.course.games.couriersnake.ui.CourierSnakeGame::new),
            new Entry(
                "07. Тетрис: стройка на Луне",
                edu.course.games.lunartetris.ui.LunarTetrisGame::new),
            new Entry("08. Сапёр на Марсе", edu.course.games.marsmines.ui.MarsMinesGame::new),
            new Entry("09. Котики-близнецы", edu.course.games.memorycats.ui.MemoryCatsGame::new),
            new Entry("10. Словопад", edu.course.games.wordrain.ui.WordRainGame::new),
            new Entry(
                "11. Спасите воздушный шар",
                edu.course.games.balloonrescue.ui.BalloonRescueGame::new),
            new Entry("12. Буквенный лабиринт", edu.course.games.wordmaze.ui.WordMazeGame::new),
            new Entry(
                "13. Мастерская симметрии",
                edu.course.games.pixelsymmetry.ui.PixelSymmetryGame::new),
            new Entry("14. Цветной прилив", edu.course.games.colorflood.ui.ColorFloodGame::new),
            new Entry("15. Ночной город", edu.course.games.lightsout.ui.LightsOutGame::new),
            new Entry("16. Котики 256", edu.course.games.cats256.ui.Cats256Game::new),
            new Entry(
                "17. Склад лунного сыра", edu.course.games.moonsokoban.ui.MoonSokobanGame::new),
            new Entry("18. Лазерная почта", edu.course.games.lasermail.ui.LaserMailGame::new),
            new Entry("19. Холст времени", edu.course.games.timecanvas.ui.TimeCanvasGame::new),
            new Entry(
                "20. Космическая кухня", edu.course.games.spacekitchen.ui.SpaceKitchenGame::new),
            new Entry(
                "21. Unicode-сафари", edu.course.games.unicodesafari.ui.UnicodeSafariGame::new),
            new Entry("22. Радио UTF-8", edu.course.games.utf8radio.ui.Utf8RadioGame::new),
            new Entry(
                "23. Шифр капитана", edu.course.games.captaincipher.ui.CaptainCipherGame::new),
            new Entry(
                "24. Баллистическая почта",
                edu.course.games.ballisticmail.ui.BallisticMailGame::new),
            new Entry(
                "25. Робот на заводе", edu.course.games.factoryrobot.ui.FactoryRobotGame::new));
    if (args.length == 1) {
      int number;
      try {
        number = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("DesktopGame number must be 1..25", e);
      }
      if (number < 1 || number > games.size())
        throw new IllegalArgumentException("DesktopGame number must be 1..25");
      GameWindow.open(games.get(number - 1).factory());
      return;
    }
    if (args.length > 1)
      throw new IllegalArgumentException("Usage: java -jar launcher.jar [1..25]");
    SwingUtilities.invokeLater(
        () -> {
          JFrame window = new JFrame("Java — 25 игр");
          JPanel panel = new JPanel(new java.awt.GridLayout(0, 2, 8, 8));
          for (Entry entry : games) {
            JButton button = new JButton(entry.label());
            button.addActionListener(e -> GameWindow.open(entry.factory()));
            panel.add(button);
          }
          window.setContentPane(panel);
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          window.pack();
          window.setLocationRelativeTo(null);
          window.setVisible(true);
        });
  }
}
