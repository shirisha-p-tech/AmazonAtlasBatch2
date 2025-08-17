package designpatterns.behavioral.day26.strategy;

// Client code - Strategy DP - Payment methods example

public class Task01 {
    public static void main(String[] args) {
        System.out.println("Strategy Design Pattern - Behavioral DP - Payment methods");

        PaymentUsingStrategy payment;

        // Card Payment
        payment = new PaymentUsingStrategy(new CardPaymentConcreteStrategy());
        payment.process(100.00);

        // Cash Payment
        payment.setPaymentStrategy(new CashPaymentConcreteStrategy());
        payment.process(200.00);

        // UPI Payment
        payment.setPaymentStrategy(new UPIPaymentConcreteStrategy());
        payment.process(300.00);
    }
}

