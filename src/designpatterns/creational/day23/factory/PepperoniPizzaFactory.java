package designpatterns.creational.day23.factory;

// Concrete Creator
public class PepperoniPizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        // Any additional pizza-specific creation logic can go here
        return new PepperoniPizza();  // Returning the concrete product
    }
}

