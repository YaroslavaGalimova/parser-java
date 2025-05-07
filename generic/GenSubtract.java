package expression.generic;

import expression.generic.math.Calculate;

public class GenSubtract<T> extends GenOperation<T> {

    public GenSubtract(GenParts<T> a, GenParts<T> b) {
        super(a, b);
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    protected String getSign() {
        return "-";
    }

    @Override
    protected T count(T a, T b, Calculate<T> calc) {
        return calc.subtract(a, b);
    }
    
}
