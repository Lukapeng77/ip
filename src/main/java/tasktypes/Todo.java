package tasktypes;

/**
 * Represents a Todo task that does not have a specific deadline or time range.
 */
public class Todo extends Task {
    /**
     * Constructs a Todo task with a description.
     *
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the Todo task in a file-friendly format.
     *
     * @return A string representing the Todo task in a file-friendly format.
     * Adds the to-do type identifier "[T]" before the standard task representation.
     */
    @Override
    public String toFileFormat() {
        return String.format("[T][%s] %s", getStatusIcon(), description);
    }

    /**
     * Returns the string representation of the Todo task.
     *
     * @return A string representing the Todo task with its status and description.
     */
    @Override
    public String toString() {
        return "  [T]" + super.toString();
    }
}
