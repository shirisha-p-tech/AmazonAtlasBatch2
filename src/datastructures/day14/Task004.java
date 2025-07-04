// Circular linked list - add and delete and display elements
package datastructures.day14;

/* Node class already defined in Task001 hence commenting out
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
*/
public class Task004 {
    Node head;

    // Add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next=head; // Points to itself since it is circular
        } else {
            Node current = head;

            while (current.next != head) { // Stop at the last node
                current = current.next;
            }
            current.next = newNode;
            newNode.next=head; // Making it circular
        }
    }

    // Delete a node with given data
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 1: Only one node
        if (head.data == data && head.next == head) {
            head = null;
            return;
        }

        Node current = head;
        Node prev = null;

        // Case 2: Deleting head (more than one node)
        if (head.data == data) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            return;
        }

        // Case 3: Deleting other than head
        do {
            prev = current;
            current = current.next;
            if (current.data == data) {
                prev.next = current.next;
                return;
            }
        } while (current != head);

        System.out.println("Element " + data + " not found");
    }

    // Display the list
    public void display() {
        Node current = head;
        System.out.print("Circular Linked List: ");
        do{
            System.out.print(current.data + " ");
            current = current.next;
        }while (current != head); // Stop it when back to head
        System.out.println();
    }

    public static void main(String[] args) {
        Task004 list = new Task004();
        // Add 4 elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();

        // Delete a middle node
        list.delete(20);
        System.out.println("\nAfter deleting any middle node:");
        list.display();

        // Delete the head
        list.delete(10);
        System.out.println("\nAfter deleting head:");
        list.display();

        // Delete a node not in list
        System.out.println("\nDeleting a node which is not available in list");
        list.delete(99);

        System.out.println();
        list.display();
    }
}

