package designpatterns.structural.day25.decorator;

// Concrete Component
public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain pizza";
    }

    @Override
    public double getCost() {
        return 5.00; // base price
    }
}
