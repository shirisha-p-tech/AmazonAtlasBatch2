//Display 5 names using ArrayList
package iofilehandling;
import java.util.ArrayList;

public class AL_Task012 {
        public static void main(String[] args) {
            // Declare and initialize an ArrayList of String type
            ArrayList<String> names = new ArrayList<>();

            // Add five names to the ArrayList
            names.add("Jaya");
            names.add("John");
            names.add("Charry");
            names.add("Deepa");
            names.add("Ana");


            System.out.println("Names in the ArrayList:");
            for (String name : names) {
                System.out.println(name);
            }
        }

}
