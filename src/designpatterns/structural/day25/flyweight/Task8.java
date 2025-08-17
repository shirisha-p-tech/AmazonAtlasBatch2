package designpatterns.structural.day25.flyweight;

// Flyweight Pattern – Reusing Circle Objects Based on Color


// Client
public class Task8 {
    public static void main(String[] args) {
        System.out.println("Flyweight Design Pattern — Shared Colored Circles Example\n");

        Shapes red1 = ShapeFactory.getCircle("Red");
        red1.draw(10, 20);

        Shapes red2 = ShapeFactory.getCircle("Red");
        red2.draw(15, 25);

        Shapes blue = ShapeFactory.getCircle("Blue");
        blue.draw(30, 40);

        Shapes red3 = ShapeFactory.getCircle("Red");
        red3.draw(50, 60);
    }
}

/*
Flyweight is used to minimize memory usage by sharing as much data as possible with similar objects.
It separates intrinsic state (shared, reusable) from extrinsic state (unique, external).
Here Circle objects are created only once per color.
All red circles reuse the same object (shared intrinsic state).
Only the position (x, y) is passed as extrinsic data.
 */