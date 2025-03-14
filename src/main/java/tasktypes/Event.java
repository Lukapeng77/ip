package tasktypes;

import java.time.LocalDateTime;

import static constants.Constants.*;

/**
 * Represents an event task with a start and end time.
 * An {@code Event} object encapsulates the details of a task that occurs over a period defined by a start and end time.
 */
public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructs an {@code Event} with the specified task description, start time, and end time.
     *
     * @param description The description of the event task.
     * @param from        The start time of the event.
     * @param to          The end time of the event.
     */
    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start date and time for the event.
     *
     * @return The start date and time as a LocalDateTime.
     */
    public LocalDateTime getFrom() {
        return from;
    }

    /**
     * Returns the end date and time for the event.
     *
     * @return The end date and time as a LocalDateTime.
     */
    public LocalDateTime getTo() {
        return to;
    }

    /**
     * Returns the string representation of the event task in a format suitable for file storage.
     * The String format "E" indicates an event task.
     *
     * @return A string representation of the event task for file storage.
     */
    @Override
    public String toFileFormat() {
        return String.format("[E][%s] %s (from: %s to: %s)", getStatusIcon(), description, from.format(OUTPUT_DATE_FORMAT), to.format(OUTPUT_DATE_FORMAT));
    }

    /**
     * Returns the string representation of the event task, including its status (done or not done),
     * description, and the period over which it occurs (from start time to end time).
     *
     * @return A string representation of the event task, including status, description, and period.
     */
    @Override
    public String toString() {
        return "  [E]" + super.toString() + " (from: " + from.format(INPUT_DATE_FORMAT) + " to: " + to.format(INPUT_DATE_FORMAT) + ")";

    }
}
