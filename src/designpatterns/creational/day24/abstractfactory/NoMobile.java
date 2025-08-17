package designpatterns.creational.day24.abstractfactory;

// NoMobile Class
public class NoMobile extends Mobile {
    public NoMobile(String brand, String model) {
        super("\nSorry, invalid model: " + brand + " - " + model);
    }

    public NoMobile() {
        super("\nSorry, invalid model");
    }
}
