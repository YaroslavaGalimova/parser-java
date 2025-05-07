package expression.generic.parsers;

public interface MiniParser<T> {
    T parse(String expression);
}
