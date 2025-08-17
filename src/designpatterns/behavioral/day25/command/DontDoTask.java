package designpatterns.behavioral.day25.command;

// Concrete Command
public class DontDoTask implements Command {
    private Task task;

    public DontDoTask(Task task) {
        this.task = task;
    }

    public void doIt() {
        this.task.dont();
    }
}
