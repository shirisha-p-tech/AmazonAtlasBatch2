package ooad.day20;
// Employee Report Generation and sending email
class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}

class ReportGenerator {
    public void generatePdfReport(Employee employee) {
        System.out.println("Generating PDF Report:");
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Email: " + employee.getEmail());
        System.out.printf("Salary: $%.2f" , employee.getSalary());
        System.out.println("\nReport generated successfully!\n");
    }
}

class EmailSender {
    public void sendEmail(Employee employee, String message) {
        System.out.println("Sending email to " + employee.getEmail());
        System.out.println("Message: " + message);
        System.out.println("Email sent successfully.\n");
    }
}


public class Task4 {
    public static void main(String[] args) {
        // Create an employee
        Employee employee = new Employee("John A", "johna@example.com", 85000);

        // Generate PDF report
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generatePdfReport(employee);

        // Send Email
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(employee, "Your performance report is ready.");
    }
}







/*
//SRP Violation code
class Employee {

    private String name;
    private String email;
    private double salary;

    // Methods related to employee data

    // Method to generate PDF report
    public void generatePdfReport() {
        // Code to generate PDF report
    }

    // Method to send email
    public void sendEmail() {
        // Code to send email
    }
}
*/
