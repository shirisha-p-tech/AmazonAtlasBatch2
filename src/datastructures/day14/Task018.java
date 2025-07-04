// Convert decimal number to binary using recursion
package datastructures.day14;

public class Task018 {
    // Recursive method to convert decimal to binary
    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "";  // no more bits to process
        }
        // recursive call on n / 2, then add remainder (n % 2)
        return decimalToBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        int number = 20;

        String binary = decimalToBinary(number);

       // when number is given as 0
        if (binary.isEmpty()) {
            binary = "0";
        }

        System.out.println("Decimal: " + number);
        System.out.println("Binary: " + binary);
    }
}

