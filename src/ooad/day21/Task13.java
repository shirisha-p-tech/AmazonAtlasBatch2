package ooad.day21;

// Home Task - Upper bounded wildcard
import java.util.*;

class Animal2 {
    void sound() {
        System.out.println("Sounds of different animals");
    }
}

class Cat2 extends Animal2 {
    @Override
    void sound() {
        System.out.println("Meow is the sound of Cat");
    }
}

public class Task13 {

    // Upper bounded wildcard allows any List of Animal or subclass
    static void animalSound(List<? extends Animal2> animalList) {
        for (Animal2 element : animalList) {
            element.sound();
        }
    }

    public static void main(String[] args) {
        List<Cat2> cats = new ArrayList<>();
        cats.add(new Cat2());

        animalSound(cats);
    }
}

