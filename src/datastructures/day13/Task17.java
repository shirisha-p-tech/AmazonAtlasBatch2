//HashMap with capacity 10
package datastructures.day13;

import java.util.HashMap;

public class Task17 {
    public static void main(String[] args) {
        // HashMap with initial capacity of 10
        HashMap<String, Integer> map = new HashMap<>(10);


        map.put("ab", 10);
        map.put("cd", 20);
        map.put("ef", 30);
        map.put("gh", 40);
        map.put("ij", 50);

        System.out.println("HashMap: " + map);
        System.out.println("Map size: " + map.size());
    }
}