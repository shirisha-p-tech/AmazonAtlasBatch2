# 🧩 Day 7 – Data Structures: Graph for IoT Network Topology

---

## Objective

On Day 7, graph data structure has been introduced to model the IoT Smart Home network.  
Each connected smart device is represented as a node, and its communication link to a gateway forms an edge.  
This helps us visualize and analyze device interconnections using algorithms such as BFS.

---

## Concept Overview

- Why Graph? 
  A Smart Home has multiple interconnected devices communicating via a central gateway.  
  Modeling this as a graph (devices = nodes, connections = edges) allows easy traversal, analysis, and visualization of network relationships.

- Types of nodes:
    - `Gateway` – central hub that connects all customer devices.
    - `Devices` – individual smart items such as TV, AC, Fan, etc.

- Graph representation: 
  Implemented using an Adjacency List for efficiency in storage and traversal.

---

## Components

1. `Node.java` - Represents each device or gateway in the network. Contains ID + Type.
2. `Graph.java`** - Maintains adjacency list, supports connecting nodes, printing topology, and traversing via BFS.
3. `GraphBuilderService.java` - Builds the full network dynamically from devices stored in DynamoDB using `DeviceService`.

---

## Example Flow

1. Customer logs in.
2. System fetches all registered devices via `DeviceService`.
3. A GraphBuilderService creates a `Gateway` node and links each device to it.
4. The graph is printed using `printNetwork()` and can be traversed with `BFS`.

---

## BFS used for analysis

BFS (Breadth-First Search)- Explores devices level by level from the gateway outward. 
Gateway → Fan → TV → AC

---

## Deliverable

Graph.java, GraphBuilderService.java, Node.java implemented and integrated with Main.java.
The dashboard now supports displaying and analyzing the Smart Home network topology.

