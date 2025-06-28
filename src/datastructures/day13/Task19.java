//HashMap using a Load Factor
package datastructures.day13;

import java.util.HashMap;

public class Task19 {
    public static void main(String[] args) {
        // Create a HashMap with initial capacity of 10 (but it will actually be rounded up to 16)
        HashMap<String, Integer> map = new HashMap<>(10,0.5f);

        // Adding some elements
        map.put("ab", 10);
        map.put("cd", 20);
        map.put("ef", 30);
        map.put("gh", 40);
        map.put("ij", 50);

        // Print the map
        System.out.println("HashMap: " + map);
        System.out.println("Map size: " + map.size());
    }
}
