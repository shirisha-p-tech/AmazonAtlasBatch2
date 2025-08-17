package designpatterns.structural.day25.facade;

// Banking service: handles money transfers
public class BankingService {
    public void transferMoney(String fromAccountId, String toAccountId, double amount) {
        System.out.println("Transferring " + amount + " from account " + fromAccountId + " to account " + toAccountId);
    }
}
