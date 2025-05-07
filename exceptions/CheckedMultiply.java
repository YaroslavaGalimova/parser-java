package expression.exceptions;

import java.math.BigInteger;

import expression.Multiply;
import expression.Parts;

public class CheckedMultiply extends Multiply{

    public CheckedMultiply(Parts a, Parts b) {
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
            if ((A > 0 && B > 0 && A > Integer.MAX_VALUE / B) ||
            (A > 0 && B < -1 && A > Integer.MIN_VALUE / B) ||
            (A < 0 && B > 0 && A < Integer.MIN_VALUE / B) ||
            (A < 0 && B < 0 && A < Integer.MAX_VALUE / B)) {
                throw CalculateException.error("Overflow");
            }
            return A * B;
        }
    }
}
