//Display elements in LinkedList by using 1) get method in for loop 2)for each loop
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task009 {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        System.out.println("Displaying the list using get() method in a for loop:");
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }

        System.out.println("\nDisplaying the list using for-each loop:");
        for (String i : ll) {
            System.out.println(i);
        }
    }
}
