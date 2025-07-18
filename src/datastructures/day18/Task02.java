// Printing digits of a 5-digit number
package datastructures.day18;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        // Create a Scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.println("Enter a 5-digit number: ");
        int number = scanner.nextInt();

        // Convert the integer to a string
        String numberStr = Integer.toString(number);

        // Check if the number is a 5-digit number
        if (numberStr.length() == 5) {
            System.out.println("The digits of number " + number + " are:");
            // Display each digit one by one
            for (int i = 0; i < numberStr.length(); i++) {
                System.out.println(numberStr.charAt(i));
            }
        } else {
            System.out.println("Please enter a valid 5-digit number.");
        }

        // Close the scanner
        scanner.close();
    }
}
