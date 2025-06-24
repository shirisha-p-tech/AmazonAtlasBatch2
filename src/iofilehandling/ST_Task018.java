package iofilehandling;
import java.util.stream.Stream;
public class ST_Task018 {
    public static void main(String[] args) {

        Stream<Integer> nums = Stream
                .iterate(1, n -> n+1)
                .limit(20);
        //Display only first 10 numbers
        System.out.println("Limited to First 10 numbers");
        nums
                .limit(10)
                .forEach(System.out::println);


    }
}
