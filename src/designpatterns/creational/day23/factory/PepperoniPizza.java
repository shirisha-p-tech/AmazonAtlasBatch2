package designpatterns.creational.day23.factory;

// Concrete Product
public class PepperoniPizza implements Pizza {

    @Override
    public void preparation() {
        System.out.println("Preparing Pepperoni Pizza...");
    }

    @Override
    public void baking() {
        System.out.println("Baking Pepperoni Pizza...");
    }

    @Override
    public void cutting() {
        System.out.println("Cutting Pepperoni Pizza...");
    }

    @Override
    public void boxing() {
        System.out.println("Boxing Pepperoni Pizza...");
    }
}

