package atm.Transaction;

import atm.Account;

public class WithdrawalTransaction extends Transaction{
    public WithdrawalTransaction(String transactionId, Double amount, Account account) {
        super(transactionId,account,amount);
    }

    @Override
    public void process() {
        account.debit(amount);
    }
}