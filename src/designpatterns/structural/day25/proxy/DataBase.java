package designpatterns.structural.day25.proxy;

// The Real Subject
public class DataBase {
    void execute(String query, String desig) {
        System.out.println("Query execution in process: " + query + " by " + desig);
    }
}
