//Use Predefined LinkedList class and delete first and last elements
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task007 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");
        ll.add("MNO");

        System.out.println("Elements in the LinkedList before deletion:"+ ll);

        System.out.println("First element " + ll.removeFirst()+" is removed");
        System.out.println("Last element " + ll.removeLast()+" is removed");

        System.out.println("Elements in the LinkedList after deletion: "+ ll);

    }
}
