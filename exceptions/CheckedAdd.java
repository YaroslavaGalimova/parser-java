package expression.exceptions;

import java.math.BigInteger;

import expression.Add;
import expression.Parts;

public class CheckedAdd extends Add {

    public CheckedAdd(Parts a, Parts b) {
        super(a, b);
    }
    
    @Override
    protected Number count(Number a, Number b) {
        if (a.getClass() == BigInteger.class) {
            BigInteger A, B;
            A = (BigInteger) a;
            B = (BigInteger) b;
            return A.add(B);
        } else {
            int A, B;
            A = (int) a;
            B = (int) b;
            if ((A > Integer.MAX_VALUE - B && B >= 0) || (A < Integer.MIN_VALUE - B && B <= 0)) {
                throw CalculateException.error("Overflow");
            }
            return A + B;
        }
    }
}
