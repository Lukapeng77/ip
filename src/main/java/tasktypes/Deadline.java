package tasktypes;

import java.time.LocalDateTime;

import static constants.Constants.*;

/**
 * Represents a deadline task with a specific due date.
 * A {@code DeadLine} object encapsulates the details of a task that needs to be done before a specific date.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructs a {@code DeadLine} with the specified task description and due date.
     *
     * @param description The description of the task.
     * @param by          The deadline date and time for the task.
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline date and time for the task.
     *
     * @return The deadline as a LocalDateTime.
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return A string representing the deadline task with its status, description and deadline.
     */
    @Override
    public String toFileFormat() {
        return String.format("[D][%s] %s (by: %s)", getStatusIcon(), description, by.format(OUTPUT_DATE_FORMAT));
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return A string representing the deadline task with its status, description and deadline.
     */
    @Override
    public String toString() {
        return "  [D]" + super.toString() + " (by: " + by.format(INPUT_DATE_FORMAT) + ")";
    }
}
