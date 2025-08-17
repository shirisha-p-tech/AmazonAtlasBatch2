package designpatterns.structural.day25.flyweight;

// Concrete Flyweight
public class Circle implements Shapes {
    private String color; // intrinsic state (shared)

    public Circle(String color) {
        this.color = color;
        System.out.println("Creating circle of color: " + color);
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ")");
    }
}
