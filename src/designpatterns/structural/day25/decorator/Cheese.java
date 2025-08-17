package designpatterns.structural.day25.decorator;

// Concrete Decorator: Cheese
public class Cheese extends ToppingDecorator {
    public Cheese(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 1.25;
    }
}
