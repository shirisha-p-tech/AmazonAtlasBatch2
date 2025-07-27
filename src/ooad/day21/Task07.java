package ooad.day21;
import java.util.ArrayList;
import java.util.List;

// Home Task - ISP Implementation - Bank and Loan Payments

// Payment interface
interface Payment {
    Object status();
    List<Object> getListOfPayment();
}

// Bank Interface
interface Bank {
    void initiatePayment();
    void stopPayment();
}

// Loan interface
interface Loan {
    void initiateRepayment();
    void initiateFinalSettlement();
}

// Implementing classes

class BankPayment implements Payment, Bank {

    @Override
    public Object status() {
        System.out.println("Bank payment status checked");
        return "Status: Success";
    }

    @Override
    public List<Object> getListOfPayment() {
        System.out.println("Fetching list of Bank Payments");
        return new ArrayList<>();
    }

    @Override
    public void initiatePayment() {
        System.out.println("Initiating Bank Payment");
    }

    @Override
    public void stopPayment() {
        System.out.println("Stopping Bank Payment");
    }
}

class LoanPayment implements Payment, Loan {

    @Override
    public Object status() {
        System.out.println("Loan payment status checked");
        return "Status: Pending";
    }

    @Override
    public List<Object> getListOfPayment() {
        System.out.println("Fetching list of Loan Payments");
        return new ArrayList<>();
    }

    @Override
    public void initiateRepayment() {
        System.out.println("Initiating Loan Repayment");
    }

    @Override
    public void initiateFinalSettlement() {
        System.out.println("Initiating Final Loan Settlement");
    }
}

public class Task07 {
    public static void main(String[] args) {

        System.out.println("===BANK PAYMENT OPERATIONS===");
        BankPayment bank = new BankPayment();
        bank.initiatePayment();
        bank.status();
        bank.getListOfPayment();
        bank.stopPayment();


        System.out.println("\n===LOAN PAYMENT OPERATIONS===");
        LoanPayment loan = new LoanPayment();
        loan.initiateRepayment();
        loan.status();
        loan.getListOfPayment();
        loan.initiateFinalSettlement();
    }
}