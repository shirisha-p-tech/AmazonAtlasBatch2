package iofilehandling;
//Display 5 fullnames using List
import java.util.*;

    public class AL_Task013 {
        public static void main(String[] args) {
            // Declare and initialize an ArrayList of String type
            List<String> fullname = new ArrayList<>();

            // Add five names to the ArrayList
            fullname.add("Jaya,Chopra");
            fullname.add("John,Ab");
            fullname.add("Charry,Kin");
            fullname.add("Deepa,Singh");
            fullname.add("Ana,Mil");


            System.out.println("Names are:");
            for (String name : fullname) {
                System.out.println(name);
            }
        }

}
