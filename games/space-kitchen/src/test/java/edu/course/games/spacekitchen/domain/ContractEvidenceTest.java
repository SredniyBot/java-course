package edu.course.games.spacekitchen.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContractEvidenceTest {
  @Test
  void multisetCountsCannotBeReplacedByASet() {
    String[] order = {"milk", "milk", "tea"}, delivery = {"tea", "milk", "milk"};
    assertTrue(RecipeRules.hasSameIngredients(order, delivery));
    assertFalse(RecipeRules.hasSameIngredients(order, new String[] {"tea", "tea", "milk"}));
    assertArrayEquals(new String[] {"milk", "milk", "tea"}, order);
    assertArrayEquals(new String[] {"tea", "milk", "milk"}, delivery);
    assertArrayEquals(new String[] {"tea", ""}, RecipeRules.parseIngredients("tea,"));
  }
}
