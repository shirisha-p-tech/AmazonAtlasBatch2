package designpatterns.behavioral.day25.command;

// Invoker
public class Mom {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        this.command.doIt();
    }
}
