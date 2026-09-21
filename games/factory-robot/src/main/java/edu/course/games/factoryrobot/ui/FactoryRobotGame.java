package edu.course.games.factoryrobot.ui;

import edu.course.games.factoryrobot.domain.Cell;
import edu.course.games.factoryrobot.domain.ExecutionState;
import edu.course.games.factoryrobot.domain.RobotRunner;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Objects;

/** Keyboard and animation adapter. RobotRunner executes commands without a clock. */
public final class FactoryRobotGame implements DesktopGame {
  private final GameSession session;
  private int[][] map;
  private RobotRunner runner;
  private String input;
  private double elapsedSeconds;

  public FactoryRobotGame(GameSession session) {
    this.session = Objects.requireNonNull(session);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "25. Робот на заводе",
        "Запрограммируйте робота: с (1,1) до (5,5), обходя стены.",
        "Введите F/L/R; Enter — запуск; Backspace — стереть");
  }

  @Override
  public void reset() {
    map =
        new int[][] {
          {1, 1, 1, 1, 1, 1, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 0, 1, 1, 1, 0, 1},
          {1, 0, 0, 0, 1, 0, 1},
          {1, 1, 1, 0, 1, 0, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 1, 1, 1, 1, 1, 1}
        };
    runner = new RobotRunner(map, new Cell(1, 1));
    input = "";
    elapsedSeconds = 0;
  }

  @Override
  public void render(Graphics2D graphics) {
    ExecutionState state = runner.state();
    FactoryRobotRenderer.draw(
        graphics,
        map,
        input,
        state.position().row(),
        state.position().col(),
        state.direction(),
        state.nextInstruction());
  }

  @Override
  public void update(double seconds) {
    if (!runner.state().running()) return;
    elapsedSeconds += seconds;
    if (elapsedSeconds < .25) return;
    elapsedSeconds -= .25;
    ExecutionState state = runner.step();
    if (!state.running()) {
      if (state.position().equals(new Cell(5, 5))) session.end("Робот доставил детали!");
      else session.status("Робот не дошёл. Исправьте программу");
    }
  }

  @Override
  public void onKeyPressed(int key) {
    if (runner.state().running()) return;
    if (key == KeyEvent.VK_BACK_SPACE && !input.isEmpty())
      input = input.substring(0, input.length() - 1);
    if (key == KeyEvent.VK_ENTER) {
      try {
        String program =
            edu.course.games.factoryrobot.domain.RobotRules.readProgram(
                new java.io.StringReader(input));
        if (runner.start(program)) elapsedSeconds = 0;
        else session.status("Загрузчик программы ещё не реализован");
      } catch (edu.course.games.factoryrobot.domain.ProgramFormatException ex) {
        session.status("Ошибка программы в позиции " + ex.offset() + ": " + ex.getMessage());
      } catch (edu.course.games.factoryrobot.domain.ProgramLoadException ex) {
        session.status("Не удалось прочитать программу: " + ex.getCause().getMessage());
      }
    }
  }

  @Override
  public void onCharacterTyped(char character) {
    if (!runner.state().running() && Character.isLetter(character) && input.length() < 60)
      input += Character.toUpperCase(character);
  }
}
