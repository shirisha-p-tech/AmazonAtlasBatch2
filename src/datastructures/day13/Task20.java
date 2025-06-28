//Circular Linked List Creation
package datastructures.day13;

/*Note: I have already created Node Class in LL_Task003(it will be reused here) hence commenting it
class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;

    }
}
 */

// CircularLinkedList class to represent the circular linked list
class CircularLinkedList {
    Node head = null;
    Node tail = null;

    // Method to insert a new node at the end of the circular linked list
    public void add(int data) {
        Node newNode = new Node(data);

        // If the list is empty, the new node is both the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Point tail to head to complete the circle
        } else {
            // If the list is not empty, add the new node after the tail
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Point the new tail back to the head
        }
    }

    // Method to traverse the circular linked list and display the elements
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head); // Traverse until we reach the head again

        System.out.println(); // Print a newline at the end
    }
}

public class Task20 {
    public static void main(String[] args) {
        // Create a new circular linked list
        CircularLinkedList list = new CircularLinkedList();

        // Add elements to the circular linked list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Display the elements of the circular linked list
        System.out.print("Circular Linked List: ");
        list.display();
    }
}
