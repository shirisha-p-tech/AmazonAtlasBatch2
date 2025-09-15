package org.example.smartHome.model;

import java.util.UUID;

/**
 * Represents a smart device in the system.
 * Each device has a unique id, model, type, room location, and an ON/OFF status.
 */

public class Device {
    private UUID deviceId;
    private String model;
    private String type;
    private String room;
    private DeviceStatus status;

    // Constructs a Device with specified model, type, and room.
    public Device(String model, String type, String room) {
        this.deviceId = UUID.randomUUID(); // Unique identifier
        this.model = model;
        this.type = type;
        this.room = room;
        this.status = DeviceStatus.OFF; // default status
    }

    // Returns the unique ID of the device.
    public UUID getDeviceId() {
        return deviceId;
    }

    // Returns the model name of the device.
    public String getModel() {
        return model;
    }

    // Returns the type of the device.
    public String getType() {
        return type;
    }

    // Returns the room where the device is installed.
    public String getRoom() {
        return room;
    }

    // Returns the current status (ON/OFF) of the device.
    public DeviceStatus getStatus() {
        return status;
    }

    // Sets the current status of the device.
    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    // Returns a string representation of the device.
    @Override
    public String toString() {
        return  type + " {" +
                " model='" + model + '\'' +
                ", room='" + room + '\'' +
                ", status=" + status +
                " }";
    }
}

