// Peek element and print it
package datastructures.day14;
import java.util.Stack;
public class Task007 {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        // Display the current stack
        System.out.println("Stack elements: " + stack);
        //Peek element
        int a = stack.peek();
        System.out.println("Peek or Top element is: " + a );
        System.out.println("peek() does not delete Top element, it is just to look at Top element");
        System.out.println("Stack elements after peek: " + stack);
    }
}
