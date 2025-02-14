package tasktypes;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toFileFormat() {
        return String.format("[T][%s] %s", getStatusIcon(), description);
    }

    @Override
    public String toString() {
        return "  [T]" + super.toString();
    }
}
