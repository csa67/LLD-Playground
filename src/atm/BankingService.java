package atm;

import atm.Transaction.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String,Account> accounts = new ConcurrentHashMap<>();
    private final Map<String,String> cardsList = new ConcurrentHashMap<>();

    public void createAccount(String accountNumber, double balance) {
        Account account = new Account(accountNumber,balance);
        accounts.put(accountNumber, account);
    }

    public void addCardToAccount(Card card, String accountNumber) {
        if(accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.addCard(card);
            cardsList.put(card.getCardNumber(),accountNumber);
        }else{
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public Account getAccountFromCard(Card card){
        String accountNum = cardsList.get(card.getCardNumber());
        return accounts.get(accountNum);
    }

    public boolean authenticateCard(Card card) {
        String cardNumber = card.getCardNumber();
        if(cardsList.containsKey(cardNumber)) {
            Account account = accounts.get(cardsList.get(cardNumber));
            return account.authenticate(card);
        }else{
            throw new IllegalArgumentException("Card does not exist");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction) {
        transaction.process();
    }
}
