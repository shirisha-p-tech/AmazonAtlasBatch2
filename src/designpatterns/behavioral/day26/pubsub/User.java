package designpatterns.behavioral.day26.pubsub;


// Concrete Subscriber
public class User implements Subscriber {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println("the user "+ userName + " has received a msg : "+ msg);
    }

    // reply msg...
}
