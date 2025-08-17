package designpatterns.behavioral.day26.strategy;

// Context class
public class PaymentUsingStrategy {
    private PaymentStrategy paymentStrategy;

    public PaymentUsingStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void process(double price) {
        paymentStrategy.process(price);
    }

    // allows changing strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}


