package org.example.smartHome.repository;

import org.example.smartHome.model.SensorData;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for accessing the SensorData table in DynamoDB.
 * Supports saving sensor readings, querying by timestamp range, and fetching latest readings.
 */
public class SensorDataRepository {
    private final DynamoDbTable<SensorData> table;

    // Constructor initializes DynamoDB table binding
    public SensorDataRepository() {
        this.table = DynamoDbConfig.getEnhancedClient()
                .table("SensorData", TableSchema.fromBean(SensorData.class));
    }

    // Saves a new sensor reading
    public void save(SensorData data) {
        table.putItem(data);
    }

    // Queries sensor readings in a timestamp range for a device
    public List<SensorData> queryRange(String deviceId, String from, String to) {
        QueryConditional condition = QueryConditional.sortBetween(
                Key.builder().partitionValue(deviceId).sortValue(from).build(),
                Key.builder().partitionValue(deviceId).sortValue(to).build()
        );

        List<SensorData> readings = new ArrayList<>();
        SdkIterable<Page<SensorData>> results = table.query(r -> r.queryConditional(condition));

        for (Page<SensorData> page : results) {
            readings.addAll(page.items());
        }
        return readings;
    }

    // Retrieves the latest N readings for a device
    public List<SensorData> getLatest(String deviceId, int limit) {
        QueryConditional condition = QueryConditional.keyEqualTo(
                Key.builder().partitionValue(deviceId).build()
        );

        List<SensorData> readings = new ArrayList<>();
        SdkIterable<Page<SensorData>> results = table.query(QueryEnhancedRequest.builder()
                .queryConditional(condition)
                .scanIndexForward(false) // descending order by timestamp
                .build());

        for (Page<SensorData> page : results) {
            readings.addAll(page.items());
        }

        // manually limit the size
        if (readings.size() > limit) {
            return readings.subList(0, limit);
        }
        return readings;
    }
}
