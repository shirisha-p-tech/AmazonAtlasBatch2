//SingleLinkedList with Generic Type(Object - any type)
package datastructures.day13;
import java.util.NoSuchElementException;

class Node1<T> {
    T data;
    Node1<T> next;

    public Node1(T data) {
        this.data = data;
        this.next = null;
    }
}

class CustomLinkedList<T> {
    private Node1<T> head;
    private int size = 0;

    public void add(T data) {
        Node1<T> newNode = new Node1<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node1<T> newNode = new Node1<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Function to insert a node at the end
    void addLast(T data) {
        Node1<T> newNode = new Node1<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1 temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    public T get(int index) {
        checkBounds(index);
        Node1<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
    void display() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class LL_Task004 {
    public static void main(String[] args) {

        CustomLinkedList<Object> liobj = new CustomLinkedList<>();
        liobj.add("Hello");
        liobj.add(10);
        liobj.addFirst(10.5);
        System.out.println("Linked List Elements: ");
        liobj.display();

        liobj.addLast(true);
        System.out.println("\nAdded boolean element from end");
        liobj.display();

        System.out.println("First Element: " + liobj.get(0));
        System.out.println("Size: " + liobj.size());

        liobj.removeFirst();
        System.out.println("\nLinked List elements after first element removal");
        liobj.display();

        System.out.println("First Element now is: " + liobj.get(0));
        System.out.println("Size after removal: " + liobj.size());
        System.out.println("\nAttempting to access index 3: ");
        try {
            System.out.println(liobj.get(3));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Exception caught: "+e.getMessage());
        }


        }

}
