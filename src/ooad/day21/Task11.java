package ooad.day21;

// Aggregation example


class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }


}

// Car1 class aggregates Driver
class Car1 {
    Driver driver; // Aggregation

    Car1(Driver driver) {
        this.driver = driver;
    }

    public String getName() {
        return driver.name;

    }

}


public class Task11 {
    public static void main(String[] args) {
        Driver driver = new Driver("John"); // Driver created independently
        Car1 myCar = new Car1(driver); // Car receives driver via aggregation
        System.out.println("The car driver is " + myCar.getName());
    }
}

