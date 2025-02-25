package car_rental_system.payment;

import car_rental_system.Reservation;

public class CreditCardPaymentProcesser implements PaymentProcessor {

    @Override
    public boolean processPayment(Reservation reservation) {
        System.out.println("Payment processed with credit card");
        return true;
    }
}
