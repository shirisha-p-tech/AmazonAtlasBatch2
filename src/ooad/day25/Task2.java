package ooad.day25;

// Composite Design Pattern — Company Hierarchy

import java.util.ArrayList;
import java.util.List;

// Base Component
interface Company {
    void displayName();
}

// Composite Component
class CompanyHead implements Company {
    private int id;
    private String name;
    private List<Company> subDepartments;

    public CompanyHead(int id, String name) {
        this.id = id;
        this.name = name;
        this.subDepartments = new ArrayList<>();
    }

    @Override
    public void displayName() {
        System.out.println("Company Head - ID: " + id + ", Name: " + name);
        subDepartments.forEach(Company::displayName);
    }

    public void addDepartment(Company company) {
        subDepartments.add(company);
    }

    public void removeDepartment(Company company) {
        subDepartments.remove(company);
    }
}

// Leaf Component: Software Department
class Software implements Company {
    private int id;
    private String name;

    public Software(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void displayName() {
        System.out.println("Department - ID: " + id + ", Name: " + name);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}

// Leaf Component: HR Department
class HR implements Company {
    private int id;
    private String name;

    public HR(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void displayName() {
        System.out.println("Department - ID: " + id + ", Name: " + name);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}

// Main class
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
