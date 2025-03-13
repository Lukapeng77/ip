package exceptions;

public class InvalidInputException extends HandleException{
    public InvalidInputException(){
        super("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    @Override
    public void printErrorMessage() {
        super.printErrorMessage();
    }
}
