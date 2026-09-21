package edu.course.platform.desktop;

import java.util.Random;

/** Mutable state belongs to one session. No shared random, input or score. EDT confined. */
public final class GameSession {
  private final long seed;
  private final Random random;
  private final boolean[] down = new boolean[600];
  private int score;
  private boolean finished;
  private String status = "";

  public GameSession(long seed) {
    this.seed = seed;
    random = new Random(seed);
  }

  public Random random() {
    return random;
  }

  public int score() {
    return score;
  }

  public void setScore(int value) {
    score = value;
  }

  public void addScore(int delta) {
    score = Math.addExact(score, delta);
  }

  public boolean finished() {
    return finished;
  }

  public String status() {
    return status;
  }

  public void status(String message) {
    status = java.util.Objects.requireNonNull(message);
  }

  public void end(String message) {
    status(message);
    finished = true;
  }

  public int held(int key) {
    return key >= 0 && key < down.length && down[key] ? 1 : 0;
  }

  void key(int key, boolean pressed) {
    if (key >= 0 && key < down.length) down[key] = pressed;
  }

  void clearKeys() {
    java.util.Arrays.fill(down, false);
  }

  void reset() {
    score = 0;
    finished = false;
    status = "";
    clearKeys();
    random.setSeed(seed);
  }
}
