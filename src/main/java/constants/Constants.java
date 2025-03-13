package constants;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String LINE_SEPARATOR = "____________________________________________________________\n";
    public static final String INDENT = "%s";

    public static final DateTimeFormatter INPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    public static final DateTimeFormatter SEARCH_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern(" MMM dd yyyy, hh:mm a ");

    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_FIND = "find";
    public static final String COMMAND_MARK = "mark";
    public static final String COMMAND_UNMARK = "unmark";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_EVENT = "event";
    public static final String COMMAND_CHECK_DATE = "checkDate";
    public static final String COMMAND_GOODBYE = "bye";

    public static final String IDENTIFIER_BY = " /by ";
    public static final String IDENTIFIER_FROM = " /from ";
    public static final String IDENTIFIER_TO = " /to ";

    public static final String UNKNOWN_COMMAND = "No idea what that means, please give the command with a keyword! List of keywords: \"mark\", \"unmark\", \"list\", \"todo\", \"event\", \"deadline\", \"delete\", \"checkDate\"";
    public static final String MESSAGE_BOUNDARY_ERROR = "Out of bounds!";
    public static final String MESSAGE_MARKING_ERROR = "Error marking task!";
    public static final String MESSAGE_DELETING_ERROR = "Error deleting task!";
}