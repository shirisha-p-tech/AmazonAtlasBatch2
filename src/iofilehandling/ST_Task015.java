package iofilehandling;
import java.util.*;
import java.util.stream.Collectors;
public class ST_Task015 {
        public static void main(String[] args) {
            List<Integer> numbers=new ArrayList<>();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 5 integers:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter integer " + (i + 1) + ": ");
                numbers.add(scanner.nextInt());
            }
            scanner.close();

            System.out.println("\nOriginal numbers: " + numbers);


            System.out.print("Squares of each number: ");
            List<Integer> squares = numbers.stream()
                    .map(num -> num * num) // Lambda expression to calculate the square
                    .collect(Collectors.toList()); //collect to a new list

            System.out.println(squares);

        }
}

