package designpatterns.creational.day24.prototype;

// Prototype interface
public interface Colors {
    Colors clone();

    String getName();

    void setName(String name);
}
