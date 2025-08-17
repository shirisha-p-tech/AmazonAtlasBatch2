package designpatterns.creational.day24.abstractfactory;

// OnePlus Factory
public class OnePlus {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("OnePlus12")) {
            return new Mobile("Here is your OnePlus 12");
        } else if (model.equalsIgnoreCase("OnePlus12R")) {
            return new Mobile("Here is your OnePlus 12R");
        }
        return new NoMobile("OnePlus", model);
    }
}
