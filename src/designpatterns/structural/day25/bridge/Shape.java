package designpatterns.structural.day25.bridge;

// Abstraction
public abstract class Shape {
    protected ExcalidrawAPI excalidrawAPI;

    protected Shape(ExcalidrawAPI excalidrawAPI) {
        this.excalidrawAPI = excalidrawAPI;
    }

    abstract void draw();
}
