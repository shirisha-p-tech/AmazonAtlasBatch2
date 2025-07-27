package ooad.day21;

// Home Task - Lower Bounded Wildcard
import java.util.*;

class Animal3 {
    void sound() {
        System.out.println("Animal sound");
    }

    @Override
    public String toString() {
        return "Animal";
    }
}

class Cat3 extends Animal3 {
    @Override
    void sound() {
        System.out.println("Meow is the cat sound");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}

public class Task14 {

    // Lower bounded wildcard: allows adding Cat or its subclasses
    static void addACat(List<? super Cat3> cats) {
        cats.add(new Cat3());
    }

    public static void main(String[] args) {
        List<Animal3> animals = new ArrayList<>();
        addACat(animals);

       for (Animal3 a : animals) {
            a.sound();
        }
    }
}

