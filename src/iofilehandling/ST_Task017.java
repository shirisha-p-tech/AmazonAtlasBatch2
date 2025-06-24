package iofilehandling;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ST_Task017 {
        public static void main(String[] args) {
            // Create an ArrayList of integers
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(1);
            numbers.add(1);
            numbers.add(5);
            numbers.add(5);
            numbers.add(6);
            numbers.add(7);
            numbers.add(7);
            numbers.add(9);
            numbers.add(10);

            List<Integer> dist = numbers.stream()
                    .distinct()
                    .collect(Collectors.toList());

            // Distinct numbers
            System.out.println("Original list: " + numbers);
            System.out.println("Distinct numbers: " + dist);

        }


}
