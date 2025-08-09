package ooad.day25;

// Bridge Design Pattern - Structural DP

// concrete Implementor DrawingFrame.. DrawingPicture
class DrawingFrame implements ExcalidrawAPI {
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing frame using Excalidraw with side "+ s);
    }
}


// concrete Implementor DrawingFrame.. DrawingPicture
class DrawingPicture implements ExcalidrawAPI{
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing Picture using Excalidraw with side "+ s);

    }
}


// implenmentor
interface ExcalidrawAPI {
    void drawSquare(int s);
}


// Abstraction
abstract class Shape {
    protected ExcalidrawAPI excalidrawAPI;

    protected Shape(ExcalidrawAPI excalidrawAPI) {
        this.excalidrawAPI = excalidrawAPI;
    }

    abstract void draw();
}


class Square extends Shape{
    private int s;
    Square(int s, ExcalidrawAPI excalidrawAPI) {
        super(excalidrawAPI);
        this.s = s;
    }

    @Override
    void draw() {
        excalidrawAPI.drawSquare(s);
    }
}

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
