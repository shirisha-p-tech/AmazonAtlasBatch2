package org.example.smartHome.repository;

import org.example.smartHome.model.Customer;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

/**
 * Repository for accessing the Customers table in DynamoDB.
 * Supports saving, fetching by ID, and querying by email (via GSI).
 */
public class CustomerRepository {
    private final DynamoDbTable<Customer> table;

    // Constructor initializes DynamoDB table binding
    public CustomerRepository() {
        this.table = DynamoDbConfig.getEnhancedClient()
                .table("Customers", TableSchema.fromBean(Customer.class));
    }

    // Saves a new customer to the table
    public void save(Customer customer) {
        table.putItem(customer);
    }

    // Retrieves a customer by customerId
    public Customer getById(String customerId) {
        return table.getItem(r -> r.key(k -> k.partitionValue(customerId)));
    }

    // Retrieves a customer by email using GSI "email-index"
    public Customer getByEmail(String email) {
        DynamoDbIndex<Customer> index = table.index("email-index");

        SdkIterable<Page<Customer>> results = index.query(r -> r.queryConditional(
                QueryConditional.keyEqualTo(k -> k.partitionValue(email)))
        );

        for (Page<Customer> page : results) {
            for (Customer c : page.items()) {
                return c; // return the first match
            }
        }
        return null;
    }
}
