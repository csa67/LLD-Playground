package atm;

public class Dispenser {
    private int cashAvailable;

    public Dispenser(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public synchronized void dispenseCash(int amount) {
        if(amount > cashAvailable) {
            throw new IllegalArgumentException("Insufficient cash available in the ATM.");
        }
        cashAvailable -= amount;
        System.out.println("Dispensing " + amount + " cash.");
    }
}
