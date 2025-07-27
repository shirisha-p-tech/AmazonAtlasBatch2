package ooad.day21;

// Home Task - Tight Coupling

class Student {
    public int roll_no = 10; // Public field creates tight coupling

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

public class Task15 {
    public static void main(String[] args) {
        Student sobj = new Student();

        // Directly accessing and modifying public field (tight coupling)
        sobj.roll_no = 110;

        // Bypassing validation in setRoll()
        System.out.println("The roll no of student is " + sobj.roll_no);
    }
}


