package designpatterns.behavioral.day25.command;

// Command Design Pattern - Behavioral DP - Home Task Execution Example


// Client
public class Task5 {
    public static void main(String[] args) {
        System.out.println("Command Pattern Design - Behavioral DP");
        Task task = new Task();
        Mom remote = new Mom();

        Command onCommand = new DoTask(task);
        Command offCommand = new DontDoTask(task);

        remote.setCommand(onCommand); //ac
        remote.executeCommand();   //button press

        remote.setCommand(offCommand); //ac
        remote.executeCommand(); //again clicking the button..

    }
}