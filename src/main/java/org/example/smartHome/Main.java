package org.example.smartHome;

import org.example.smartHome.model.*;
import org.example.smartHome.service.*;
import org.example.smartHome.ui.DeviceMenuHandler;
import org.example.smartHome.util.ValidationUtil;

import java.util.Scanner;

// Driver class

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerService();
    private static final DeviceService deviceService = new DeviceService();
    private static Customer currentCustomer = null;


    // Driver method
    public static void main(String[] args)  {
        while (true) {
            if (currentCustomer == null) {
                showMainMenu();
            } else {
                showDashboardMenu();
            }
        }
    }

    // Main menu - register, login and exit
    private static void showMainMenu()  {
        System.out.println("\n=== IoT Smart Home ===");
        System.out.println("1. Signup");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        switch (choice) {
            case 1 -> signup();
            case 2 -> login();
            case 3 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid option.");
        }
    }

    // Signup
    private static void signup()  {
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        String email;
        while(true) {
            System.out.print("Email: ");
            email = scanner.nextLine();

            // Validate email format
            if (!ValidationUtil.isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email (e.g. user@gmail.com)");
                continue;
            }

            // Check if email is already registered
            if (customerService.isEmailRegistered(email)) {
                System.out.println("This email is already registered.");
                return;
            }
            break;
        }

        String pass1;
        while(true) {
            System.out.print("Password: ");
            pass1 = scanner.nextLine();

            // Validate password strength
            if (!ValidationUtil.isValidPassword(pass1)) {
                System.out.println("Password requirements");
                System.out.println("Atleast 8 characters long");
                System.out.println("Atleast 1 Uppercase letter");
                System.out.println("Atleast 1 Lowercase letter");
                System.out.println("Atleast 1 Digit");
                System.out.println("Atleast 1 Special character !,@#$%^&*");
                continue;
            }
            break;
        }
        String pass2;
        int count=0;
        while(true) {
            System.out.print("Confirm Password: ");
            pass2 = scanner.nextLine();

            if (!pass1.equals(pass2)) {
                count++;
                if(count==1) {
                    System.out.println("Passwords do not match. Please try again.");
                    continue;
                }
                else {
                    System.out.println("Passwords do not match. Sign up failed");
                }
            }
            break;
        }

        // Register only if passwords match
        if(pass1.equals(pass2)) {
            boolean success = customerService.registerCustomer(name, email, pass1);
            if (success) {
                System.out.println("Signed up successfully!");
            } else {
                System.out.println("Sign up failed.");
            }
        }
    }

    // Login
    private static void login()  {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Validate email format
        if (!ValidationUtil.isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter a valid email (e.g. user@gmail.com)");
            return;
        }

        // Check if email is not registered
        if (!customerService.isEmailRegistered(email)) {
            System.out.println("This email is not registered. Please register first.");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentCustomer = customerService.login(email, password);
        if (currentCustomer == null) {
            System.out.println("Invalid password. Login failed.");
        } else {
            System.out.println("Logged in successfully! Welcome, " + currentCustomer.getFullName() + "!");
        }
    }

    // Dashboard menu
    private static void showDashboardMenu() {

        System.out.println("\n=== Dashboard ===");
        System.out.println("1. Register Device");
        System.out.println("2. View Devices");
        System.out.println("3. Change Device Status");
        System.out.println("4. Logout");
        System.out.print("Choose option: ");
        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }


        switch (choice) {
            case 1 -> registerDevice();
            case 2 -> deviceService.listDevices(currentCustomer);

            case 3 -> changeDeviceStatus();
            case 4 -> {
                currentCustomer = null;
                System.out.println("Logged out.");
            }
            default -> System.out.println("Invalid option.");
        }
    }

    // To register devices
    private static void registerDevice() {

        DeviceMenuHandler menuHandler = new DeviceMenuHandler(deviceService, currentCustomer, scanner);
        menuHandler.showRegisterMenu();

    }

    // To change/toggle a device status
    private static void changeDeviceStatus() {
        if (currentCustomer.getDevices().isEmpty()) {
            System.out.println("No devices registered yet.");
            return;
        }

        System.out.println("Available devices are:");
        deviceService.listDevices(currentCustomer);

        int deviceIndex = -1;

        // Loop until valid input is received
        while (true) {

            System.out.print("\nEnter the option to select a device: ");
            try {
                deviceIndex = Integer.parseInt(scanner.nextLine());

                // Validate range
                if (deviceIndex < 0 || deviceIndex > currentCustomer.getDevices().size()) {
                    System.out.println("Invalid option. Please select a valid device index.");
                } else {
                    break; // Valid input, exit loop
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Change device status
        Device device = deviceService.changeDeviceStatus(currentCustomer, deviceIndex);

        if (device.getStatus() == DeviceStatus.ON) {
            System.out.println("\nDevice " + device.getType() + " of " + device.getRoom() + " switched ON successfully");
        } else {
            System.out.println("\nDevice " + device.getType() + " of " + device.getRoom() + " switched OFF successfully");
        }

        System.out.println("\nDevices list after changing status");
        deviceService.listDevices(currentCustomer);
    }
}



