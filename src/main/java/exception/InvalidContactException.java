package exception;

public class InvalidContactException extends Exception {
    public InvalidContactException() {
    }

    public InvalidContactException(String message) {
        super(message);
    }
}
