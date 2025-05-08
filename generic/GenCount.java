package expression.generic;

import expression.generic.math.Calculate;

public class GenCount<T> extends GenUnOperation<T> {

    public GenCount(GenParts<T> part) {
        super(part);
    }

    @Override
    protected String getSign() {
        return "count";
    }

    @Override
    protected T count(T a, Calculate<T> calc) {
        return calc.count(a);
    }
    
}
