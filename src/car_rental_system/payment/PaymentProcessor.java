package car_rental_system.payment;

import car_rental_system.Reservation;

public interface PaymentProcessor {
    boolean processPayment(Reservation reservation);
}
