package designpatterns.structural.day25.adapter;

// Client Class
public class DellLaptop {
    private ILaptopTarget laptopCharger;

    public DellLaptop(ILaptopTarget laptopCharger) {
        this.laptopCharger = laptopCharger;
    }

    public void chargeLaptop() {
        laptopCharger.charge();
    }

    public void unplugLaptop() {
        laptopCharger.removeCharge();
    }
}
