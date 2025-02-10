package vending_machine.states;

import vending_machine.solution.Coin;
import vending_machine.solution.Note;
import vending_machine.solution.Product;
import vending_machine.solution.VendingMachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine machine;

    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product: " + product + " is already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addCoin(coin);
        System.out.println("Inserted coin: " + coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        machine.addNote(note);
        System.out.println("Inserted note: " + note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }

    private void checkPaymentStatus() {
        if(machine.getTotalPayment() >= machine.getSelectedProduct().getProductPrice()){
            machine.setState(machine.getDispenseState());
        }else{
            double balance = machine.getTotalPayment() - machine.getSelectedProduct().getProductPrice();
            System.out.println(balance+" more to be paid.");
        }
    }
}
