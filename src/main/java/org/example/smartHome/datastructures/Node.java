package org.example.smartHome.datastructures;

/**
 * Represents a node (device) in the Smart Home network graph.
 */
public class Node {

    private final String id;    // e.g., Device ID or Gateway ID
    private final String type;  // e.g., "TV", "AC", "Fan", "Gateway"

    // Constructor that initializes the node with an ID and a type
    public Node(String id, String type) {
        this.id = id;
        this.type = type;
    }

    // Getter method to retrieve the node’s unique ID
    public String getId() { return id; }

    // Getter method to retrieve the node’s type (device category)
    public String getType() { return type; }

    // Converts the node to a readable string (used in printNetwork)
    @Override
    public String toString() {
        return type + "(" + id + ")";
    }

    // Checks equality between two Node objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node other)) return false;
        return id.equals(other.id);
    }

    // Generates a unique hash code based on the node’s ID (used in HashMap)
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
