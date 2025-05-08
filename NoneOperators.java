package expression;

public abstract class NoneOperators implements Parts{

    @Override
    public String toMiniString(Operations last, boolean isLeft) {
        return this.toString();
    }

    @Override
    public int getPriority() {
        return 6;
    }
}
