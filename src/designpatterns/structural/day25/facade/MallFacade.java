package designpatterns.structural.day25.facade;

// Facade class
public class MallFacade {
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
