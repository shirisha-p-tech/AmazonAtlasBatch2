package org.example.smartHome.repository;

import org.example.smartHome.model.Device;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for accessing the Devices table in DynamoDB.
 * Supports saving, updating, and fetching devices by customerId (via GSI).
 */
public class DeviceRepository {
    private final DynamoDbTable<Device> table;

    // Constructor initializes DynamoDB table binding
    public DeviceRepository() {
        this.table = DynamoDbConfig.getEnhancedClient()
                .table("Devices", TableSchema.fromBean(Device.class));
    }

    // Saves a new device to the table
    public void save(Device device) {
        table.putItem(device);
    }

    // Updates an existing device (overwrites record in DynamoDB)
    public void update(Device device) {
        table.putItem(device); // putItem will overwrite if the PK exists
    }

    // Retrieves all devices for a customer using GSI "customerId-index"
    public List<Device> listByCustomer(String customerId) {
        DynamoDbIndex<Device> index = table.index("customerId-index");
        List<Device> devices = new ArrayList<>();

        SdkIterable<Page<Device>> results = index.query(r -> r.queryConditional(
                QueryConditional.keyEqualTo(k -> k.partitionValue(customerId)))
        );

        for (Page<Device> page : results) {
            devices.addAll(page.items());
        }

        return devices;
    }
}
