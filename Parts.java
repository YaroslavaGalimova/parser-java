package expression;

public interface Parts extends Expression, TripleExpression, ListExpression {
    String toMiniString(Operations last, boolean isLeft);
    int getPriority();
}