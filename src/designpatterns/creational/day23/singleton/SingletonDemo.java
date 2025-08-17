package designpatterns.creational.day23.singleton;

// SingletonDemo - only one instance exists

public class SingletonDemo {
    private static SingletonDemo instance;

    // Private constructor to prevent instantiation
    private SingletonDemo() {
        System.out.println("Initializing the Singleton");
    }

    // Public method to provide access to the singleton instance
    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
            System.out.println("In getInstance() - New Instance Created");
        } else {
            System.out.println("In getInstance() - Returning Existing Instance");
        }
        return instance;
    }

    // A method to perform some action
    public void doHere() {
        System.out.println("Doing something here");
    }
}


