// Day 14 Home Task new - Copy array data to another using Recursion
package datastructures.day16;

public class Task21 {

    // Recursive method to copy one array to another
    public static void copyArray(int[] source, int[] destination, int index) {
        // Base case: If index is equal to the length of the array, stop recursion
        if (index == source.length) {
            return;
        }

        // Copy the element at the current index
        destination[index] = source[index];

        // Recursive call for the next element
        copyArray(source, destination, index + 1);
    }

    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4, 5};
        // Print the source array
        System.out.print("Source array: ");
        for (int num : source) {
            System.out.print(num + " ");
        }
        int[] destination = new int[source.length]; // Destination array with same length as source

        // Start the copying process from index 0
        copyArray(source, destination, 0);

        // Print the destination array
        System.out.print("\nDestination array: ");
        for (int num : destination) {
            System.out.print(num + " ");
        }
    }
}

