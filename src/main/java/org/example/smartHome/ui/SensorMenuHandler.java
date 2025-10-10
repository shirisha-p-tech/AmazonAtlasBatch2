package org.example.smartHome.ui;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.service.DeviceService;
import org.example.smartHome.service.SensorService;

import java.util.List;
import java.util.Scanner;

/**
 * Handles the Sensor Data menu operations in the console.
 * Allows adding sensor readings, querying by range, and fetching latest readings.
 */
public class SensorMenuHandler {
    private final Scanner scanner;
    private final SensorService sensorService;
    private final DeviceService deviceService;
    private final Customer customer;

    // Constructor
    public SensorMenuHandler(SensorService sensorService, DeviceService deviceService, Customer customer, Scanner scanner) {
        this.sensorService = sensorService;
        this.deviceService = deviceService;
        this.customer = customer;
        this.scanner = scanner;
    }

    // Shows the sensor menu
    public void showSensorMenu() {
        while (true) {
            System.out.println("\n=== Sensor Data ===");
            System.out.println("1. Add Reading");
            System.out.println("2. Query Range");
            System.out.println("3. Get Latest N Readings");
            System.out.println("4. Back");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addSensorReading();
                case 2 -> querySensorRange();
                case 3 -> getLatestReadings();
                case 4 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Utility method: show devices and return chosen deviceId (or null if none)
    private String selectDevice() {
        List<Device> devices = deviceService.listDevices(customer);

        if (devices.isEmpty()) {
            System.out.println("No devices available. Please register one first.");
            return null;
        }

        System.out.println("\n=== Your Devices ===");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i));
        }
        System.out.print("Choose option to select device: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice <= 0 || choice > devices.size()) {
                System.out.println("Invalid device choice.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return null;
        }

        return devices.get(choice - 1).getDeviceId();
    }

    // Adds a new sensor reading for a selected device
    private void addSensorReading() {
        String deviceId = selectDevice();
        if (deviceId == null) return; // stop if no device selected

        System.out.print("Enter sensor type (Temperature / PowerUsage): ");
        String sensorType = scanner.nextLine();

        if (!(sensorType.equalsIgnoreCase("Temperature") ||
                sensorType.equalsIgnoreCase("PowerUsage"))) {
            System.out.println("Invalid sensor type. Allowed: Temperature, PowerUsage");
            return;
        }

        System.out.print("Enter sensor value (number): ");
        double value;
        try {
            value = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input for value.");
            return;
        }

        sensorService.addReading(deviceId, sensorType, value, null);
        System.out.println("Sensor reading added successfully.");
    }

    // Queries readings between two timestamps
    private void querySensorRange() {
        String deviceId = selectDevice();
        if (deviceId == null) return;

        System.out.print("Enter start timestamp (ISO, e.g., 2025-10-03T12:00:00Z): ");
        String from = scanner.nextLine();

        System.out.print("Enter end timestamp (ISO, e.g., 2025-10-03T15:00:00Z): ");
        String to = scanner.nextLine();

        var readings = sensorService.queryRange(deviceId, from, to);
        if (readings.isEmpty()) {
            System.out.println("No readings found in the range.");
        } else {
            readings.forEach(r ->
                    System.out.println(r.getTimestamp() + " -> " + r.getSensorType() + " = " + r.getValue())
            );
        }
    }

    // Gets the latest N readings for a selected device
    private void getLatestReadings() {
        String deviceId = selectDevice();
        if (deviceId == null) return;

        System.out.print("Enter N (number of latest readings): ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        var readings = sensorService.getLatest(deviceId, n);
        if (readings.isEmpty()) {
            System.out.println("No readings found.");
        } else {
            readings.forEach(r ->
                    System.out.println(r.getTimestamp() + " -> " + r.getSensorType() + " = " + r.getValue())
            );
        }
    }
}
