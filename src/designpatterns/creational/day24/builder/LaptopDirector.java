package designpatterns.creational.day24.builder;

// Director
public class LaptopDirector {
    private LaptopBuilder laptopBuilder;

    public LaptopDirector(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop constructLaptop() {
        return laptopBuilder
                .buildMemory(16)
                .buildStorage(512)
                .buildProcessor("Intel Core i5")
                .buildGraphicsCard("Integrated Intel Iris Xe")
                .build();
    }
}
