//method reference
package multithreading;
import java.util.stream.*;
public class IO_Task12 {


        public static void main(String[] args) {
            Stream<String> stream
                    = Stream.of("Hello", "My", "name", "is", "Shirisha", "Perapagu");

            stream.forEach(System.out::println);
        }
    }


