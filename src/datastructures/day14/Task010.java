//Queue operations using LinkedList
package datastructures.day14;


class LinkedQueue {
    private Node front;
    private Node rear;
    private int size;
    private int capacity; // Max allowed size (optional)

    // Constructor
    public LinkedQueue(int capacity) {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacity = capacity;
    }

    // Enqueue: Add to rear
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full." + value + " cant be enqueue");
            return;
        }

        Node newNode = new Node(value);
        if (rear == null) { // First element
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued element: " + value);
    }

    // Dequeue: Remove from front
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        int removed = front.data;
        front = front.next;
        if (front == null) { // when queue becomes empty
            rear = null;
        }
        size--;
        System.out.println("Dequeued element: " + removed);
    }

    // Peek: View front element
    public void peek() {
        if (size == 0) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display the queue
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}

    // Main method for testing
    public class Task010{
    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue(3); //setting capacity
        System.out.println("\nUsing enqueue");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("\nUsing peek");
        q.peek();
        System.out.println("\nUsing dequeue");
        q.dequeue();
        q.display();

        System.out.println("\nUsing enqueue again");
        q.enqueue(40);
        q.display();
        System.out.println("\nUsing enqueue again");
        q.enqueue(50);
        q.display();

    }
}

