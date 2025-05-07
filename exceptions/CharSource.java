package expression.exceptions;

public interface CharSource {
    void reset();
    void mark();
    boolean hasNext();
    char next();
    IllegalArgumentException error(String message);
}
