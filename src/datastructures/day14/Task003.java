// Circular linked list - add and display elements
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
public class Task003 {
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
        Task003 list = new Task003();
        // Add 4 elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();
    }
}


