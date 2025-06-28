//Hashtable code and printing elements
package datastructures.day12;
import java.util.Hashtable;

public class Task12 {
    public static void main(String[] args) {

            Hashtable<String, Integer> ht = new Hashtable<>();
            ht.put("Anitha", 101);
            ht.put("Kavitha", 102);
            ht.put("Meera", 103);
            // use  get method of Ht
        System.out.println("Using HashTable:");
        System.out.println("Anita's value is "+ht.get("Anitha"));
        System.out.println("Kavitha's value is "+ht.get("Kavitha"));
        System.out.println("Meera's value is "+ht.get("Meera"));
        //System.out.println(ht.get("Alexa"));
        System.out.println();
        System.out.println("HashTable contents");
        System.out.println(ht);
           /* for (Map.Entry<String, Integer> e : ht.entrySet())
                System.out.println(e.getKey() + " " + e.getValue());
            */

        }
}




