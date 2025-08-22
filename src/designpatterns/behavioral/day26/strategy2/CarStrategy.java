package designpatterns.behavioral.day26.strategy2;

// Concrete Strategy
public class CarStrategy implements TravelStrategy {
    @Override
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by car");
    }
}

