package expression.exceptions;

public class ParseException extends RuntimeException{
    public ParseException(String message) {
        super(message);
    }

    public static ParseException error(String message) {
        return new ParseException(message);
    }
}
