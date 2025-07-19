package ooad.day20;
// Student Management System – Registration, Marks & Fee Calculation
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    String course;
    int[] marks;
    double feePerSemester;
    int semesters;

    // Method 1: registrationDetails()
    public void registrationDetails(String name, int rollNo, String course, int semesters, double feePerSemester) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.semesters = semesters;
        this.feePerSemester = feePerSemester;

        System.out.println("\nStudent Registered:");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("Semesters: " + semesters);
        System.out.println("Fee per Semester: ₹" + feePerSemester);
    }

    // Method 2: marksCalc()
    public void marksCalc(int[] marks) {
        this.marks = marks;
        int total = 0;

        System.out.println("\nMarks Entered:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
            total += marks[i];
        }

        double average = total / (double) marks.length;
        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Marks: " + average);
    }

    // Method 3: feesCalc()
    public void feesCalc() {
        double totalFees = feePerSemester * semesters;
        System.out.println("\nTotal Fees for the Course: ₹" + totalFees);
    }

}
public class Task7{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        // Get registration details
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter number of semesters: ");
        int semesters = sc.nextInt();

        System.out.print("Enter fee per semester: ");
        double feePerSemester = sc.nextDouble();

        s.registrationDetails(name, rollNo, course, semesters, feePerSemester);

        // Get marks

        System.out.println("\nEnter number of subjects in course");
        int subjects = sc.nextInt();
        int[] marks = new int[subjects];
        System.out.println("\nEnter marks for all subjects:");
        for (int i = 0; i < subjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        s.marksCalc(marks);
        s.feesCalc();

        sc.close();
    }
}


