package iofilehandling;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ST_Task016 {
        public static void main(String[] args) {
            // Create an ArrayList of integers
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            numbers.add(4);
            numbers.add(5);
            numbers.add(6);
            numbers.add(7);
            numbers.add(8);
            numbers.add(9);
            numbers.add(10);

            // Filter odd numbers using streams
            List<Integer> oddNumbers = numbers.stream()
                    .filter(number -> number % 2 != 0)
                    .collect(Collectors.toList());

            // Display the filtered odd numbers
            System.out.println("Original list: " + numbers);
            System.out.println("Odd numbers: " + oddNumbers);

    }
}
