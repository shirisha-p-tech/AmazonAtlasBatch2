//Linked list Cloning
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task012 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        LinkedList<String> clonedList = (LinkedList<String>) ll.clone();

        System.out.println("Original LinkedList: " + ll);
        System.out.println("Cloned LinkedList: " + clonedList);

        ll.add("ZZZZZZZZ");

        System.out.println("\nAfter modifying the original LinkedList:");
        System.out.println("Original LinkedList: " + ll);
        System.out.println("Cloned LinkedList: " + clonedList);
}
}
