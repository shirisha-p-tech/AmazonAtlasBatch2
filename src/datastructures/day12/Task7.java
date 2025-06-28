//Reverse an array
package datastructures.day12;

public class Task7 {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("Original Array");
            for (int i : arr) {
                System.out.print(i + " ");
            }
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            System.out.println();
            System.out.println("Reversed Array");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
}
