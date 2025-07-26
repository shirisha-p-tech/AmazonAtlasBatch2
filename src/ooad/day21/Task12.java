package ooad.day21;

// Composition example


class Wheel {
    Wheel() {
        System.out.println("Wheel created");
    }
}

// Car2 class uses composition to own Wheels
class Car2 {
    private Wheel[] wheels; // Composition

    Car2() {
        // Creating 4 wheels when a Car2 is instantiated
        wheels = new Wheel[4];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel();
        }
        System.out.println("Car created with 4 wheels");
    }
}


public class Task12 {
    public static void main(String[] args) {
        Car2 myCar = new Car2(); // All wheels created with the car
    }
}

