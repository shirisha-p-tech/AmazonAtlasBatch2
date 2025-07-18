// Radix Sort
package datastructures.day18;

class RadixSort{
    public static void radixSort(int[] arr){
        // Get the maximum number to know the number of digits
        int max = getMax(arr);

        // Apply counting sort for every digit for exp=1,10,100 and so on
        for(int exp =1; max / exp > 0; exp *=10)
            countingSort(arr,exp);
    }
    // getMax method
    public static int getMax(int[] arr){
        int max = arr[0];
        for(int i : arr){
            if(i > max)
                max = i;
        }
        return max;
    }
    // countingSort method
    public static void countingSort(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits 0 to 9

        // Store count of occurrences
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so it contains actual position of this digit in output[i]
        for (int i = 1; i < 10; i++)
            count[i] += count[i-1];

        // Build the output array - traversing from end f
        for (int i = n-1; i >= 0; i--){
            int index = (arr[i] /exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        //Copy output array back to arr[]
        System.arraycopy(output, 0, arr, 0, n);

    }


}

public class Task17 {
    public static void main(String[] args) {
        int[] array = {150, 50, 85, 30, 500, 1, 28, 78};
        System.out.println("Radix sort:");
        System.out.println("Original array:");
        for(int i:array)
            System.out.print(i + " ");

        RadixSort.radixSort(array);

        System.out.println("\nSorted array:");
        for(int i:array)
            System.out.print(i + " ");
    }

}
