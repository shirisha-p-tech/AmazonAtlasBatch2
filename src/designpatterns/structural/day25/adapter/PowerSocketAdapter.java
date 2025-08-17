package designpatterns.structural.day25.adapter;

// Adapter Class
public class PowerSocketAdapter implements ILaptopTarget {
    private IChargerAdaptee charger;

    public PowerSocketAdapter(IChargerAdaptee charger) {
        this.charger = charger;
    }

    @Override
    public void charge() {
        charger.charge();
    }

    @Override
    public void removeCharge() {
        charger.removeCharge();
    }
}
