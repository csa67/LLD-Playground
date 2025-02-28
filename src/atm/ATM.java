package atm;

import atm.Transaction.DepositTransaction;
import atm.Transaction.Transaction;
import atm.Transaction.WithdrawalTransaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private final BankingService bankingService;
    private final Dispenser cashDispenser;
    private final AtomicLong transactionCounter = new AtomicLong(0);

    public ATM(BankingService bankingService, Dispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    private void authenticateUser(Card card){
        bankingService.authenticateCard(card);
    }

    public double checkBalance(String accountNumber){
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdraw(double amount, Card card){
        authenticateUser(card);
        Account account = bankingService.getAccountFromCard(card);
        if(account!=null && account.getBalance() < amount){
            System.out.println("Error: Insufficient balance.");
            return;
        }
        Transaction transaction = new WithdrawalTransaction(generateTransactionId(), amount, account);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash((int) amount);

    }

    public void deposit(String accountNumber, double amount){
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction(generateTransactionId(), amount, account);
        bankingService.processTransaction(transaction);
    }

    private String generateTransactionId() {
        // Generate a unique transaction ID
        long transactionNumber = transactionCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + String.format("%010d", transactionNumber);
    }

}
