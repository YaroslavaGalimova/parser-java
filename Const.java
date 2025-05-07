package expression;

import java.util.List;

public class Const extends NoneOperators {
    private final int myConst;
    public Const(int myConst) {
        this.myConst = myConst;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)myConst;
    }

    @Override
    public int evaluate(List<Integer> variables) {
        return (int)myConst;
    }

    public String toString() {
        return Integer.toString(myConst);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == Const.class) {
            return ((Const)obj).myConst == myConst;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return myConst;
    }

    @Override
    public int evaluate(int x) {
        return myConst;
    }
}
