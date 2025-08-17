package designpatterns.structural.day25.composite;

import java.util.ArrayList;
import java.util.List;

// Composite Component
public class CompanyHead implements Company {
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
