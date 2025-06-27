package datastructures;

import java.util.HashMap;
import java.util.Hashtable;

public class Task13 {
        public static void main(String[] args) {
            HashMap<String, Integer> hp = new HashMap<>();
            hp.put("Anitha", 101);
            hp.put("Kavitha", 102);
            hp.put("Meera", 103);
            // use  get method of HashMap
            System.out.println("Using Hashmap:");
            System.out.println("Anita's value is "+hp.get("Anitha"));
            System.out.println("Kavitha's value is "+hp.get("Kavitha"));
            System.out.println("Meera's value is "+hp.get("Meera"));
           // System.out.println(hp.get("Alexa"));
            System.out.println();
            System.out.println("Hashmap contents");
            System.out.println(hp);
        }
}





