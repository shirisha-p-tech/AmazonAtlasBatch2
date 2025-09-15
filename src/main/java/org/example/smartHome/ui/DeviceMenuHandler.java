package org.example.smartHome.ui;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.service.DeviceService;

import java.util.Scanner;

/**
 * Handles the device registration menu and user inputs for various device types.
 */

public class DeviceMenuHandler {
    private final Scanner scanner;
    private final DeviceService deviceService;
    private final Customer customer;

    public DeviceMenuHandler(DeviceService deviceService, Customer customer, Scanner scanner) {
        this.deviceService = deviceService;
        this.customer = customer;
        this.scanner = scanner;

    }

    // Displays the device registration menu to the user.
    public void showRegisterMenu() {
        while (true) {
            System.out.println("\n=== Register Device ===");
            System.out.println("1. TV");
            System.out.println("2. AC");
            System.out.println("3. Fan");
            System.out.println("4. Robo Vac & Mop");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> registerTV();
                case 2 -> registerAC();
                case 3 -> registerFan();
                case 4 -> registerRoboVacMop();
                case 5 -> { return; } // back to dashboard
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Registers TV for given model and room options
    private void registerTV() {
        System.out.print("Enter Model/Name of the TV (Samsung/Sony): ");
        String model = scanner.nextLine().trim();
        if (!(model.equalsIgnoreCase("Samsung") || (model.equalsIgnoreCase("Sony")))) {
            System.out.println("Invalid TV model. Allowed: Samsung, Sony.");
            return;
        }

        String room = askRoom();
        if (room == null) return;

        Device device = deviceService.registerDevice(customer, model, "TV", room);
        System.out.println("TV of model "+device.getModel()+" for "+device.getRoom()+ " is registered successfully with Device ID " + device.getDeviceId());
    }

    // Registers AC for given model and room options
    private void registerAC() {
        System.out.print("Enter Model/Name of the AC (LG/Voltas/Blue Star): ");
        String model = scanner.nextLine().trim();
        if (!model.equalsIgnoreCase("LG")
                && !model.equalsIgnoreCase("Voltas")
                && !model.equalsIgnoreCase("Blue Star")) {
            System.out.println("Invalid AC model. Allowed: LG, Voltas, Blue Star.");
            return;
        }

        String room = askRoom();
        if (room == null) return;

        Device device = deviceService.registerDevice(customer, model, "AC", room);
        System.out.println("AC of model "+device.getModel()+" for "+device.getRoom()+ " is registered successfully with Device ID " + device.getDeviceId());
    }

    // // Registers Fan for given model and room options
    private void registerFan() {
        System.out.print("Enter Model/Name of the Fan (Atomberg/Crompton): ");
        String model = scanner.nextLine().trim();
        if (!model.equalsIgnoreCase("Atomberg") && !model.equalsIgnoreCase("Crompton")) {
            System.out.println("Invalid Fan model. Allowed: Atomberg, Crompton.");
            return;
        }

        String room = askRoom();
        if (room == null) return;

        Device device = deviceService.registerDevice(customer, model, "Fan", room);
        System.out.println("Fan of model "+device.getModel()+" for "+device.getRoom()+ " is registered successfully with Device ID " + device.getDeviceId());
    }

    // Registers Robo Vac & Mop for given model and room options
    private void registerRoboVacMop() {
        System.out.print("Enter Model/Name of the Robo Vac & Mop (Robo Vac & Mop): ");
        String model = scanner.nextLine().trim();

        if (!model.equalsIgnoreCase("Robo Vac & Mop")) {
            System.out.println("Invalid Robo Vac & Mop model. Allowed: Robo Vac & Mop.");
            return;
        }

        String room = askRoom();
        if (room == null) return;

        Device device = deviceService.registerDevice(customer, model, "RoboVacMop", room);
        System.out.println("Robo Vac & Mop for "+device.getRoom()+" is registered successfully with Device ID " + device.getDeviceId());
    }

    // Asks the user to input a valid room name.
    private String askRoom() {
        System.out.print("Enter Room Name (HallWay/BedRoom1/BedRoom2/BedRoom3): ");
        String room = scanner.nextLine().trim();
        if (!(room.equalsIgnoreCase("HallWay")
                || room.equalsIgnoreCase("BedRoom1")
                || room.equalsIgnoreCase("BedRoom2")
                || room.equalsIgnoreCase("BedRoom3"))) {
            System.out.println("Invalid room. Allowed: HallWay, BedRoom1, BedRoom2, BedRoom3.");
            return null;
        }
        return room;
    }
}
