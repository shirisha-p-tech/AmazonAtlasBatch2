package ooad.day21;

// Home Task - Unbounded wildcard

import java.util.*;

class Animal1 {
    void sound() {
        System.out.println("Sounds of different animals");
    }
}

class Cat1 extends Animal1 {
    @Override
    void sound() {
        System.out.println("Meow is the cat sound");
    }

     @Override
    public String toString() {
        return "Cat Sounds Meow";
    }
}

public class Task09 {

    // Unbounded wildcard method to print list elements
    static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        List<Cat1> clist = new ArrayList<>();
        clist.add(new Cat1());

        printList(clist);  // Output: Cat Sound Meow because of overridden toSring()
    }
}


