package designpatterns.behavioral.day25.command;

// Concrete Command
public class DoTask implements Command {
    private Task task;

    public DoTask(Task task) {
        this.task = task;
    }

    public void doIt() {
        this.task.doo();
    }
}
