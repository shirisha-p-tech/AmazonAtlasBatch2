package designpatterns.structural.day25.composite;

// Composite Design Pattern — Company Hierarchy

// Client
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Composite Design Pattern - Structural DP");

        Company softDept = new Software(101, "Software Department");
        Company hrDept = new HR(102, "HR Department");

        CompanyHead companyHead = new CompanyHead(1, "ABC Company");

        companyHead.addDepartment(softDept);
        companyHead.addDepartment(hrDept);

        companyHead.displayName();
    }
}
