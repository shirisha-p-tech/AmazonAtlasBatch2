package datastructures.day14;

public class Task015 {
    // Recursive method to reverse a string
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        // Recursive call
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversed = reverse(str);

        System.out.println("Original String: " + str);
        System.out.println("Reversed String using recursion: " + reversed);
    }
}
