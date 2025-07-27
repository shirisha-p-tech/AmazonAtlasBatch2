package ooad.day21;

// Home Task - DIP Violation

class LightBulb {
    void turnOn() {
        System.out.println("Light turned on");
    }

    void turnOff() {
        System.out.println("Light is off");
    }
}

class Switch {  // DIP violation: depends directly on a concrete class LightBulb
    LightBulb lbulbobj;

    Switch(LightBulb lbulbobj) {
        this.lbulbobj = lbulbobj;
    }

    void operate() {
        lbulbobj.turnOn();
    }
}


public class Task17 {
    public static void main(String[] args) {
        LightBulb lbulbobj = new LightBulb();
        Switch switchObj = new Switch(lbulbobj);
        switchObj.operate();
    }
}


