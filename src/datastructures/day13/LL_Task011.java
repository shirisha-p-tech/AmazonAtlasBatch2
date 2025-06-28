//convert linked list to an array
package datastructures.day13;
import java.util.LinkedList;
public class LL_Task011 {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        Object[] array = ll.toArray();

        System.out.println("Displaying the LinkedList as an array:");
        for (Object i : array) {
            System.out.println(i);
        }
    }
}
