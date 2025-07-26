package ooad.day21;
// LSP Violation

abstract class Bird {
    abstract void fly() ;
}
class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagles fly");
    }
}
class Ostrich extends Bird {
    @Override
    public void fly() { // dummy implentation
        System.out.println("Ostrich cant fly high but lays big egg");
    }
}
class Task01{

            public static void main(String[] args) {

                System.out.println("\nLSP Violation:\n");

                Bird eagle = new Eagle();
                eagle.fly();  // Eagles fly

                Bird ostrich = new Ostrich();
                ostrich.fly();  // Logically incorrect – ostrich can't fly
            }
}