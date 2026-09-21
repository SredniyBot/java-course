package edu.course.games.spacekitchen.ui;

import edu.course.games.spacekitchen.domain.RecipeRules;
import edu.course.platform.desktop.DesktopGame;
import edu.course.platform.desktop.GameDescriptor;
import edu.course.platform.desktop.GameSession;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/** Контроллер ввода и анимации. Правила — domain, рисование — SpaceKitchenRenderer. */
public final class SpaceKitchenGame implements DesktopGame {
  private String[] ingredients = {"rice", "fish", "milk", "star"};
  private String order, input;
  private final GameSession context;

  public SpaceKitchenGame(GameSession context) {
    this.context = java.util.Objects.requireNonNull(context);
  }

  @Override
  public GameDescriptor info() {
    return new GameDescriptor(
        "20. Космическая кухня",
        "Приготовьте 8 заказов из ингредиентов. Порядок ингредиентов не важен.",
        "Клик по ингредиентам; Enter — подать; Backspace — очистить");
  }

  @Override
  public void reset() {
    order = "rice,fish";
    input = "";
  }

  @Override
  public void render(Graphics2D g) {
    SpaceKitchenRenderer.draw(g, ingredients, order, input, context.score());
  }

  @Override
  public void onKeyPressed(int key) {
    if (key == KeyEvent.VK_BACK_SPACE) input = "";
    if (key == KeyEvent.VK_ENTER) {
      if (RecipeRules.hasSameIngredients(
          RecipeRules.parseIngredients(order), RecipeRules.parseIngredients(input))) {
        context.addScore(1);
        String[] orders = {"rice,fish", "milk,star", "fish,fish,rice", "star,rice,milk"};
        order = orders[context.random().nextInt(orders.length)];
        input = "";
        if (context.score() == 8) context.end("Ресторан получил звезду!");
      } else context.status("Рецепт не совпал; проверьте повторы");
    }
  }

  @Override
  public void onMousePressed(int mx, int my, int button) {
    int i = Math.floorDiv(mx - 100, 210);
    if (my >= 270 && my < 365 && i >= 0 && i < 4 && input.length() < 60)
      input += (input.isEmpty() ? "" : ",") + ingredients[i];
  }
}
