//Custom Linked List to add 4 elements and traverse
package datastructures.day14;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Task001 {
    Node head;

    // Add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task001 list = new Task001();
        // Add 4 elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();
    }
}

