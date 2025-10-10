package org.example.smartHome.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

/**
 * Represents a time-series sensor reading for a device.
 * Stored in DynamoDB "SensorData" table with deviceId as PK and timestamp as SK.
 */
@DynamoDbBean
public class SensorData {
    private String deviceId;     // Device ID
    private String timestamp;    // ISO timestamp (Sort Key)
    private Double value;        // Sensor reading value
    private String sensorType;   // e.g., Temperature, PowerUsage
    private Long expiresAt;      // TTL for auto-deletion

    // Gets the deviceId (Partition Key)
    @DynamoDbPartitionKey
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    // Gets the timestamp (Sort Key)
    @DynamoDbSortKey
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    // Gets the sensor value
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    // Gets the sensor type
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    // Gets the expiry timestamp
    public Long getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Long expiresAt) { this.expiresAt = expiresAt; }
}
