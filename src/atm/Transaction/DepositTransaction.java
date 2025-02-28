package atm.Transaction;

import atm.Account;

public class DepositTransaction extends Transaction{
    public DepositTransaction(String transactionId, Double amount, Account account) {
        super(transactionId,account,amount);
    }

    @Override
    public void process() {
        account.credit(amount);
    }
}
