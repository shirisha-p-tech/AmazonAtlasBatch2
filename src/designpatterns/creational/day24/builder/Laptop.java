package designpatterns.creational.day24.builder;

// Product Class
public class Laptop {
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
