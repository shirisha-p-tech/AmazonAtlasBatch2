package org.example.smartHome.service;

import org.example.smartHome.model.Customer;
import org.example.smartHome.repository.CustomerRepository;

/**
 * Service layer for managing customers.
 * Provides methods for registration and login.
 */
public class CustomerService {
    private final CustomerRepository repo;

    // Default constructor (used by Main.java)
    public CustomerService() {
        this.repo = new CustomerRepository();
    }

    // Overloaded constructor (used for unit testing with mocks)
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    // Gets the Customer email from DynamoDB
    public Customer getCustomerByEmail(String email){
        return repo.getByEmail(email);
    }

    // Registers a new Customer
    public boolean registerCustomer(String fullName, String email, String password) {
        try {
            // Attempt to save the customer into DynamoDB
            repo.save(new Customer(fullName, email, password));
            return true;  // success
        } catch (Exception e) {
            // If DynamoDB or repository fails
            System.out.println("Error saving customer: " + e.getMessage());
            return false; // failure
        }
    }

    // Login using email + password
    public boolean login(String email, String password, Customer customer) {
        if (customer != null && customer.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


}
