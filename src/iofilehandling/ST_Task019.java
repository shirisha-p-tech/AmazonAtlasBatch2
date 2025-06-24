package iofilehandling;
import java.util.stream.Stream;
public class ST_Task019 {
    public static void main(String[] args) {

        Stream<Integer> streamNum = Stream
                .iterate(1, n -> n+1)
                .limit(20);


        Stream<Integer> skipNums = streamNum.skip(15);
        System.out.println("After Skipping first 15 numbers:");
        skipNums
                .forEach(System.out::println);



    }
}
