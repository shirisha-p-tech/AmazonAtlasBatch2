//Reverse a string taken from user
package datastructures.day12;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to reverse: ");
        String originalString = sc.nextLine();

        String reversedString = "";


        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i); // Append each character to the reversed string
        }

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

        sc.close();
    }
}
