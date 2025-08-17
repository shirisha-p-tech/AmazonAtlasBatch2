package designpatterns.creational.day24.prototype2;

// Prototype interface
public interface Plant extends Cloneable {
    void grow();

    String getGrowthType();

    void setGrowthType(String type);

    Plant clone();
}
