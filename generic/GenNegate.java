package expression.generic;

import expression.generic.math.Calculate;

public class GenNegate<T> extends GenUnOperation<T> {

    public GenNegate(GenParts<T> a) {
        super(a);
    }

    @Override
    protected String getSign() {
        return "-";
    }

    @Override
    protected T count(T a, Calculate<T> calc) {
        return calc.negate(a);
    }
    
}
