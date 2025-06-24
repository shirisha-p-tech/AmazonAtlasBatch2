package javabasics;
public class Task019 {
   
        public static void main(String[] args) {
            System.out.println("Displaying all elements:\n");
    
            for (Element e : Element.values()) {
                System.out.println("Symbol: " + e.name());
                System.out.println("Label: " + e.label);
                System.out.println("Atomic Number: " + e.atomicNumber);
                System.out.println("Atomic Weight: " + e.atomicWeight);
                System.out.println("----------------------------");
            }
        }
} 

