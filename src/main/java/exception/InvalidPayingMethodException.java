package exception;

public class InvalidPayingMethodException extends Exception {
    public InvalidPayingMethodException() {
    }

    public InvalidPayingMethodException(String message) {
        super(message);
    }
}
