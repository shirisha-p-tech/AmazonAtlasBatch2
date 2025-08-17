package designpatterns.structural.day25.adapter;

// Adaptee Implementation
public class ChargerAdaptee implements IChargerAdaptee {
    public ChargerAdaptee() {
    }

    @Override
    public void charge() {
        System.out.println("Charging my laptop");
    }

    @Override
    public void removeCharge() {
        System.out.println("Not charging my laptop");
    }
}
