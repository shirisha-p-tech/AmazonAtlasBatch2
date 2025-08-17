package designpatterns.creational.day24.builder;

// Builder Interface
public interface LaptopBuilder {
    LaptopBuilder buildMemory(int memory);

    LaptopBuilder buildStorage(int storage);

    LaptopBuilder buildProcessor(String processor);

    LaptopBuilder buildGraphicsCard(String graphicsCard);

    Laptop build();
}
