//Update the first element to a new value in LinkedList
package datastructures.day13;
import java.util.LinkedList;

public class LL_Task008 {
    public static void main(String[] args) {

    LinkedList<String> ll = new LinkedList<>();

        ll.add("ABC");
        ll.add("DEF");
        ll.add("GHI");
        ll.add("JKL");

        System.out.println("Elements in the LinkedList: "+ ll);
        ll.set(0, "ZZZ");
        System.out.println("Elements in the LinkedList: "+ ll);
}
}
