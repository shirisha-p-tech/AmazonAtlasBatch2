package designpatterns.behavioral.day26.strategy2;

// Context class
public class Navigator {
    private TravelStrategy strategy;

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String destination) {
        if (strategy == null) {
            throw new IllegalStateException("Travel strategy not set.");
        }
        strategy.travel(destination);
    }
}

