package coffee_machine.solution;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        coffeeMachine.inventory.addIngredient("Water",1000);
        coffeeMachine.inventory.addIngredient("CoffeeBeans", 500);
        coffeeMachine.inventory.addIngredient("Milk", 500);
        coffeeMachine.inventory.addIngredient("Sugar", 300);

        while (true) {
            System.out.println("\n=== Welcome to Coffee Vending Machine ===");
            System.out.println("1. Order Coffee");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                coffeeMachine.processOrder();
            } else {
                System.out.println("Thank you for using the Coffee Vending Machine!");
                break;
            }
        }


    }
}
