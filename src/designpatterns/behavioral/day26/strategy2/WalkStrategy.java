package designpatterns.behavioral.day26.strategy2;

// Concrete Strategy
public class WalkStrategy implements TravelStrategy {
    @Override
    public void travel(String destination) {
        System.out.println("Walking to " + destination);
    }
}

