package car_rental_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarInventory {
    private final Map<String, Car> cars;

    public CarInventory() {
        cars = new ConcurrentHashMap<>();
    }

    public void addCar(Car car) {
        cars.put(car.getLicenseNumber(),car);
    }

    public void removeCar(Car car) {
        cars.remove(car.getLicenseNumber());
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void markAvailability(String licenseNumber, boolean isAvailable) {
        cars.get(licenseNumber).setAvailable(isAvailable);
    }
}
