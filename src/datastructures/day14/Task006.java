// Searching an element in Stack and display its position
package datastructures.day14;
import java.util.Stack;
public class Task006{

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
            System.out.println("Stack: " + stack);
            //Top element
            System.out.println("Top element is: "+stack.peek());

            // Element to find
            int ele = 20;

            // Search for the element
            int position = stack.search(ele);

            // Display the result
            if (position == -1) {
                System.out.println("Element " + ele + " not found in the stack.");
            } else {
                System.out.println("Element " + ele + " found at position " + position + " from top");
            }
        }
}

