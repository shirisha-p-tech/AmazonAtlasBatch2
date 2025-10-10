package org.example.smartHome.service;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.repository.DeviceRepository;

import java.util.List;

/**
 * Service layer for managing devices.
 */
public class DeviceService {
    private final DeviceRepository repo;

    // Default constructor (for Main.java)
    public DeviceService() {
        this.repo = new DeviceRepository();
    }

    // Overloaded constructor (for tests)
    public DeviceService(DeviceRepository repo) {
        this.repo = repo;
    }



    public Device registerDevice(Customer customer, String model, String type, String room) {
        try {
            Device device = new Device(customer.getCustomerId(), model, type, room);
            repo.save(device);
            return device;
        } catch (Exception e) {
            System.out.println("Error registering device: " + e.getMessage());
            return null; // return null to indicate failure
        }
    }


    // List all devices for customer
    public List<Device> listDevices(Customer customer) {
        return repo.listByCustomer(customer.getCustomerId());
    }


     // Toggles the status of the given device and updates it in DynamoDB.
    public boolean changeDeviceStatus(Device device) {
        try {
            // Determine new status (toggle ON/OFF)
            String newStatus = device.getStatus().equals("OFF") ? "ON" : "OFF";

            // Send command to the device server
            String response = org.example.smartHome.network.DeviceNetworkClient
                    .sendCommand("CHANGE_STATUS  Device_ID  " + device.getDeviceId());

            // If server response is OK, update DB
            if ("SUCCESS".equalsIgnoreCase(response)) {
                device.setStatus(newStatus);
                repo.update(device); // Save updated device status to DynamoDB
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error toggling device: " + e.getMessage());
            return false;
        }
    }

}
