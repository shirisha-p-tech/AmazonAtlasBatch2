package designpatterns.structural.day25.decorator;

// Concrete Decorator: Olives
public class Olives extends ToppingDecorator {
    public Olives(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 0.75;
    }
}
