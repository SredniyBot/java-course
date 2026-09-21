package edu.course.learning;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/** Session-owned, EDT-confined preview diagnostics. Strict outside an explicit callback scope. */
public final class ExercisePreview {
  private static final ThreadLocal<ExercisePreview> ACTIVE = new ThreadLocal<>();
  private final Set<String> missing = new LinkedHashSet<>();

  public void run(Runnable action) {
    call(
        () -> {
          action.run();
          return null;
        });
  }

  public <T> T call(Supplier<T> action) {
    ExercisePreview previous = ACTIVE.get();
    ACTIVE.set(this);
    try {
      return action.get();
    } finally {
      if (previous == null) ACTIVE.remove();
      else ACTIVE.set(previous);
    }
  }

  public static <T> T unfinished(String id, Supplier<T> demonstration) {
    if (ACTIVE.get() == null) throw new IncompleteExerciseException(id);
    ACTIVE.get().missing.add(id);
    return demonstration.get();
  }

  public List<String> missingTasks() {
    return List.copyOf(missing);
  }

  public boolean incomplete() {
    return !missing.isEmpty();
  }

  public void reset() {
    missing.clear();
  }
}
