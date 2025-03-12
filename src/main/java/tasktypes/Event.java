package tasktypes;

import java.time.LocalDateTime;
import static constants.Constants.INPUT_DATE_FORMAT;
import static constants.Constants.OUTPUT_DATE_FORMAT;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;


    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

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
