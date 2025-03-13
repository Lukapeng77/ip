package tasktypes;

import java.time.LocalDateTime;
import static constants.Constants.*;

public class Deadline extends Task {
    protected LocalDateTime by;

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

    @Override
    public String toFileFormat() {
        return String.format("[D][%s] %s (by: %s)", getStatusIcon(), description, by.format(OUTPUT_DATE_FORMAT));
    }

    @Override
    public String toString() {
        return "  [D]" + super.toString() + " (by: " + by.format(INPUT_DATE_FORMAT) + ")";
    }
}
