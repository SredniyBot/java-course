package edu.course.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class ExercisePreviewTest {
  @Test
  void strictCallsNeverEvaluateDemonstration() {
    AtomicInteger calls = new AtomicInteger();
    assertThrows(
        IncompleteExerciseException.class,
        () -> ExercisePreview.unfinished("x", calls::incrementAndGet));
    assertEquals(0, calls.get());
  }

  @Test
  void scopesRestoreAfterExceptionsAndDoNotHideRealErrors() {
    ExercisePreview p = new ExercisePreview();
    var failure = new IllegalStateException("real defect");
    assertSame(
        failure,
        assertThrows(
            IllegalStateException.class,
            () ->
                p.run(
                    () -> {
                      ExercisePreview.unfinished("x", () -> 0);
                      throw failure;
                    })));
    assertThrows(IncompleteExerciseException.class, () -> ExercisePreview.unfinished("x", () -> 0));
    assertEquals(List.of("x"), p.missingTasks());
  }

  @Test
  void nestedSessionsAreIsolatedAndDiagnosticsAreImmutable() {
    ExercisePreview outer = new ExercisePreview(), inner = new ExercisePreview();
    outer.run(
        () -> {
          ExercisePreview.unfinished("outer", () -> 1);
          inner.run(() -> ExercisePreview.unfinished("inner", () -> 2));
          ExercisePreview.unfinished("outer", () -> 3);
        });
    assertEquals(List.of("outer"), outer.missingTasks());
    assertEquals(List.of("inner"), inner.missingTasks());
    assertThrows(UnsupportedOperationException.class, () -> outer.missingTasks().clear());
    outer.reset();
    assertFalse(outer.incomplete());
    assertTrue(inner.incomplete());
  }

  @Test
  void bindingDoesNotEscapeToUnrelatedThread() throws InterruptedException {
    ExercisePreview p = new ExercisePreview();
    AtomicInteger strictFailures = new AtomicInteger();
    p.run(
        () -> {
          Thread worker =
              new Thread(
                  () -> {
                    try {
                      ExercisePreview.unfinished("other", () -> 0);
                    } catch (IncompleteExerciseException expected) {
                      strictFailures.incrementAndGet();
                    }
                  });
          worker.start();
          try {
            worker.join();
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new AssertionError(ex);
          }
        });
    assertEquals(1, strictFailures.get());
    assertFalse(p.incomplete());
  }

  @Test
  void callReturnsValueAndRecordsBeforeSupplierRuns() {
    ExercisePreview p = new ExercisePreview();
    assertEquals(
        7,
        p.call(
            () ->
                ExercisePreview.unfinished(
                    "x",
                    () -> {
                      assertTrue(p.incomplete());
                      return 7;
                    })));
  }
}
