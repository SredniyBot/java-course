package edu.course.app;

import edu.course.platform.desktop.GameWindow;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class Launcher {
  private Launcher() {}

  public static List<GameEntry> games() {
    return List.of(
        new GameEntry(
            1,
            "star-courier",
            "Звёздный курьер",
            "Границы и геометрия",
            edu.course.games.starcourier.ui.StarCourierGame::new),
        new GameEntry(
            2,
            "moon-lander",
            "Лунная доставка",
            "Скорость и условия",
            edu.course.games.moonlander.ui.MoonLanderGame::new),
        new GameEntry(
            3,
            "cloud-jumper",
            "Облачный прыгун",
            "Состояние между кадрами",
            edu.course.games.cloudjumper.ui.CloudJumperGame::new),
        new GameEntry(
            4,
            "portal-pong",
            "Пинг-понг с порталом",
            "Свойства и симметрия",
            edu.course.games.portalpong.ui.PortalPongGame::new),
        new GameEntry(
            5,
            "brick-garden",
            "Кирпичный сад",
            "Индексы и интервалы",
            edu.course.games.brickgarden.ui.BrickGardenGame::new),
        new GameEntry(
            6,
            "courier-snake",
            "Змейка-курьер",
            "Массивы и мутация",
            edu.course.games.couriersnake.ui.CourierSnakeGame::new),
        new GameEntry(
            7,
            "lunar-tetris",
            "Тетрис: стройка на Луне",
            "Матрицы и копирование",
            edu.course.games.lunartetris.ui.LunarTetrisGame::new),
        new GameEntry(
            8,
            "mars-mines",
            "Сапёр на Марсе",
            "Границы и перебор",
            edu.course.games.marsmines.ui.MarsMinesGame::new),
        new GameEntry(
            9,
            "memory-cats",
            "Котики-близнецы",
            "Равенство и состояния",
            edu.course.games.memorycats.ui.MemoryCatsGame::new),
        new GameEntry(
            10,
            "word-rain",
            "Словопад",
            "Строки и нормализация",
            edu.course.games.wordrain.ui.WordRainGame::new),
        new GameEntry(
            11,
            "balloon-rescue",
            "Спасите воздушный шар",
            "Множества и команды",
            edu.course.games.balloonrescue.ui.BalloonRescueGame::new),
        new GameEntry(
            12,
            "word-maze",
            "Буквенный лабиринт",
            "Маршруты и история",
            edu.course.games.wordmaze.ui.WordMazeGame::new),
        new GameEntry(
            13,
            "pixel-symmetry",
            "Мастерская симметрии",
            "Команды и отражение",
            edu.course.games.pixelsymmetry.ui.PixelSymmetryGame::new),
        new GameEntry(
            14,
            "color-flood",
            "Цветной прилив",
            "Заливка и обход графа",
            edu.course.games.colorflood.ui.ColorFloodGame::new),
        new GameEntry(
            15,
            "lights-out",
            "Ночной город",
            "Пакеты и атомарность",
            edu.course.games.lightsout.ui.LightsOutGame::new),
        new GameEntry(
            16,
            "cats-256",
            "Котики 256",
            "Слияния и результаты",
            edu.course.games.cats256.ui.Cats256Game::new),
        new GameEntry(
            17,
            "moon-sokoban",
            "Склад лунного сыра",
            "Слои и отмена хода",
            edu.course.games.moonsokoban.ui.MoonSokobanGame::new),
        new GameEntry(
            18,
            "laser-mail",
            "Лазерная почта",
            "Трассировка и циклы",
            edu.course.games.lasermail.ui.LaserMailGame::new),
        new GameEntry(
            19,
            "time-canvas",
            "Холст времени",
            "Снимки и транзакции",
            edu.course.games.timecanvas.ui.TimeCanvasGame::new),
        new GameEntry(
            20,
            "space-kitchen",
            "Космическая кухня",
            "Парсинг и кратность",
            edu.course.games.spacekitchen.ui.SpaceKitchenGame::new),
        new GameEntry(
            21,
            "unicode-safari",
            "Unicode-сафари",
            "Unicode и бюджет",
            edu.course.games.unicodesafari.ui.UnicodeSafariGame::new),
        new GameEntry(
            22,
            "utf8-radio",
            "Радио UTF-8",
            "UTF-8 и протокол",
            edu.course.games.utf8radio.ui.Utf8RadioGame::new),
        new GameEntry(
            23,
            "captain-cipher",
            "Шифр капитана",
            "Переполнение и формат",
            edu.course.games.captaincipher.ui.CaptainCipherGame::new),
        new GameEntry(
            24,
            "ballistic-mail",
            "Баллистическая почта",
            "Модель и воспроизведение",
            edu.course.games.ballisticmail.ui.BallisticMailGame::new),
        new GameEntry(
            25,
            "factory-robot",
            "Робот на заводе",
            "Язык команд и лимиты",
            edu.course.games.factoryrobot.ui.FactoryRobotGame::new));
  }

  public static void main(String[] args) {
    List<GameEntry> entries = games();
    if (args.length > 1) throw new IllegalArgumentException("Usage: java -jar app.jar [1..25]");
    if (args.length == 1) {
      int number;
      try {
        number = Integer.parseInt(args[0]);
      } catch (NumberFormatException ex) {
        throw new IllegalArgumentException("Game number must be 1..25", ex);
      }
      if (number < 1 || number > entries.size())
        throw new IllegalArgumentException("Game number must be 1..25");
      GameWindow.open(entries.get(number - 1).factory());
      return;
    }
    SwingUtilities.invokeLater(
        () -> {
          JFrame window = new JFrame("Java Course · Игровая практика");
          window.setContentPane(new CourseMenu(entries, e -> GameWindow.open(e.factory())));
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          window.setSize(1100, 820);
          window.setMinimumSize(new java.awt.Dimension(1000, 680));
          window.setLocationRelativeTo(null);
          window.setVisible(true);
        });
  }
}
