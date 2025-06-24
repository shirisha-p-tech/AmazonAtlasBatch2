package iofilehandling;
import java.util.*;
public class ST_Task014 {
    // create an object of list using ArrayList
    static List<String> fullname = new ArrayList<>();
    // preparing our data
    public static List getFullNames(){

        fullname.add("John,Ab");
        fullname.add("Jaya,Chopra");
        fullname.add("Charry,Kin");
        fullname.add("Deepa,Singh");
        fullname.add("Ana,Mil");

        return fullname;
    }
    public static void main( String[] args ) {

        List<String> fn = getFullNames();
        System.out.println("Friends names starting with J");
        // Filter names starting with J
        fn.stream()
                .filter((p) -> p.startsWith("J"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));
    }
}

