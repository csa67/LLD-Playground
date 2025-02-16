package coffee_machine.solution;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    private Map<String, Ingredient> ingredients;

    public static synchronized Inventory getInstance() {
        if(instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    private Inventory() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(String ingredientName, Integer quantity) {
        ingredients.put(ingredientName, new Ingredient(ingredientName, quantity));
    }

    public synchronized boolean hasSufficientIngredients(CoffeeType coffeeType, CupSize size) {
        Recipe recipe = RecipeBook.getRecipe(coffeeType);
        double multiplier = size.getMultiplier();

        return ingredients.get("Water").getQuantity() >= (int) (recipe.getWater() * multiplier) &&
                ingredients.get("CoffeeBeans").getQuantity() >= (int) (recipe.getCoffeeBeans() * multiplier) &&
                ingredients.get("Milk").getQuantity() >= (int) (recipe.getMilk() * multiplier) &&
                ingredients.get("Sugar").getQuantity() >= (int) (recipe.getSugar() * multiplier);
    }

    public synchronized void consumeIngredients(CoffeeType type, CupSize size) {
        Recipe recipe = RecipeBook.getRecipe(type);
        double multiplier = size.getMultiplier();

        ingredients.get("Water").setQuantity(ingredients.get("Water").getQuantity() - (int) (recipe.getWater() * multiplier));
        ingredients.get("CoffeeBeans").setQuantity(ingredients.get("CoffeeBeans").getQuantity() - (int) (recipe.getCoffeeBeans() * multiplier));
        ingredients.get("Milk").setQuantity(ingredients.get("Milk").getQuantity() - (int) (recipe.getMilk() * multiplier));
        ingredients.get("Sugar").setQuantity(ingredients.get("Sugar").getQuantity() - (int) (recipe.getSugar() * multiplier));
    }


}
