package edu.course.games.factoryrobot.domain;

import java.util.Objects;

/** Executes one command per explicit step. It has no keyboard, clock or window dependency. */
public final class RobotRunner {
  private final int[][] map;
  private final Cell start;
  private String program = "";
  private ExecutionState state;

  public RobotRunner(int[][] map, Cell start) {
    Objects.requireNonNull(map);
    this.start = Objects.requireNonNull(start);
    if (map.length == 0 || map[0] == null || map[0].length == 0) {
      throw new IllegalArgumentException("Map must be nonempty and rectangular");
    }
    this.map = new int[map.length][];
    for (int row = 0; row < map.length; row++) {
      if (map[row] == null || map[row].length != map[0].length) {
        throw new IllegalArgumentException("Map must be rectangular");
      }
      this.map[row] = map[row].clone();
    }
    if (start.row() < 0
        || start.row() >= map.length
        || start.col() < 0
        || start.col() >= map[0].length
        || map[start.row()][start.col()] != 0) {
      throw new IllegalArgumentException("Start must be a passable map cell");
    }
    state = new ExecutionState(start, 0, 0, false);
  }

  public ExecutionState state() {
    return state;
  }

  /** Invalid input leaves the existing execution intact. Valid input restarts from the origin. */
  public boolean start(String candidate) {
    Objects.requireNonNull(candidate);
    if (!RobotRules.isValidProgram(candidate)) return false;
    program = candidate;
    state = new ExecutionState(start, 0, 0, true);
    return true;
  }

  public ExecutionState step() {
    if (!state.running()) return state;
    char command = program.charAt(state.nextInstruction());
    int direction = RobotRules.nextDirection(state.direction(), command);
    Cell position =
        command == 'F'
            ? RobotRules.nextCell(map, state.position().row(), state.position().col(), direction)
            : state.position();
    int nextInstruction = state.nextInstruction() + 1;
    state =
        new ExecutionState(
            position, direction, nextInstruction, nextInstruction < program.length());
    return state;
  }
}
