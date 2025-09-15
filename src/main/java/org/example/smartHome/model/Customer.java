package org.example.smartHome.model;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a customer in the Smart Home system.
 * Each customer has a unique ID, personal details, and a list of smart devices.
 */

public class Customer {
    private UUID customerId;
    private String fullName;
    private String email;
    private String password;
    private List<Device> devices;

    // Constructs a new Customer with the given details and initializes an empty device list.
    public Customer(String fullName, String email, String password) {
        this.customerId = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.devices = new ArrayList<>();
    }

    // Returns the unique ID of the customer.
    public UUID getCustomerId() {
        return customerId;
    }

    // Returns the full name of the customer.
    public String getFullName() {
        return fullName;
    }

    // Returns the email of the customer.
    public String getEmail() {
        return email;
    }

    // Returns the password of the customer.
    public String getPassword() {
        return password;
    }

    // Returns the list of devices owned by the customer.
    public List<Device> getDevices() {
        return devices;
    }

    // Adds a new device to the customer's list.
    public void addDevice(Device device) {
        devices.add(device);
    }
}

