package expression;

import java.util.List;


public abstract class UnOperations implements Parts {

    Parts part;

    public UnOperations(Parts part) {
        this.part = part;
    }

    protected abstract Number count(Number a);

    protected abstract String getSign();

    public int getPriority() {
        return 6;
    }

    @Override
    public int evaluate(int x) {
        return (int)count(part.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)count(part.evaluate(x, y, z));
    }

    @Override
    public int evaluate(List<Integer> variables) {
        return (int)count(part.evaluate(variables));
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
    public String toMiniString(Operations last, boolean isLeft) {
        return toMiniString();
    }

}
