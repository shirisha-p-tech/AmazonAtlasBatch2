// Insertion sort
package datastructures.day16;

public class Task9 {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element
        for (int i = 1; i < n; i++) {
            int next = arr[i];  // The number to be inserted
            int j = i - 1;

            // Shift elements that are greater than 'next'
            while (j >= 0 && arr[j] > next) {
                arr[j + 1] = arr[j];  // Shift element to the right
                j--;
            }

            // Insert 'next' into the correct position
            arr[j + 1] = next;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {35, 50, 10, 55, 25};

        System.out.println("Insertion sort:");
        System.out.println("Original array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        insertionSort(numbers);

        System.out.println("\nSorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}

