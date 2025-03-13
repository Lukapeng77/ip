package exceptions;

public class MissingInputException extends HandleException{
    public MissingInputException(){
        super("OOPS!!! The description of a todo cannot be empty.");
    }

    @Override
    public void printErrorMessage() {
        super.printErrorMessage();
    }
}
