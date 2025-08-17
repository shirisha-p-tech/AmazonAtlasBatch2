package designpatterns.behavioral.day26.strategy;

public class UPIPaymentConcreteStrategy implements PaymentStrategy {
    public void process(double price) {
        System.out.println("Payment processing using UPI: $" + price);
    }
}

