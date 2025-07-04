// Count of digits and sum of digits of a positive integer using recursion
package datastructures.day14;

public class Task017 {
    public static int countDigits(int n) {

        if (n == 0) { // No more digits left
            return 0;
        }
        return countDigits(n / 10) + 1; // strip last digit and add 1
    }

    public static int sumDigits(int n) {
        if (n == 0) { // No more digits left
            return 0;
        }
        return (n % 10) + sumDigits(n / 10); // adds last digit (remainder) + sum of remaining digits
    }

    public static void main(String[] args) {
        int number = 12345;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Sum of digits: " + sumDigits(number));
    }
}

