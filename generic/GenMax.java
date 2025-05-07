package expression.generic;

import expression.generic.math.Calculate;

public class GenMax<T> extends GenOperation<T> {

    public GenMax(GenParts<T> a, GenParts<T> b) {
        super(a, b);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected String getSign() {
        return "max";
    }

    @Override
    protected T count(T a, T b, Calculate<T> calc) {
        return calc.max(a, b);
    }
    
}
