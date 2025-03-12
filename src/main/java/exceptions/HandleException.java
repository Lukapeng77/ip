package exceptions;

public class HandleException extends Exception {
    protected ExceptionTypes exceptionType;

    public HandleException(ExceptionTypes exceptionType){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public String getMessage(){
        return exceptionType.getMessage();
    }
}
