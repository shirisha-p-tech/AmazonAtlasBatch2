package designpatterns.creational.day23.factory;

// Factory DP: Creating a PepperoniPizza using factory method

// Driver class (Client)
public class Task01 {
    public static void main(String[] args) {
        // Creating the factory for Pepperoni Pizza
        PizzaFactory pizzaFactory = new PepperoniPizzaFactory();

        // Creating the Pepperoni Pizza using the factory
        Pizza pizza = pizzaFactory.createPizza();

        // Preparing, baking, cutting, and boxing the pizza
        pizza.preparation();
        pizza.baking();
        pizza.cutting();
        pizza.boxing();
    }
}

