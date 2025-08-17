package designpatterns.creational.day24.prototype;
// Prototype Design Pattern – Color Cloning Example

// Client code demonstrating Prototype Design Pattern
public class Task3 {
    public static void main(String[] args) {
        Colors blackPrototypeObj = new BlackConcretePrototype("Black Color");
        Colors whitePrototypeObj = new WhiteConcretePrototype("White Color");

        // Clone the prototype objects
        Colors clonedBlackObj = blackPrototypeObj.clone();
        Colors clonedWhiteObj = whitePrototypeObj.clone();

        // Modify the cloned objects' names
        clonedBlackObj.setName("dark color");
        clonedWhiteObj.setName("light color");

        // Print names to verify clones are independent
        System.out.println("Black color is: " + clonedBlackObj.getName());
        System.out.println("White color is: " + clonedWhiteObj.getName());
    }
}

