package parkinglot.solution;

import parkinglot.solution.vehicletype.Car;
import parkinglot.solution.vehicletype.Motorcycle;
import parkinglot.solution.vehicletype.Truck;
import parkinglot.solution.vehicletype.Vehicle;

public class Demo {
    public static void main(String[] args) {
        ParkingLot parkinglot = ParkingLot.getInstance();
        parkinglot.addLevel(new Level(1,100));
        parkinglot.addLevel(new Level(2,200));

        Vehicle car = new Car("ACB123");
        Vehicle truck = new Truck("TCK123");
        Vehicle motorcycle = new Motorcycle("MK123");

        parkinglot.parkVehicle(car);
        parkinglot.parkVehicle(truck);
        parkinglot.parkVehicle(motorcycle);

        parkinglot.displayAvailability();

        parkinglot.unparkVehicle(truck);

        parkinglot.displayAvailability();
    }
}
