package expression.generic;

import expression.generic.math.Calculate;

public class GenMin<T> extends GenOperation<T> {

    public GenMin(GenParts<T> a, GenParts<T> b) {
        super(a, b);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected String getSign() {
        return "min";
    }

    @Override
    protected T count(T a, T b, Calculate<T> calc) {
        return calc.min(a, b);
    }
    
}
