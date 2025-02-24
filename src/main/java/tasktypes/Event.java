package tasktypes;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormat() {
        return String.format("[E][%s] %s (from: %s to: %s)", getStatusIcon(), description, from, to);
    }

    @Override
    public String toString() {
        return "  [E]" + super.toString() + " (from: " + from + " to: " + to + ")";

    }
}
