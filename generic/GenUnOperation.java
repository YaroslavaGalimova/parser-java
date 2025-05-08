package expression.generic;

import expression.generic.math.Calculate;

public abstract class GenUnOperation<T> implements GenParts<T> {

    GenParts<T> part;

    public GenUnOperation(GenParts<T> part) {
        this.part = part;
    }

    protected abstract String getSign();

    public int getPriority() {
        return 6;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getSign()).append("(").append(part.toString()).append(")");
        return sb.toString();
    }

    @Override
    public String toMiniString() {
        if (part.getPriority() == getPriority()) {
            return getSign() + " " + part.toMiniString();
        }
        return getSign() + "(" + part.toMiniString() + ")";
    }

    @Override
    public String toMiniString(GenOperation<T> last, boolean isLeft) {
        return toMiniString();
    }

    protected abstract T count(T a, Calculate<T> calc);

    @Override
    public T evaluate(T x, T y, T z, Calculate<T> calc) {
        return count(part.evaluate(x, y, z, calc), calc);
    }

}
