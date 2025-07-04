//Check if Stack is empty or not
package datastructures.day14;
import java.util.Stack;
public class Task008 {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        if (stack.isEmpty()) {
            System.out.println("Stack is empty, no elements pushed yet");
        } else {
            System.out.println("Stack is not empty");
        }

        stack.push(10);
        System.out.println("Pushed element : 10");
        stack.push(20);
        System.out.println("Pushed element : 20");
        System.out.println("Stack elements now are : " + stack);
        // Check again
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}