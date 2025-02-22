package exceptions;

public class HandleException extends Exception {
    public HandleException(String message) {
        super(message);
    }

    public void printErrorMessage() {
        System.out.println("Error: " + getMessage());
    }

}
