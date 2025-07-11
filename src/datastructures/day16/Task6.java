// Bubble Sort
package datastructures.day16;

public class Task6 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Do n-1 passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps happened during this pass, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {35, 50, 10, 55, 25};
        System.out.println("Bubble Sort:");
        System.out.println("Original array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        bubbleSort(numbers);

        System.out.println("\nSorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}


