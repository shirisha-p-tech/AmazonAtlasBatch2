//Use Predefined LinkedList class and add elements
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task006 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        System.out.println("Elements in the LinkedList"+ ll);

        System.out.println("First element " + ll.getFirst());
        System.out.println("Last element " + ll.getLast());



    }
}
