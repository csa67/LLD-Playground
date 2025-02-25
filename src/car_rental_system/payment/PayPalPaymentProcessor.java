package car_rental_system.payment;

import car_rental_system.Reservation;

public class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(Reservation reservation) {
        System.out.println("Paypal Payment processed");
        return true;
    }
}
