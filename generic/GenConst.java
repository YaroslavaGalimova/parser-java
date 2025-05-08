package expression.generic;

import expression.generic.math.Calculate;

public class GenConst<T> implements GenParts<T> {
    private final T myConst;
    public GenConst(T myConst) {
        this.myConst = myConst;
    }
    @Override
    public T evaluate(T x, T y, T z, Calculate<T> calc) {
        return myConst;
    }
    public String toString() {
        return myConst.toString();
    }

    @Override
    public String toMiniString(GenOperation<T> last, boolean isLeft) {
        return this.toString();
    }
    @Override
    public int getPriority() {
        return 6;
    }
    
}
