// Print number of digits in a number
package datastructures.day18;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        // Create a Scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        // Convert the number to a positive value in case it's negative
        number = Math.abs(number);

        // Count the number of digits
        int count = 0;

        // If number is 0
        if (number == 0) {
            count = 1;
        } else {
            while (number > 0) {
                number /= 10;  // Remove the last digit
                count++;       // Increment the digit count
            }
        }

        // Display the number of digits
        System.out.println("The number of digits is: " + count);

        // Close the scanner
        scanner.close();
    }
}

