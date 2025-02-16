package coffee_machine.solution;

import java.util.HashMap;
import java.util.Map;

public class RecipeBook {
    private static final Map<CoffeeType,Recipe> recipes = new HashMap<>();

    static{
        recipes.put(CoffeeType.ESPRESSO, new Recipe(50, 18, 0, 0));
        recipes.put(CoffeeType.LATTE, new Recipe(200, 18, 150, 5));
        recipes.put(CoffeeType.CAPPUCCINO, new Recipe(150, 18, 100, 5));
        recipes.put(CoffeeType.AMERICANO, new Recipe(250, 18, 0, 5));
    }

    public static Recipe getRecipe(CoffeeType type) {
        return recipes.get(type);
    }
}
