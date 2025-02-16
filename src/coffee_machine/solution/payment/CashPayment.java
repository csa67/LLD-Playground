package coffee_machine.solution.payment;

import java.util.Arrays;

public class CashPayment implements PaymentStrategy{
    @Override
    public synchronized boolean processPayment(double amount, double price) {
        if(amount < price) {
            System.out.println("Insufficient funds");
        }else if(amount > price) {
            System.out.println("Payment Processed. Collect the change "+ Arrays.toString(new double[]{amount - price}));
        }else {
            System.out.println("Processing cash payment: $" + amount);
        }
        return true;
    }
}
