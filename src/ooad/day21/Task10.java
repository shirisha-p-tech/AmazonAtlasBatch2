package ooad.day21;
// Dependency example

class Engine {
    void start() {
        System.out.println("Engine starting");
    }
}

// Car class depends on Engine, but does not own it
class Car {
    void drive() {
        Engine engine = new Engine(); // Dependency temporarily
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Task10 {

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive();
    }
}

