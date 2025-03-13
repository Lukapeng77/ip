package tasktypes;

import java.time.LocalDateTime;
import static constants.Constants.*;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

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

    @Override
    public String toFileFormat() {
        return String.format("[E][%s] %s (from: %s to: %s)", getStatusIcon(), description, from.format(OUTPUT_DATE_FORMAT), to.format(OUTPUT_DATE_FORMAT));
    }

    @Override
    public String toString() {
        return "  [E]" + super.toString() + " (from: " + from.format(INPUT_DATE_FORMAT) + " to: " + to.format(INPUT_DATE_FORMAT) + ")";

    }
}
