package org.example.smartHome.datastructures;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.service.DeviceService;

import java.util.List;

/**
 * Builds a network graph dynamically from registered devices in DynamoDB.
 */

public class GraphBuilderService {
    private final DeviceService deviceService;

    public GraphBuilderService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    // Build network topology for a customer
    public Graph buildNetwork(Customer customer) {
        Graph graph = new Graph();

        // Create a virtual Gateway node
        Node gateway = new Node("GW-" + customer.getCustomerId().substring(0, 5), "Gateway");
        graph.addNode(gateway);

        // Fetch all devices owned by the customer
        List<Device> devices = deviceService.listDevices(customer);

        // Loop through each device retrieved from the database and connect to central gateway
        for (Device device : devices) {
            Node deviceNode = new Node(device.getDeviceId().substring(0, 5), device.getType());
            graph.addNode(deviceNode);
            graph.connect(gateway, deviceNode);
        }

        return graph;
    }
}



