package exception;

public class InvalidDeviceException extends Exception {
    public InvalidDeviceException() {
    }

    public InvalidDeviceException(String message) {
        super(message);
    }
}
