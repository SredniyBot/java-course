package edu.course.games.spacekitchen.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RecipeRulesTest {
  @Test
  void tokensMatchesPublishedExamples() {

    assertTrue(
        java.util.Arrays.equals(
            RecipeRules.parseIngredients(" Rice, FISH "), new String[] {"rice", "fish"}));
    assertTrue(RecipeRules.parseIngredients(" ").length == 0);
    assertTrue(RecipeRules.parseIngredients("rice,")[1].isEmpty());
  }

  @Test
  void sameRecipeMatchesPublishedExamples() {

    assertTrue(RecipeRules.hasSameIngredients(new String[] {"a", "b"}, new String[] {"b", "a"}));
    assertFalse(RecipeRules.hasSameIngredients(new String[] {"a", "a"}, new String[] {"a"}));
  }
}
