package designpatterns.creational.day24.prototype;

// Concrete prototype - White color
public class WhiteConcretePrototype implements Colors {
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
