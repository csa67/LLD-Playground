package vending_machine.states;

import vending_machine.solution.Coin;
import vending_machine.solution.Note;
import vending_machine.solution.Product;
import vending_machine.solution.VendingMachine;

public class IdleState implements VendingMachineState{

    VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        if(machine.inventory.isProductAvailable(product)){
            machine.setSelectedProduct(product);
            machine.setState(machine.getReadyState());
            System.out.println("Selected product: " + product);
        }else{
            System.out.println("Product is not available");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}
