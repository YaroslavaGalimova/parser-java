package expression.generic;

import expression.ToMiniString;
import expression.generic.math.Calculate;

public interface GenParts<T> extends ToMiniString {
    T evaluate(T x, T y, T z, Calculate<T> calc);
    String toMiniString(GenOperation<T> last, boolean isLeft);
    int getPriority();
}
