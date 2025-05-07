package expression;

import java.math.BigInteger;


public class Min extends Operations{

    public Min(Parts a, Parts b) {
        super(a, b);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected Number count(Number a, Number b) {
        if (a.getClass() == BigInteger.class) {
            return ((BigInteger)a).compareTo((BigInteger)b) <= 0 ? (BigInteger)a : (BigInteger)b;
        } else {
            int A, B;
            A = (int) a;
            B = (int) b;
            return (A < B) ? A : B;
        }
    }

    @Override
    protected String getSign() {
        return " min ";
    }
    
}
