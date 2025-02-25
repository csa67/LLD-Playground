package car_rental_system;

import java.time.LocalDate;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        RentalSystem herc = RentalSystem.getRentalSystem();

        //New Cars
        Car car1 = new Car("ABC123","Toyota Camry",2019,CarType.SEDAN,50);
        Car car2 = new Car("XYZ45","Malibu",2022,CarType.SEDAN,60);
        Car car3 = new Car("Agh67","Ford Mustang",2023,CarType.LUXURY,90);

        herc.addCar(car1);
        herc.addCar(car2);
        herc.addCar(car3);

        Customer customer1 = new Customer("John Doe","DL1233","987456321");

        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(4);

        List<Car> availableCars = herc.searchCars("Toyota Camry", CarType.SEDAN, today, endDate);
        if(!availableCars.isEmpty()){
            Car selectedCar = availableCars.get(0);
            Reservation reservation = herc.makeReservation(selectedCar,customer1,today,endDate);
            if(reservation!=null){
                boolean paymentStatus = herc.processPayment(reservation);
                if(paymentStatus){
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                }else{
                    System.out.println("Payment failed. Reservation canceled.");
                    herc.cancelReservation(reservation.getReservationId());
                }
            }else{
                System.out.println("Selected car is not available for the given dates.");
            }
        }else{
            System.out.println("No available cars in the selected dates.");
        }


    }
}
