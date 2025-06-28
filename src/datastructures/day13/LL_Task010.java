//Display elements in LinkedList without using any loops
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task010 {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        System.out.println("Elements in the LinkedList" + ll);
    }
}
