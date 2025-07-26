package ooad.day21;
// ISP Implementation


// Interface for calculating area
interface ICalcArea {
    void calcArea();
}

// Interface for calculating volume
interface ICalcVolume {
    void calcVolume();
}

// Circle is a 2D shape – only implements area
class Circle1 implements ICalcArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of Circle");
    }
}

// Sphere is a 3D shape – implements both area and volume
class Sphere1 implements ICalcArea, ICalcVolume {
    @Override
    public void calcArea() {
        System.out.println("Calculating surface area of Sphere");
    }

    @Override
    public void calcVolume() {
        System.out.println("Calculating volume of Sphere");
    }
}


public class Task04 {
    public static void main(String[] args) {
        System.out.println("\nISP Implementation:\n");
        ICalcArea circle = new Circle1();
        circle.calcArea();

        Sphere1 sphere = new Sphere1(); // Uses both interfaces
        sphere.calcArea();
        sphere.calcVolume();
    }
}

