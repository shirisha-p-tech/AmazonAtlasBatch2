package ooad.day21;

// Home Task - Loose Coupling
class Student1 {
    private int roll_no = 0; // Encapsulated field

    public int getRoll() {
        System.out.println("getRoll method");
        return roll_no;
    }

    public void setRoll(int roll) {
        if (!(roll > 100)) {
            roll_no = roll;
        }
    }
}

public class Task16 {
    public static void main(String[] args) {
        Student1 sobj = new Student1(); // Loose coupling: external class doesnt access fields directly
        sobj.setRoll(10);             // Using setter

        System.out.println("The roll no of student is " + sobj.getRoll()); // Using getter
    }
}

