package exceptions;

public enum ExceptionTypes {
    /**
     * Represents a missing deadline exception.
     */
    MISSING_DEADLINE("You didn't provide a deadline date and time! Usage: /by [Date And Time Deadline Task Is Due]"),

    INVALID_INPUT("OOPS!!! I'm sorry, but I don't know what that means :-("),

    MISSING_INPUT("OOPS!!! The description of a todo cannot be empty."),
    /**
     * Represents an invalid task number exception.
     */
    //INVALID_TASKNUMBER( "You have provided an invalid task number. Try again using a number from the range 0 - " + (TaskList.getInstance().getSize()) + " Usage: mark/unmark/delete [taskNumber] (Add a space between the keyword and taskNumber)"),

    /**
     * Represents a missing todo description exception.
     */
    MISSING_TODO_DESCRIPTION("You have provided an invalid/missing todo description. Todo descriptions cannot be empty. Try again. Usage: todo [todo task description]"),

    /**
     * Represents a missing /by keyword in deadline exception.
     */
    MISSING_DEADLINE_BYWORD("You have not used the /by in your deadline command. Try this: deadline [deadline task description] /by [Date And Time task is due]"),

    /**
     * Represents a missing deadline description exception.
     */
    MISSING_DEADLINE_DESCRIPTION("You have not provided a deadline task description. Deadline descriptions cannot be empty. Try this: deadline [deadline task description] /by [Date And Time task is due]"),

    /**
     * Represents a missing deadline due date exception.
     */
    MISSING_DEADLINE_DOBY("You have not provided a date and time by which to complete the deadline. Try this: deadline [deadline task description] /by [Date And Time task is due]"),

    /**
     * Represents a missing /to keyword in event exception.
     */
    MISSING_EVENT_TOWORD("You have not used the /to in your event command. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents a missing event description exception.
     */
    MISSING_EVENT_DESCRIPTION("You have not provided an event task description. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents a missing event start date exception.
     */
    MISSING_EVENT_STARTON("You have not provided the start date for your event. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents a missing event due date exception.
     */
    MISSING_EVENT_DOBY("You have not provided a date and time by which to complete the event. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents a missing /from keyword in event exception.
     */
    MISSING_EVENT_FROMWORD("You have not used the /from in your event command. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents an extra /by keyword in deadline exception.
     */
    EXTRA_BY_IN_DEADLINE("You have used extra /by in the deadline command, this is not allowed. Try this: deadline [deadline task description] /by [Date And Time task is due]"),

    /**
     * Represents an extra /from keyword in event exception.
     */
    EXTRA_FROM_IN_EVENT("You have used extra /from in the event command, this is not allowed. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents an extra /to keyword in event exception.
     */
    EXTRA_TO_IN_EVENT("You have used extra /to in the event command, this is not allowed. Try this: event [event task description] /from [Date And Time task starts on] /to [Date And Time task is due]"),

    /**
     * Represents an invalid find task exception.
     */
    INVALID_FINDTASK("You have not entered a task. Try this: find [task]"),

    /**
     * Represents an incorrect date and time format exception.
     */
    INCORRECT_DATE_AND_TIME_FORMAT("Date And Time Format Provided Is Incorrect. Try in this format: yyyy-mm-dd HH:mm"),

    /**
     * Represents an invalid date or time exception.
     */
    INVALID_DATE_OR_TIME("You have entered an invalid date or time, the format is correct. Try in this format: yyyy-mm-dd HH:mm"),

    /**
     * Represents an invalid date exception.
     */
    INVALID_DATE("You have entered an invalid date. Try in this format: yyyy-mm-dd");

    /**
     * The error message associated with the exception type.
     */
    private final String message;

    /**
     * Constructs an ExceptionType with a specific message.
     *
     * @param message The error message.
     */
    ExceptionTypes(String message) {
        this.message = message;
    }


    /**
     * Retrieves the error message associated with the exception type.
     *
     * @return The error message.
     */
    public String getMessage() {
        return this.message;
    }
}
