package ooad.day25;

// Facade Design Pattern — Payment and Shopping Facade

// Billing service: handles payment
class BillingCounterService {
    public void payBill(String accountId, String billId, double amount) {
        System.out.println("Paying for Mangoes " + amount + " for billId " + billId + " from account " + accountId);
    }
}

// Store staff service: handles item selection
class StoreStaffService {
    public void getItems(String items) {
        System.out.println("Selecting Mangoes");
    }
}

// Banking service: handles money transfers
class BankingService {
    public void transferMoney(String fromAccountId, String toAccountId, double amount) {
        System.out.println("Transferring " + amount + " from account " + fromAccountId + " to account " + toAccountId);
    }
}

// Facade class
class MallFacade {
    private StoreStaffService storeStaffService;
    private BillingCounterService billingCounterService;
    private BankingService bankingService;

    public MallFacade() {
        this.storeStaffService = new StoreStaffService();
        this.billingCounterService = new BillingCounterService();
        this.bankingService = new BankingService();
    }

    public void getItems(String items) {
        storeStaffService.getItems(items);
    }

    public void payBill(String accountId, String billId, double amount) {
        billingCounterService.payBill(accountId, billId, amount);
    }

    public void transferMoney(String fromAccountId, String toAccountId, double amount) {
        bankingService.transferMoney(fromAccountId, toAccountId, amount);
    }
}

// Main class
public class Task3 {
    public static void main(String[] args) {
        System.out.println("Facade Design Pattern - Structural DP");

        MallFacade mallFacade = new MallFacade();

        mallFacade.getItems("Fruits");
        mallFacade.transferMoney("123", "7777", 500.0);
        mallFacade.payBill("123", "bill-44", 500.0);
    }
}

