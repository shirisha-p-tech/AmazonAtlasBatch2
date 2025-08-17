package designpatterns.creational.day24.abstractfactory;

// MobileStore Abstract Factory
public class MobileStore {
    static {
        System.out.println("Hello, welcome to the world of Mobiles!");
    }

    public static Mobile getMobile(String brand, String model) {

        if (brand.equalsIgnoreCase("Apple")) {
            System.out.println("\nHere are your Apple models:");
            return Apple.getMobile(model);
        } else if (brand.equalsIgnoreCase("Samsung")) {
            System.out.println("\nHere are your Samsung models:");
            return Samsung.getMobile(model);
        } else if (brand.equalsIgnoreCase("OnePlus")) {
            System.out.println("\nHere are your OnePlus models:");
            return OnePlus.getMobile(model);
        }

        return new NoMobile(brand, model);
    }
}
