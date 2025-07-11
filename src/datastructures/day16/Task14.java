// Merge Sort
package datastructures.day16;

public class Task14 {

    // Function to perform Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case - array has only 1 element and is already sorted
        }

        // Find the middle point to divide the array into two halves
        int mid = arr.length / 2;

        // Create left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data to the subarrays using System.arraycopy()
        System.arraycopy(arr, 0, left, 0, mid); // Copy first half to left
        System.arraycopy(arr, mid, right, 0, arr.length - mid); // Copy second half to right

        // Recursively sort the subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted subarrays
        merge(arr, left, right);
    }

    // Merge two sorted arrays
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right subarrays into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from the left subarray, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from the right subarray, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {40, 15, 55, 2, 18, 95, 10};
        System.out.println("Merge sort:");
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
