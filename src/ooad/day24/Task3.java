package ooad.day24;
// Prototype Design Pattern – Color Cloning Example

// Prototype interface
interface Colors {
    Colors clone();
    String getName();
    void setName(String name);
}

// Concrete prototype - Black color
class BlackConcretePrototype implements Colors {
    private String name;

    public BlackConcretePrototype() {
        System.out.println("BlackConcretePrototype constructor is called");
    }

    public BlackConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Colors clone() {
        return new BlackConcretePrototype(this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

// Concrete prototype - White color
class WhiteConcretePrototype implements Colors {
    private String name;

    public WhiteConcretePrototype() {
        System.out.println("WhiteConcretePrototype constructor is called");
    }

    public WhiteConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Colors clone() {
        return new WhiteConcretePrototype(this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

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

