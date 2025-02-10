package vending_machine.states;

import vending_machine.solution.Coin;
import vending_machine.solution.Note;
import vending_machine.solution.Product;
import vending_machine.solution.VendingMachine;

public class ReturnChangeState implements VendingMachineState{

    final VendingMachine machine;

    public ReturnChangeState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Collect change before selecting a new product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed.Please collect the change.");
    }

    @Override
    public void returnChange() {
        double change = machine.getTotalPayment()-machine.getSelectedProduct().getProductPrice();
        if(change > 0){
            System.out.println("Change returned: $" + change);
            machine.resetTotalPayment();
        }else{
            System.out.println("No change to return.");
        }
        machine.resetSelectedProduct();
        machine.setState(machine.getIdleState());
    }
}
