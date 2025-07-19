package ooad.day20;
// OCP Implementation - Compare Area of Shapes
interface Shape {
    int area();
}

class Circle implements Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public int area() {
        return (int)(Math.PI * r * r); // Casting to int
    }
}

class Square implements Shape {
    int height;

    public Square(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return height * height;
    }
}

class OpenClosedExample {
    public int compareArea(Shape a, Shape b) {
        return a.area() - b.area();
    }
}


public class Task5 {
    public static void main(String[] args) {
        Shape square = new Square(4);
        Shape circle = new Circle(5);
        System.out.println("Square Area: " + square.area());
        System.out.println("Circle Area: " + circle.area());

        OpenClosedExample comparator = new OpenClosedExample();
        int result = comparator.compareArea(circle, square);

        System.out.println("Area comparison result: " + result);

        if (result > 0) {
            System.out.println("Circle has a larger area.");
        } else if (result < 0) {
            System.out.println("Square has a larger area.");
        } else {
            System.out.println("Both shapes have equal area.");
        }
    }
}
