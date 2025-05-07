package expression.generic;

import expression.exceptions.ParseException;
import expression.generic.math.Calculate;


public class GenVariable<T> implements GenParts<T>{

    String variable;

    public GenVariable(String variable) {
        this.variable = variable;
    }
    
    @Override
    public T evaluate(T x, T y, T z, Calculate<T> calc) {
        switch (variable) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new ParseException("Wrong name of variable!");
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            GenVariable<?> that = (GenVariable<?>) obj;
            return variable.equals(that.variable);
        }
        return false;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
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
