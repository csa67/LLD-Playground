package vending_machine.states;

import vending_machine.solution.Coin;
import vending_machine.solution.Note;
import vending_machine.solution.Product;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
    void cancelTransaction();
}
