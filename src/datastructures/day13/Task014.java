//Linkedlist SplitIterator
package datastructures.day13;
import java.util.*;

public class Task014{
    public static void main(String[] args) {
        LinkedList<String> lobj = new LinkedList<>();
        lobj.add("All");
        lobj.add("is");
        lobj.add("well");

        Spliterator<String> sitobj = lobj.spliterator();

        //forEachRemaining is a method of Spliterator
        System.out.println("Splitting the list:");
        sitobj.forEachRemaining(System.out::println);

    }
}
//Did not work as expected

