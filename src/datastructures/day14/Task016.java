// Recursive method to search for target element in array
package datastructures.day14;

public class Task016 {

    public static int recursiveSearch(int[] arr, int target, int index) {
        // if array index goes beyond array length, element not found
        if (index >= arr.length) {
            return -1;
        }

        // If current element matches target, return the index
        if (arr[index] == target) {
            return index;
        }

        // Recurse by moving to the next index
        return recursiveSearch(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int target = 4;
        int result = recursiveSearch(array, target, 0);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}

