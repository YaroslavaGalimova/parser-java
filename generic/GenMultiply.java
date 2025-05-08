package expression.generic;

import expression.generic.math.Calculate;

public class GenMultiply<T> extends GenOperation<T> {

    public GenMultiply(GenParts<T> a, GenParts<T> b) {
        super(a, b);
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    protected String getSign() {
        return "*";
    }

    @Override
    protected T count(T a, T b, Calculate<T> calc) {
        return calc.multiply(a, b);
    }
    
}
