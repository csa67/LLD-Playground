package parkinglot.solution;

import parkinglot.solution.vehicletype.Vehicle;
import parkinglot.solution.vehicletype.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isSpotAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isSpotAvailable()){
            if(vehicle.getType() == vehicleType){
                parkedVehicle = vehicle;
            }else{
                throw new IllegalArgumentException("Invalid vehicle type");
            }
        }else{
            throw new IllegalArgumentException("Spot already filled!");
        }
    }

    public void printAvailability(){
        System.out.println("Spot " + spotNumber + ": " + (isSpotAvailable() ? "available" : "not available") + "for" + vehicleType.toString());
    }

    public synchronized void unparkVehicle(){
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
