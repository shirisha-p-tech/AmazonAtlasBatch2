package designpatterns.behavioral.day26.pubsub;


// Publisher Interface
public interface Publisher {
    void addSub(Subscriber subscriber);
    void removeSub(Subscriber subscriber);
    void notifySub(String msg);
}
