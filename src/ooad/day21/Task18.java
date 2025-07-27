package ooad.day21;

// Home Task - DIP Implementation - LightBulb and Switch

// Abstraction
interface SwitchOnOff {
    void turnOn();
    void turnOff();
}

// Concrete implementation
class LightBulb1 implements SwitchOnOff {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

// High-level module depending on abstraction
class Switch1 {
    SwitchOnOff device;

    public Switch1(SwitchOnOff device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}


public class Task18 {
    public static void main(String[] args) {
        SwitchOnOff lbulbobj = new LightBulb1();
        Switch1 lightSwitch = new Switch1(lbulbobj);
        lightSwitch.operate();
    }
}

