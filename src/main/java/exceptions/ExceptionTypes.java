package exceptions;

public enum ExceptionTypes {
    /**
     * Represents a invalid input exception.
     */
    INVALID_INPUT("OOPS!!! I'm sorry, but I don't know what that means :-("),

    /**
     * Represents a missing input exception.
     */
    MISSING_INPUT("OOPS!!! The description of a task cannot be empty."),

    /**
     * Represents a missing deadline due date exception.
     */
    MISSING_CHECK_DATE_BODY("You have not provided a date and time by which to check the date. Try this: checkDate [Date Time]"),

    /**
     * Represents an invalid find task exception.
     */
    INVALID_FINDTASK("You have not entered a task. Try this: find [task]"),

    /**
     * Represents an incorrect date and time format exception.
     */
    INCORRECT_DATE_AND_TIME_FORMAT("Date Or Time Format Provided Is Incorrect. Try in the following formats: \"yyyy-mm-dd HHmm\", \"dd-mm-yyyy HHmm\", \"dd/mm/yyyy HHmm\""),

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
