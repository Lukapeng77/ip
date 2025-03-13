package exceptions;

public class HandleException extends Exception {
    protected ExceptionTypes exception;

    public HandleException(ExceptionTypes exception) {
        super(exception.getMessage());
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
