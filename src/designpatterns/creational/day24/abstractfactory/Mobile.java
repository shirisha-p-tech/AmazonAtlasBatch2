package designpatterns.creational.day24.abstractfactory;

// Mobile Base Class
public class Mobile {
    String desc;

    public Mobile(String model) {
        this.desc = model;
    }

    public void getDesc() {
        System.out.println(this.desc);
    }
}