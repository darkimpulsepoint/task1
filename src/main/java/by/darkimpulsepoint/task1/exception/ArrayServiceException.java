package by.darkimpulsepoint.task1.exception;

public class ArrayServiceException extends Exception {
    public ArrayServiceException() {
    }

    public ArrayServiceException(String message) {
        super(message);
    }

    public ArrayServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayServiceException(Throwable cause) {
        super(cause);
    }
}