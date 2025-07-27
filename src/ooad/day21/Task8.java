package ooad.day21;
import java.util.*;

// Generics Substitution issue and solution using wildcards


// Base class
class Animal {
    void sound() {
        System.out.println("Sounds of different animals");
    }
}

// Subclass
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow is the sound of cat");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark is the sound of dog");
    }
}

public class Task8 {

    // Method that accepts any list of Animal or its subclass (read-only)
    public static void makeAnimalsSound(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        // We can pass List<Cat> or List<Dog> because of ? extends Animal
        makeAnimalsSound(cats);
        makeAnimalsSound(dogs);
    }
}


/*
// Generics Substitution issue
class Animal {
    void sound() {
        System.out.println("sounds of different animals");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow is the sound of cat");
    }
}

public class Task8 {
    public static void main(String[] args) {
        Animal obj = new Cat();
        obj.sound(); // Output: Meow is the sound of cat

        //List<Cat> Cobj = new ArrayList<>();
        //List<Animal> Aobj = Cobj; //Compilation error

        List<Cat> Cobj = new ArrayList<>();
        List<Animal> Aobj = Cobj;
        Aobj.add(new Dog());
    }
}*/



