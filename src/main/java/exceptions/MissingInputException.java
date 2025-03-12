<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
