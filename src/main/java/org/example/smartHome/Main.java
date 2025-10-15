package org.example.smartHome;

import org.example.smartHome.datastructures.Graph;
import org.example.smartHome.datastructures.GraphBuilderService;
import org.example.smartHome.datastructures.Node;
import org.example.smartHome.model.*;
import org.example.smartHome.service.*;
import org.example.smartHome.ui.DeviceMenuHandler;
import org.example.smartHome.ui.SensorMenuHandler;
import org.example.smartHome.util.ValidationUtil;


import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// Driver class


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerService();
    private static final DeviceService deviceService = new DeviceService();
    private static final SensorService sensorService = new SensorService();
    private static Customer currentCustomer = null;


    // Driver method
    public static void main(String[] args) {

        System.out.println("\n=== IoT Smart Home Application===");
        // Application flow
        while (true) {
            if (currentCustomer == null) {
                showMainMenu();
            } else {
                showDashboardMenu();
            }
        }
    }

    // Main menu - register, login and exit
    private static void showMainMenu() {
        System.out.println("\n==== MainMenu ====");
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
    private static void signup() {
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();

            // Validate email format
            if (!ValidationUtil.isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email (e.g. user@gmail.com)");
                continue;
            }


            currentCustomer = customerService.getCustomerByEmail(email);
            if(currentCustomer!=null){
                System.out.println("This email is already registered.");
                currentCustomer=null;
                return;
            }
            break;
        }

        String pass1;
        while (true) {
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
                System.out.println("\nPress 'Y' to retry or 'N' to exit");
                String ch = scanner.nextLine();
                if(ch.equalsIgnoreCase("y"))
                    continue;
                else {
                    System.out.println("Sign up failed");
                    return;
                }
            }
            break;
        }
        String pass2;
        int count = 0;
        while (true) {
            System.out.print("Confirm Password: ");
            pass2 = scanner.nextLine();

            if (!pass1.equals(pass2)) {
                count++;
                if (count == 1) {
                    System.out.println("Passwords do not match. Please try again.");
                    continue;
                } else {
                    System.out.println("Passwords do not match. Sign up failed");
                }
            }
            break;
        }

        // Register only if passwords match
        if (pass1.equals(pass2)) {
            boolean success = customerService.registerCustomer(name, email, pass1);
            if (success) {
                System.out.println("Signed up successfully!");
            } else {
                System.out.println("Sign up failed.");
            }
        }
    }



    // Login
    private static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Validate email format
        if (!ValidationUtil.isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter a valid email (e.g. user@gmail.com)");
            return;
        }

        currentCustomer = customerService.getCustomerByEmail(email);
        if(currentCustomer==null){
            System.out.println("This email is not registered. Please register first.");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean result = customerService.login(email, password, currentCustomer);
        if (result) {
            System.out.println("Logged in successfully! Welcome, " + currentCustomer.getFullName() + "!");
        } else {
            System.out.println("Invalid password. Login failed.");
            currentCustomer=null;
        }
    }

    // Dashboard menu
    private static void showDashboardMenu() {

        System.out.println("\n\n==== Dashboard Menu ====");
        System.out.println("1. Register Device");
        System.out.println("2. View Devices");
        System.out.println("3. Change Device Status");
        System.out.println("4. Sensor Data");
        System.out.println("5. View Graph-Network Topology");
        System.out.println("6. Logout");
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
            case 2 -> viewDevices();
            case 3 -> changeDeviceStatus();
            case 4 -> openSensorMenu();
            case 5 -> showNetworkTopology();
            case 6 -> logout();
            default -> System.out.println("Invalid option.");
        }
    }

    // To register devices
    private static void registerDevice() {

        DeviceMenuHandler menuHandler = new DeviceMenuHandler(deviceService, currentCustomer, scanner);
        menuHandler.showRegisterMenu();

    }

    // Displays all devices for the logged-in customer
    private static void viewDevices() {
        var devices = deviceService.listDevices(currentCustomer);

        if (devices.isEmpty()) {
            System.out.println("No devices registered yet.");
        } else {
            System.out.println("\n=== My Devices ===");
            for (int i = 0; i < devices.size(); i++) {
                System.out.println((i + 1) + ". " + devices.get(i));
            }
        }
    }

    // Change/toggle a device status (delegated to DeviceService)
    private static void changeDeviceStatus() {
        var devices = deviceService.listDevices(currentCustomer);

        if (devices.isEmpty()) {
            System.out.println("No devices registered yet.");
            return;
        }

        System.out.println("Available devices:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i));
        }

        int deviceIndex;
        while (true) {
            System.out.print("\nEnter the option to select a device: ");
            try {
                deviceIndex = Integer.parseInt(scanner.nextLine());
                if (deviceIndex <= 0 || deviceIndex > devices.size()) {
                    System.out.println("Invalid option. Please select a valid device index.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Pick the selected device from the list
        Device selectedDevice = devices.get(deviceIndex - 1);

        // Delegate actual status toggle logic to DeviceService
        var success = deviceService.changeDeviceStatus(selectedDevice);

        if (success) {
            System.out.println("\nDevice " + selectedDevice.getType() + " in " +
                    selectedDevice.getRoom() + " switched " + selectedDevice.getStatus() + " successfully.");

            System.out.println("\nDevices list after changing status:");
            for (int i = 0; i < devices.size(); i++) {
                System.out.println((i + 1) + ". " + devices.get(i));
            }
        } else {
            System.out.println("Server failed to update device status.");
        }
    }

    // opens the sensor menu in SensorMenuHandler class
    private static void openSensorMenu(){

        if (deviceService.listDevices(currentCustomer).isEmpty()) {
            System.out.println("No devices registered yet.");
        } else {
            SensorMenuHandler sensorMenu = new SensorMenuHandler(sensorService, deviceService, currentCustomer, scanner);
            sensorMenu.showSensorMenu();
        }

    }

    // Displays the Smart Home Network Topology using Graphs
    private static void showNetworkTopology() {
        GraphBuilderService graphBuilder = new GraphBuilderService(deviceService);
        Graph graph = graphBuilder.buildNetwork(currentCustomer);

        // Check if only the gateway exists (no connected devices)
        if (graph.getNodes().size() <= 1) {
            System.out.println("No devices found in your network.");
            return;
        }


        graph.printNetwork();

        // show traversal
        System.out.println("\nSimulating BFS traversal from Gateway...");
        String gatewayId = "GW-" + currentCustomer.getCustomerId().substring(0, 5);
        graph.traverseBFS(new Node(gatewayId, "Gateway"));


    }

    // Customer Logout
    private static void logout(){
        currentCustomer = null;
        System.out.println("Logged out.");
    }




}


