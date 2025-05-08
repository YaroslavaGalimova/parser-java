package expression.exceptions;

public class CalculateException extends RuntimeException {
    public CalculateException(String message) {
        super(message);
    }

    public static CalculateException error(String message) {
//        System.err.println(message);
        return new CalculateException(message);
    }
}
