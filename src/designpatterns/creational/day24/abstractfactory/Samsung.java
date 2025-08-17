package designpatterns.creational.day24.abstractfactory;

// Samsung Factory
public class Samsung {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("S24")) {
            return new Mobile("Here is your Samsung Galaxy S24");
        } else if (model.equalsIgnoreCase("S24Ultra")) {
            return new Mobile("Here is your Samsung Galaxy S24 Ultra");
        }
        return new NoMobile("Samsung", model);
    }
}
