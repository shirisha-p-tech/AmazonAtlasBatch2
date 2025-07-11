// Day14 Home Task new - Palindrome using recursion
package datastructures.day16;

public class Task20 {

    // Recursive method to check if a string is palindrome
    public static boolean isPalindrome(String str) {
        // Base case: If the string length is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Compare the first and last characters
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false; // Not a palindrome if characters don't match
        }

        // Recursive call: Check the substring excluding the first and last characters
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "madam";

        // Check if the string is palindrome and print the result
        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }
}

