//Copy data from one map to another map.
package datastructures.day13;

import java.util.HashMap;

public class Task18 {
    public static void main(String[] args) {

        HashMap<String, Integer> hm1 = new HashMap<>();
        hm1.put("ab", 1);
        hm1.put("cd", 2);
        hm1.put("ef", 3);

        // Create a new HashMap hm2 by copying the contents of hm1
        HashMap<String, Integer> hm2 = new HashMap<>(hm1);


        System.out.println("HashMap1: " + hm1);
        System.out.println("HashMap2: " + hm2);

        // Modify hm2 and it does not affect hm1
        hm2.put("zzzz",5);
        System.out.println("After modification changing HashMap2 does not effect HashMap1");
        System.out.println("HashMap1: " + hm1);
        System.out.println("HashMap2: " + hm2);
    }
}
