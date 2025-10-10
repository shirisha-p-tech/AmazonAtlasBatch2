package org.example.smartHome.datastructures;

import java.util.*;

/**
 * Represents the IoT network topology as a graph (Adjacency List).
 * Devices are nodes, and their relationships are edges.
 */

public class Graph {
    // The adjacency list stores each node (key) and a list of connected nodes (value)
    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    // Add a device (node) to the graph
    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Connect two nodes bidirectionally
    public void connect(Node a, Node b) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
    }

    // Print all device connections
    public void printNetwork() {
        System.out.println("\n=== Smart Home Network Topology ===");
        for (Node node : adjacencyList.keySet()) {
            System.out.print(node + " -> ");
            List<Node> connections = adjacencyList.get(node);
            System.out.println(connections);
        }
    }

    // BFS traversal from a given start node
    public void traverseBFS(Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS traversal starting from " + start + ":");

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Remove the first node from the queue
            System.out.print(current + " ");

            // Explore all neighbors of the current node
            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Check if two nodes are directly connected
    public boolean isConnected(Node a, Node b) {
        return adjacencyList.getOrDefault(a, List.of()).contains(b);
    }

    // Get all nodes
    public Set<Node> getNodes() {
        return adjacencyList.keySet();
    }
}
