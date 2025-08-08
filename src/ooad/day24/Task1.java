package ooad.day24;
// Abstract Factory Pattern - Mobile Brand Selector

// Client code demonstrating Abstract Factory Pattern
public class Task1 {
    public static void main(String[] args) {
        Mobile m1 = MobileStore.getMobile("Apple", "iphone16");
        m1.getDesc();

        Mobile m2 = MobileStore.getMobile("Samsung", "S24");
        m2.getDesc();

        Mobile m3 = MobileStore.getMobile("OnePlus", "OnePlus12");
        m3.getDesc();

        Mobile m4 = MobileStore.getMobile("Vivo", "X Fold 5"); // Invalid brand
        m4.getDesc();

    }
}

// Mobile Base Class
class Mobile {
    String desc;

    public Mobile(String model) {
        this.desc = model;
    }

    public void getDesc() {
        System.out.println(this.desc);
    }
}

// NoMobile Class
class NoMobile extends Mobile {
    public NoMobile(String brand, String model) {
        super("\nSorry, invalid model: " + brand + " - " + model);
    }

    public NoMobile() {
        super("\nSorry, invalid model");
    }
}

// Apple Factory
class Apple {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("iphone16")) {
            return new Mobile("Here is your iPhone 16");
        } else if (model.equalsIgnoreCase("iphone16MaxPro")) {
            return new Mobile("Here is your iPhone 16 Max Pro");
        }
        return new NoMobile("Apple", model);
    }
}

// Samsung Factory
class Samsung {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("S24")) {
            return new Mobile("Here is your Samsung Galaxy S24");
        } else if (model.equalsIgnoreCase("S24Ultra")) {
            return new Mobile("Here is your Samsung Galaxy S24 Ultra");
        }
        return new NoMobile("Samsung", model);
    }
}

// OnePlus Factory
class OnePlus {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("OnePlus12")) {
            return new Mobile("Here is your OnePlus 12");
        } else if (model.equalsIgnoreCase("OnePlus12R")) {
            return new Mobile("Here is your OnePlus 12R");
        }
        return new NoMobile("OnePlus", model);
    }
}

// MobileStore Abstract Factory
class MobileStore {
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

