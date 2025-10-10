package org.example.smartHome.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;
import java.util.UUID;

/**
 * Represents a customer in the Smart Home system.
 * Stored in the DynamoDB "Customers" table with customerId as the primary key.
 * A GSI on email (email-index) is used for login queries.
 */
@DynamoDbBean
public class Customer {
    private String customerId;  // Unique customer ID
    private String fullName;    // Full name of the customer
    private String email;       // Email address (used for login)
    private String password;    // Customer password

    // Default constructor required by DynamoDB SDK
    public Customer() {}

    // Constructor to create a new Customer with generated UUID
    public Customer(String fullName, String email, String password) {
        this.customerId = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    // Gets the unique customerId (Partition Key in DynamoDB)
    @DynamoDbPartitionKey
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    // Gets the full name
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    // Gets the email (Secondary Partition Key for GSI: email-index)
    @DynamoDbSecondaryPartitionKey(indexNames = {"email-index"})
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Gets the password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
