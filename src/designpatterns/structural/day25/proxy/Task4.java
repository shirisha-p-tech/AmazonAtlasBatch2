package designpatterns.structural.day25.proxy;

// Proxy Design Pattern — Role-Based Database Operation Control


public class Task4{
    public static void main(String[] args) {
        System.out.println("Proxy Design Pattern - Structural DP\n");

        System.out.println("ADMIN Operations:");
        DatabaseExecute adminDB = new ProxyDataBase("ADMIN");
        adminDB.executeQuery("Delete");
        adminDB.executeQuery("Write");
        adminDB.executeQuery("Read");

        System.out.println("\nHR Operations:");
        DatabaseExecute hrDB = new ProxyDataBase("HR");
        hrDB.executeQuery("Delete");
        hrDB.executeQuery("Write");
        hrDB.executeQuery("Read");

        System.out.println("\nOTHER EMPLOYEE Operations:");
        DatabaseExecute employeeDB = new ProxyDataBase("OTHER EMPLOYEE");
        employeeDB.executeQuery("Delete");
        employeeDB.executeQuery("Write");
        employeeDB.executeQuery("Read");
    }
}
