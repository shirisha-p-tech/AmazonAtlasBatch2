package org.example.smartHome.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;
import java.util.UUID;

/**
 * Represents a smart device in the system.
 * Stored in the DynamoDB "Devices" table with deviceId as the primary key.
 * A GSI on customerId (customerId-index) is used to query devices by owner.
 */
@DynamoDbBean
public class Device {
    private String deviceId;   // Unique device ID
    private String customerId; // Owner's customerId (used in GSI)
    private String model;      // Device model
    private String type;       // Device type (TV, AC, Fan, etc.)
    private String room;       // Room location
    private String status;     // ON or OFF

    // Default constructor required by DynamoDB SDK
    public Device() {}

    // Constructor to create a new device with generated UUID
    public Device(String customerId, String model, String type, String room) {
        this.deviceId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.model = model;
        this.type = type;
        this.room = room;
        this.status = "OFF"; // initial default status
    }

    // Gets the deviceId (Partition Key)
    @DynamoDbPartitionKey
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    // Gets the customerId (GSI: customerId-index)
    @DynamoDbSecondaryPartitionKey(indexNames = {"customerId-index"})
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    // Gets the model
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    // Gets the type
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // Gets the room
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }

    // Gets the status
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // String representation for printing
    @Override
    public String toString() {
        return type + " { " +
                "status=" + status +
                ", model='" + model + '\'' +
                ", room='" + room + '\'' +
                ", deviceID='" + getDeviceId().substring(0,5) +
                "....' }";
    }
}
