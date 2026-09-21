package edu.course.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GamePanel;
import edu.course.platform.desktop.GameSession;
import java.awt.image.BufferedImage;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.swing.SwingUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class GameIntegrationTest {
  static Stream<Function<GameSession, DesktopGame>> games() {
    return Stream.of(
        edu.course.games.starcourier.ui.StarCourierGame::new,
        edu.course.games.moonlander.ui.MoonLanderGame::new,
        edu.course.games.cloudjumper.ui.CloudJumperGame::new,
        edu.course.games.portalpong.ui.PortalPongGame::new,
        edu.course.games.brickgarden.ui.BrickGardenGame::new,
        edu.course.games.couriersnake.ui.CourierSnakeGame::new,
        edu.course.games.lunartetris.ui.LunarTetrisGame::new,
        edu.course.games.marsmines.ui.MarsMinesGame::new,
        edu.course.games.memorycats.ui.MemoryCatsGame::new,
        edu.course.games.wordrain.ui.WordRainGame::new,
        edu.course.games.balloonrescue.ui.BalloonRescueGame::new,
        edu.course.games.wordmaze.ui.WordMazeGame::new,
        edu.course.games.pixelsymmetry.ui.PixelSymmetryGame::new,
        edu.course.games.colorflood.ui.ColorFloodGame::new,
        edu.course.games.lightsout.ui.LightsOutGame::new,
        edu.course.games.cats256.ui.Cats256Game::new,
        edu.course.games.moonsokoban.ui.MoonSokobanGame::new,
        edu.course.games.lasermail.ui.LaserMailGame::new,
        edu.course.games.timecanvas.ui.TimeCanvasGame::new,
        edu.course.games.spacekitchen.ui.SpaceKitchenGame::new,
        edu.course.games.unicodesafari.ui.UnicodeSafariGame::new,
        edu.course.games.utf8radio.ui.Utf8RadioGame::new,
        edu.course.games.captaincipher.ui.CaptainCipherGame::new,
        edu.course.games.ballisticmail.ui.BallisticMailGame::new,
        edu.course.games.factoryrobot.ui.FactoryRobotGame::new);
  }

  @ParameterizedTest
  @MethodSource("games")
  void startsRendersTicksAndRestartsWithoutErrors(Function<GameSession, DesktopGame> factory)
      throws Exception {
    SwingUtilities.invokeAndWait(
        () -> {
          GamePanel host = new GamePanel(factory, 2026);
          host.setSize(960, 720);
          host.restart();
          BufferedImage image = new BufferedImage(960, 720, BufferedImage.TYPE_INT_RGB);
          var graphics = image.createGraphics();
          try {
            host.paint(graphics);
            assertEquals("", host.problem());
            host.press(37);
            for (int i = 0; i < 3; i++) host.tick();
            host.release(37);
            host.tap(-100, -100, 1);
            host.type('A');
            host.press(116);
            host.paint(graphics);
            assertEquals("", host.problem());
            assertFalse(host.done());
          } finally {
            graphics.dispose();
          }
        });
  }
}
