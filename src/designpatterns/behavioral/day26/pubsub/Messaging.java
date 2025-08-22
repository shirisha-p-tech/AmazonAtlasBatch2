package designpatterns.behavioral.day26.pubsub;

import java.util.ArrayList;
import java.util.List;


// Concrete Publisher
public class Messaging implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    
    @Override
    public void addSub(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    @Override
    public void removeSub(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
    @Override
    public void notifySub(String msg) {
        for(Subscriber subscriber : subscribers) {
            subscriber.receiveMessage(msg);
        }
    }

    public void sendMsg(String msg){
        notifySub(msg);
    }

}
