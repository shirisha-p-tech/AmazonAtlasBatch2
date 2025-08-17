package designpatterns.structural.day25.bridge;

// concrete Implementor DrawingFrame.. DrawingPicture
public class DrawingPicture implements ExcalidrawAPI {
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing Picture using Excalidraw with side " + s);

    }
}
