package designpatterns.structural.day25.bridge;

public class Square extends Shape {
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
