package expression.exceptions;

import java.math.BigInteger;

import expression.Parts;
import expression.Subtract;

public class CheckedSubtract extends Subtract{

    public CheckedSubtract(Parts a, Parts b) {
        super(a, b);
    }
    
    @Override
    protected Number count(Number a, Number b) {
        if (a.getClass() == BigInteger.class) {
            BigInteger A, B;
            A = (BigInteger) a;
            B = (BigInteger) b;
            return A.subtract(B);
        } else {
            int A, B;
            A = (int) a;
            B = (int) b;
            if ((A < Integer.MIN_VALUE + B && B >= 0) || (A > Integer.MAX_VALUE + B && B <= 0)) {
                throw new ArithmeticException("Overflow");
            }
            return A - B;
        }
    }
}
