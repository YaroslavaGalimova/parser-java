package expression;

import java.math.BigInteger;


public class Multiply extends Operations{
    public Multiply(Parts a, Parts b) {
        super(a, b);
    }

    @Override
    protected Number count(Number a, Number b) {
        if (a.getClass() == BigInteger.class) {
            BigInteger A, B;
            A = (BigInteger) a;
            B = (BigInteger) b;
            return A.multiply(B);
        } else {
            int A, B;
            A = (int) a;
            B = (int) b;
            return A * B;
        }
    }

    @Override
    public String getSign() {
        return " * ";
    }

    @Override
    public int getPriority() {
        return 5;
    }
}
