package vending_machine.states;

import vending_machine.solution.Coin;
import vending_machine.solution.Note;
import vending_machine.solution.Product;
import vending_machine.solution.VendingMachine;

public class DispenseState implements VendingMachineState {

    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected, get ready to collect it");
    }

    @Override
    public void insertCoin(Coin coin) {

        System.out.println("Payment is already made, get ready to collect it");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment is already made, get ready to collect it");
    }

    @Override
    public void dispenseProduct() {
        Product product = machine.getSelectedProduct();
        machine.inventory.updateQuantity(product,machine.inventory.getQuantity(product)-1);
        System.out.println("Product dispensed: " + product.getProductName());
        machine.setState(machine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Collect the dispensed product. Change will be refunded.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction cannot be cancelled when the product is already dispensed.");
    }
}
