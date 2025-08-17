package designpatterns.structural.day25.decorator;

// Home Task - Decorator Design Pattern — Pizza Toppings Example

// Client
public class Task7 {
    public static void main(String[] args) {
        Pizza myPizza = new PlainPizza();
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.getCost());

        myPizza = new Cheese(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.getCost());

        myPizza = new Olives(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.getCost());
    }
}




