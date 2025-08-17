package designpatterns.creational.day23.singleton;

// Driver class
public class Task02 {

    public static void main(String[] args) {
        SingletonDemo instance1= SingletonDemo.getInstance();
        System.out.println("instance1 : "+instance1.hashCode());
        SingletonDemo instance2= SingletonDemo.getInstance();
        System.out.println("instance2 : "+instance2.hashCode());

        // Checking if both instances are the same
        System.out.println("Are both instances points to same object? " + (instance1 == instance2));

       /* SingletonDemo instance3 = new SingletonDemo();
        instance3.doHere();
        //The above object creation is not allowed as SingletonDemo class has private constructor
        */
    }

}
