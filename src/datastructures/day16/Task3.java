// Selection Sort
package datastructures.day16;

public class Task3 {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Loop from 0 to n-1
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {35, 50, 10, 55, 25};
        System.out.println("Selection Sort:");
        System.out.println("Original array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        selectionSort(numbers);

        System.out.println("\nSorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}

