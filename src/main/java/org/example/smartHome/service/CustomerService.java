package org.example.smartHome.service;

import org.example.smartHome.model.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles customer registration, login, and email verification.
 */

public class CustomerService {
    private Map<String, Customer> customersByEmail = new HashMap<>();

    // Registers a new customer with the given details.
    public boolean registerCustomer(String fullName, String email, String password) {

        if (customersByEmail.containsKey(email)) {
            return false;
        }
        customersByEmail.put(email, new Customer(fullName, email, password));
        return true;
    }

    //  Authenticates a customer using email and password.
    public Customer login(String email, String password) {
        Customer customer = customersByEmail.get(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }

    // Checks if an email is already registered.
    public boolean isEmailRegistered(String email) {
        return customersByEmail.containsKey(email);
    }
}

