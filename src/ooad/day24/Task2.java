package ooad.day24;

// Builder Design Pattern - Laptop Customization

// Product Class
class Laptop {
    private int memory;
    private int storage;
    private String processor;
    private String graphicsCard;

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Laptop Specs:\n" +
                "Memory: " + memory + " GB\n" +
                "Storage: " + storage + " GB\n" +
                "Processor: " + processor + "\n" +
                "Graphics Card: " + graphicsCard;
    }
}

// Builder Interface
interface LaptopBuilder {
    LaptopBuilder buildMemory(int memory);
    LaptopBuilder buildStorage(int storage);
    LaptopBuilder buildProcessor(String processor);
    LaptopBuilder buildGraphicsCard(String graphicsCard);
    Laptop build();
}

// Concrete Builder
class LaptopConcreteBuilder implements LaptopBuilder {
    private Laptop laptop;

    public LaptopConcreteBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public LaptopBuilder buildMemory(int memory) {
        laptop.setMemory(memory);
        return this;
    }

    @Override
    public LaptopBuilder buildStorage(int storage) {
        laptop.setStorage(storage);
        return this;
    }

    @Override
    public LaptopBuilder buildProcessor(String processor) {
        laptop.setProcessor(processor);
        return this;
    }

    @Override
    public LaptopBuilder buildGraphicsCard(String graphicsCard) {
        laptop.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public Laptop build() {
        return this.laptop;
    }
}

// Director (Optional)
class LaptopDirector {
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

// Client code demonstrating Builder Design Pattern
public class Task2 {
    public static void main(String[] args) {
        LaptopBuilder builder = new LaptopConcreteBuilder();
        LaptopDirector director = new LaptopDirector(builder);
        Laptop laptop = director.constructLaptop();

        System.out.println(laptop);
    }
}
