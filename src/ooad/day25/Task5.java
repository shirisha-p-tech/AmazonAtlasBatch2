package ooad.day25;

// Command Design Pattern - Behavioral DP - Home Task Execution Example

interface Command {
    public void doIt(); //executing a command
}


class DontDoTask implements Command{
    private Task task;

    public DontDoTask(Task task) {
        this.task = task;
    }
    public void doIt() {
        this.task.dont();
    }
}


class DoTask implements Command{
    private Task task;

    public DoTask(Task task) {
        this.task = task;
    }
    public void doIt() {
        this.task.doo();
    }
}





//controller
class Mom {
    Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        this.command.doIt();
    }
}



class Task {
    public void doo() {
        System.out.println("do your home tasks");
    }
    public void dont() {
        System.out.println("dont do your home tasks");
    }
}


// invoker
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