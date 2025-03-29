package exceptions;

public class HandleException extends Exception {

    /**
     * Constructs an HandleException with a specified exception type.
     *
     * @param message The specific error message describing the exception type.
     */
    public HandleException(String message) {
        super(message);
    }
}
