//Use push() and pop() in LinkedList
package datastructures.day13;
import java.util.LinkedList;
public class LL_Task013 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.push("ABC");
        ll.push("DEF");
        ll.push("GHI");
        ll.push("JKL");

        System.out.println("LinkedList after using push(): ");
        for(String i:ll){
            System.out.println(i);
        }

        System.out.println("\nPopped element using pop(): " + ll.pop());

        System.out.println("\nElements left after popping:");
        for(String i:ll){
            System.out.println(i);
        }
    }

}


