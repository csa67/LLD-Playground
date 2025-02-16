package coffee_machine.solution;

import coffee_machine.solution.payment.CardPayment;
import coffee_machine.solution.payment.CashPayment;
import coffee_machine.solution.payment.PaymentStrategy;

import java.util.Scanner;

public class CoffeeMachine{

    protected Inventory inventory = Inventory.getInstance();

    public void processOrder(){
        Scanner scanner = new Scanner(System.in);

        // Step 1: Select Coffee Type
        System.out.println("Select Coffee Type: 1. ESPRESSO  2. LATTE  3. CAPPUCCINO  4. AMERICANO");
        CoffeeType coffeeType = CoffeeType.values()[scanner.nextInt() - 1];

        System.out.println("Select Cup Size: 1. SMALL  2. MEDIUM  3. LARGE");
        CupSize size = CupSize.values()[scanner.nextInt() - 1];

        if (!inventory.hasSufficientIngredients(coffeeType, size)) {
            System.out.println("Not enough ingredients for " + coffeeType);
            return;
        }

        System.out.println("Select Payment Method: 1. Cash  2. Card");
        int paymentChoice = scanner.nextInt();
        PaymentStrategy strategy = (paymentChoice == 1) ? new CashPayment() : new CardPayment();

        double price = coffeeType.getPrice() * size.getMultiplier();
        System.out.println("Total Price: $" + price);
        System.out.println("Insert money (or confirm card payment): ");
        double paymentAmount = scanner.nextDouble();

        if (!strategy.processPayment(paymentAmount, price)) {
            System.out.println("Transaction failed: Insufficient payment.");
            return;
        }

        inventory.consumeIngredients(coffeeType, size);
        System.out.println("Dispensing " + size + " " + coffeeType);

    }


}
