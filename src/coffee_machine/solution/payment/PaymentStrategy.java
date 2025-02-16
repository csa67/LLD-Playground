package coffee_machine.solution.payment;

public interface PaymentStrategy {
    boolean processPayment(double amount, double price);
}
