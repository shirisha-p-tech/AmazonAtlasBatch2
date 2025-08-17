package designpatterns.creational.day24.builder;

// Builder Design Pattern - Laptop Customization

// Client code demonstrating Builder Design Pattern
public class Task2 {
    public static void main(String[] args) {
        LaptopBuilder builder = new LaptopConcreteBuilder();
        LaptopDirector director = new LaptopDirector(builder);
        Laptop laptop = director.constructLaptop();

        System.out.println(laptop);
    }
}
