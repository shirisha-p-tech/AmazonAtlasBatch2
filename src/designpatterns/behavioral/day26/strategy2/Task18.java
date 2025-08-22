package designpatterns.behavioral.day26.strategy2;

// Home Task - Driver Class - Strategy DP - Travel modes
public class Task18 {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setStrategy(new CarStrategy());
        navigator.navigate("Office");

        navigator.setStrategy(new BikeStrategy());
        navigator.navigate("Gym");

        navigator.setStrategy(new WalkStrategy());
        navigator.navigate("Park");
    }
}

