package tasktypes;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        // true: "X"; false: " "
        return (isDone ? "X" : " "); // mark done task with X
    }

    //mark the task done or not
    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    public String toFileFormat() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + this.getDescription();
    }
}
