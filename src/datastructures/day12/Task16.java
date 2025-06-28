//Adding null key twice and making HashMap synchronized
package datastructures.day12;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task16{
public static void main(String[] args){
    HashMap<String, Integer> hp = new HashMap<>();
            hp.put("Anitha", 101);
            hp.put("Kavitha", 102);
            hp.put("Meera", 103);
            hp.put(null, 250);
            hp.put(null, 300);

            System.out.println("Using Hashmap, it will give updated null key value");
            System.out.println("Null key value is "+hp.get(null));

            System.out.println();
            System.out.println("Hashmap contents");
                for (Map.Entry<String, Integer> e : hp.entrySet()){
                System.out.println(e.getKey() + " " + e.getValue());
                }

        System.out.println();
        System.out.println("Synchronized HashMap contents");
        Map<String,Integer> syncMap=Collections.synchronizedMap(hp);

        synchronized (syncMap){
        for (Map.Entry<String, Integer> e : syncMap.entrySet())
                System.out.println(e.getKey() + " " + e.getValue());
        }
}
}
