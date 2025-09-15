package org.example.smartHome.service;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.model.DeviceStatus;

/**
 * Handles operations related to smart devices like registration, status change, and listing.
 */

public class DeviceService {

    // Registers a device for a customer
    public Device registerDevice(Customer customer, String model, String type, String room) {
        Device device = new Device(model, type, room);
        customer.addDevice(device);
        return device;
    }

    // Changes the status of a specific device
    public Device changeDeviceStatus(Customer customer, int deviceIndex) {

        Device device = customer.getDevices().get(deviceIndex-1);
        DeviceStatus newStatus = (device.getStatus() == DeviceStatus.OFF) ? DeviceStatus.ON : DeviceStatus.OFF;
        device.setStatus(newStatus);
        return device;
    }

    // Prints the list of devices registered by a customer.
    public void listDevices(Customer customer) {
        if (customer.getDevices().isEmpty()) {
            System.out.println("No devices registered yet.");
        } else {
            int i = 0;
            for (Device device : customer.getDevices()) {
                System.out.println((++i) + ". " + device);

            }
        }
    }
}
