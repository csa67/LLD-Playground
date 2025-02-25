package car_rental_system;

public class Car {
    private String licenseNumber;
    private String model;
    private int year;
    private CarType carType;
    private int price;
    private boolean available;

    public Car(String licenseNumber, String model, int year, CarType carType, int price) {
        this.licenseNumber = licenseNumber;
        this.model = model;
        this.year = year;
        this.carType = carType;
        this.price = price;
        this.available = true;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
