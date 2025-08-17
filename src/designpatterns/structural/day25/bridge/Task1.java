package designpatterns.structural.day25.bridge;

// Bridge Design Pattern - Structural DP

//Decouple Abstraction(Shape) from Implementation(ExcalidrawAPI)

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Bridge Design Pattern - Structural DP");
        ExcalidrawAPI obj1 = new DrawingFrame();
        ExcalidrawAPI obj2 = new DrawingPicture();

        Shape square = new Square(5,obj1);
        square.draw();
        Shape square2 = new Square(10, obj2);
        square2.draw();
    }
}
