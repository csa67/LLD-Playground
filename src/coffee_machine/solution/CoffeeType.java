package coffee_machine.solution;

public enum CoffeeType {
    ESPRESSO(3.0),
    LATTE(4.5),
    CAPPUCCINO(4),
    AMERICANO(2.75);

    private final double price;

    CoffeeType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
