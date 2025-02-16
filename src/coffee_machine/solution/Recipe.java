package coffee_machine.solution;

public class Recipe {
    private int water,coffeeBeans,milk,sugar;

    public Recipe(int water, int coffeeBeans, int milk, int sugar) {
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.milk = milk;
        this.sugar = sugar;
    }

    public int getWater() {
        return water;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMilk() {
        return milk;
    }

    public int getSugar() {
        return sugar;
    }
}
