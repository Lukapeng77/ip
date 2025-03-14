package constants;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The {@code Constants} class defines various constants used throughout the application,
 * including date-time formats, command keywords, and error messages.
 */
public class Constants {

    /**
     * Line separator used for UI formatting.
     */
    public static final String LINE_SEPARATOR = "____________________________________________________________\n";

    /**
     * Indentation format used in printed messages.
     */
    public static final String INDENT = "%s";

    /**
     * Default input date-time format for parsing user input.
     */
    public static final DateTimeFormatter INPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /**
     * List of multiple supported date-time formats for user input.
     */
    public static final List<DateTimeFormatter> INPUT_DATE_FORMATS = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),  // Default format
            DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"),  // Format with slashes
            DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm")   // Format with dashes
    );

    /**
     * Output date-time format for displaying task dates to users.
     */
    public static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern(" MMM dd yyyy, hh:mm a ");

    // Command keywords

    /**
     * Command keyword for listing tasks.
     */
    public static final String COMMAND_LIST = "list";

    /**
     * Command keyword for searching tasks by keyword.
     */
    public static final String COMMAND_FIND = "find";

    /**
     * Command keyword for marking a task as completed.
     */
    public static final String COMMAND_MARK = "mark";

    /**
     * Command keyword for unmarking a task (marking it as incomplete).
     */
    public static final String COMMAND_UNMARK = "unmark";

    /**
     * Command keyword for deleting a task.
     */
    public static final String COMMAND_DELETE = "delete";

    /**
     * Command keyword for adding a new to-do task.
     */
    public static final String COMMAND_TODO = "todo";

    /**
     * Command keyword for adding a new deadline task.
     */
    public static final String COMMAND_DEADLINE = "deadline";

    /**
     * Command keyword for adding a new event task.
     */
    public static final String COMMAND_EVENT = "event";

    /**
     * Command keyword for checking tasks on a specific date.
     */
    public static final String COMMAND_CHECK_DATE = "checkDate";

    /**
     * Command keyword for exiting the application.
     */
    public static final String COMMAND_GOODBYE = "bye";

    // Identifiers used for parsing task details

    /**
     * Identifier for specifying a deadline date in user input.
     */
    public static final String IDENTIFIER_BY = " /by ";

    /**
     * Identifier for specifying an event start date in user input.
     */
    public static final String IDENTIFIER_FROM = " /from ";

    /**
     * Identifier for specifying an event end date in user input.
     */
    public static final String IDENTIFIER_TO = " /to ";

    // Error messages and UI responses

    /**
     * Message displayed when an unknown command is entered.
     */
    public static final String UNKNOWN_COMMAND =
            "No idea what that means, please give the command with a keyword! " +
                    "List of keywords: \"mark\", \"unmark\", \"list\", \"todo\", \"event\", " +
                    "\"deadline\", \"delete\", \"checkDate\"";

    /**
     * Error message displayed when an index is out of bounds.
     */
    public static final String MESSAGE_BOUNDARY_ERROR = "Out of bounds!";

    /**
     * Error message displayed when marking a task fails.
     */
    public static final String MESSAGE_MARKING_ERROR = "Error marking task!";

    /**
     * Error message displayed when deleting a task fails.
     */
    public static final String MESSAGE_DELETING_ERROR = "Error deleting task!";
}