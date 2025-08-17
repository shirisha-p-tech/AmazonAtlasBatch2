package designpatterns.structural.day25.facade;

// Facade Design Pattern — Payment and Shopping Facade

// Client
public class Task3 {
    public static void main(String[] args) {
        System.out.println("Facade Design Pattern - Structural DP");

        MallFacade mallFacade = new MallFacade();

        mallFacade.getItems("Fruits");
        mallFacade.transferMoney("123", "7777", 500.0);
        mallFacade.payBill("123", "bill-44", 500.0);
    }
}

