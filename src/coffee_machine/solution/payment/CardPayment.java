package coffee_machine.solution.payment;

public class CardPayment implements PaymentStrategy{

    @Override
    public synchronized boolean processPayment(double amount, double price) {
        System.out.println("Processing credit card payment: $" + amount);
        return true;
    }
}
