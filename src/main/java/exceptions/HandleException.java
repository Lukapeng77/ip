package exceptions;

public class HandleException extends Exception {
    /**
     * The type of exception that occurred.
     */
    protected ExceptionTypes exception;

    /**
     * Constructs an OrangeException with a specified exception type.
     *
     * @param exception The specific exception type.
     */
    public HandleException(ExceptionTypes exception) {
        super(exception.getMessage()); // Set message
        this.exception = exception;
    }

    /**
     * Retrieves the error message associated with this exception.
     *
     * @return The error message.
     */
    public String getCustomMessage() {
        return exception.getMessage();
    }

}
