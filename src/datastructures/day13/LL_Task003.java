//SinglyLinkedList Creation and Operations
package datastructures.day13;

// Define a Node class
class Node {
    int data;  // Data part of the node
    Node next; // Pointer to the next node

    // Constructor for convenience
    Node(int value) {
        this.data = value;
        this.next = null;

    }
}

// Class for singly linked list
class SingleLinkedList {
    // A reference to the first node in the list
    private Node head;

    // Constructor to initialize an empty list
    SingleLinkedList() {
        this.head = null; // Initially, the list is empty, so head is null
    }

    // Function to insert a node at the end
    void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode; // If list is empty, make newNode the head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the last node
            }
            temp.next = newNode; // Link the last node to newNode
        }
    }

    // Function to delete a Node by Value
    void deleteByValue(int value) {

        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next; // Move head to the next node
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next; // Traverse to find the node to delete
        }

        if (temp.next != null) {
            temp.next = temp.next.next; // Unlink the node
        }


    }

    // Function to display the list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class LL_Task003 {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.print("Linked List: ");
        list.display();

        list.deleteByValue(20);

        System.out.print("After Deleting 20: ");
        list.display();
    }
}


