package edu.course.games.spacekitchen.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RecipeRulesBoundaryTest {
  @Test
  void tokensPreserveEmptyFieldsIncludingTrailingOne() {
    assertArrayEquals(new String[] {"a", "", "b", ""}, RecipeRules.parseIngredients(" A,,B, "));
    assertArrayEquals(new String[0], RecipeRules.parseIngredients("\u2003"));
  }

  @Test
  void recipeIsMultisetAndDoesNotSortCallersArrays() {
    String[] a = {"b", "a", "a"}, b = {"a", "b", "a"};
    assertTrue(RecipeRules.hasSameIngredients(a, b));
    assertArrayEquals(new String[] {"b", "a", "a"}, a);
    assertArrayEquals(new String[] {"a", "b", "a"}, b);
    assertFalse(RecipeRules.hasSameIngredients(new String[] {"a", "a"}, new String[] {"a"}));
    assertFalse(RecipeRules.hasSameIngredients(new String[] {"A"}, new String[] {"a"}));
  }
}
