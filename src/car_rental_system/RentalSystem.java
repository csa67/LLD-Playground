package car_rental_system;

import car_rental_system.payment.CreditCardPaymentProcesser;
import car_rental_system.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {
    private static RentalSystem rentalSystem;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;
    private final CarInventory carInventory;

    private RentalSystem() {
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new CreditCardPaymentProcesser();
        carInventory = new CarInventory();
    }

    public static RentalSystem getRentalSystem() {
        if (rentalSystem == null) {
            rentalSystem = new RentalSystem();
        }
        return rentalSystem;
    }

    public void addCar(Car car){
        carInventory.addCar(car);
    }

    public List<Car> searchCars(String model, CarType carType, LocalDate startDate, LocalDate endDate){
        List<Car> availableCars = new ArrayList<>();
        for(Car car: carInventory.getCars().values()){
            if(car.getModel().equalsIgnoreCase(model) && car.getCarType().equals(carType) && car.isAvailable()){
                if(isCarAvailable(car,startDate,endDate)){
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar().equals(car) && startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())){
                return false;
            }
        }

        return true;
    }

    public synchronized Reservation makeReservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        if(isCarAvailable(car,startDate,endDate)){
            String reservationId = UUID.randomUUID().toString();
            Reservation reservation = new Reservation(reservationId,customer,car,startDate,endDate);
            reservations.put(reservationId,reservation);
            carInventory.markAvailability(car.getLicenseNumber(),false);
            return reservation;
        }
        System.out.println("Car is not currently available");
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null){
            reservations.remove(reservationId);
            carInventory.markAvailability(reservation.getCar().getLicenseNumber(),true);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation);
    }
}
