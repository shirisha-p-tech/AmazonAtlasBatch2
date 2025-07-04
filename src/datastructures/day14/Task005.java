// Stack creation and deletion - push and pop
package datastructures.day14;
import java.util.Stack;

public class Task005 {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        System.out.println("Pushing elements onto the stack:");
        stack.push(10);
        System.out.println("Pushed: 10");
        stack.push(20);
        System.out.println("Pushed: 20");
        stack.push(30);
        System.out.println("Pushed: 30");

        // Display the current stack
        System.out.println("Current stack: " + stack);

        // Pop elements from the stack
        System.out.println("\nPopping elements from the stack:");
        System.out.println("Popped: " + stack.pop());


        System.out.println("Current stack after popping: " + stack);
        System.out.println("Peek element: " + stack.peek());

    }
}
