package designpatterns.behavioral.day26.strategy;

// Concrete Strategy

public class CardPaymentConcreteStrategy implements PaymentStrategy {
    public void process(double price) {
        System.out.println("Payment processing using card: $" + price);
    }
}

