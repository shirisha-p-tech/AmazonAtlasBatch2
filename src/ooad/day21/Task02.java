package ooad.day21;
// LSP Implementation

abstract class BirdsthatFly {
    abstract void fly() ;
}
abstract class BirdsthatDontFly {
    abstract void Speciality() ;
}
class Eagle1 extends BirdsthatFly {
    @Override
    public void fly() {
        System.out.println("Eagles fly");
    }
}
class Ostrich1 extends BirdsthatDontFly {
    @Override
    public void Speciality() {
        System.out.println("Ostrich lays big egg");
    }
}

public class Task02 {
    public static void main(String[] args) {

        System.out.println("\nLSP Implementation:\n");

        BirdsthatFly eagle = new Eagle1();
        eagle.fly();  // Eagles fly

        BirdsthatDontFly ostrich = new Ostrich1();
        ostrich.Speciality();  // Logically correct - It lays big egg
    }
}



