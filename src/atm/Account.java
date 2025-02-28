package atm;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Account {
    String accountNumber;
    private double balance;
    private final List<Card> cardsList;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cardsList  = new CopyOnWriteArrayList<>();

    }

    public void addCard(Card card) {
        this.cardsList.add(card);
    }

    public boolean authenticate(Card card) {
        if(cardsList.contains(card)) {
            return true;
        }else {
            throw new IllegalArgumentException("Invalid Card");
        }
    }

    public void blockCard(Card card) {
        this.cardsList.remove(card);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }
}
