package designpatterns.structural.day25.facade;

// Billing service: handles payment
public class BillingCounterService {
    public void payBill(String accountId, String billId, double amount) {
        System.out.println("Paying for Mangoes " + amount + " for billId " + billId + " from account " + accountId);
    }
}
