package edu.course.learning;

/** An unimplemented exercise is a failure in acceptance tests, never a demo answer. */
public final class IncompleteExerciseException extends UnsupportedOperationException {
  public IncompleteExerciseException(String task) {
    super(task);
  }
}
