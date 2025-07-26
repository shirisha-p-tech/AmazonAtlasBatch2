package ooad.day21;

// ISP Violation

interface ICalcShapesArea {
    void calcArea();
    void calcVolume();
}

// Circle is a 2D shape – it doesnt have a volume
class Circle implements ICalcShapesArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of circle");
    }

    @Override
    public void calcVolume() {
        // Dummy implementation – Circle has no volume
        System.out.println("Circle has no volume");
    }
}

// Sphere is a 3D shape – area and volume both apply
class Sphere implements ICalcShapesArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of sphere");
    }

    @Override
    public void calcVolume() {
        System.out.println("Calculating volume of sphere");
    }
}


public class Task03 {
    public static void main(String[] args) {
        ICalcShapesArea circle = new Circle();

        System.out.println("\nISP Violation:\n");
        circle.calcArea();
        circle.calcVolume(); // Not meaningful

        ICalcShapesArea sphere = new Sphere();
        sphere.calcArea();
        sphere.calcVolume();
    }
}

