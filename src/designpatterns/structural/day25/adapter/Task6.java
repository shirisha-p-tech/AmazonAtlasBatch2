package designpatterns.structural.day25.adapter;

// Home Task - Adapter Design Pattern - Structural DP - Laptop Charger Example

// Client
public class Task6 {
    public static void main(String[] args) {
        System.out.println("Adapter Design Pattern - Structural DP");

        IChargerAdaptee adaptee = new ChargerAdaptee();
        ILaptopTarget adapter = new PowerSocketAdapter(adaptee);
        DellLaptop dell = new DellLaptop(adapter);

        dell.chargeLaptop();
        dell.unplugLaptop();
    }
}

