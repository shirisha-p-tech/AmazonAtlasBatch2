//Doubly Linked List creation
package datastructures.day13;

    class DoublyLinkedList {

        // Node class represents a node of the list
        static class Node {
            int data;
            Node next;
            Node prev;

            // Constructor to create a new node
            Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        // Head of the list
        Node head;

        // Constructor to initialize the list
        public DoublyLinkedList() {
            head = null;
        }

        // Method to insert a node at the end of the list
        public void append(int data) {
            Node newNode = new Node(data);

            // If the list is empty, make the new node the head
            if (head == null) {
                head = newNode;
                return;
            }

            // Otherwise, traverse to the last node and append the new node
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new node at the end
            last.next = newNode;
            newNode.prev = last;
        }

        // Method to display the list from the head to the tail (forward direction)
        public void displayForward() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public class DLL_Task016 {
        public static void main(String[] args) {
            // Create a new DoublyLinkedList object
            DoublyLinkedList list = new DoublyLinkedList();

            // Add elements to the doubly linked list
            list.append(10);
            list.append(20);
            list.append(30);
            list.append(40);
            list.append(50);

            // Display the list in forward direction
            System.out.println("Doubly Linked List:");
            list.displayForward();
        }
    }

