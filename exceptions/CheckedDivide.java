package expression.exceptions;

import java.math.BigInteger;

import expression.Divide;
import expression.Parts;

public class CheckedDivide extends Divide {

    public CheckedDivide(Parts a, Parts b) {
        super(a, b);
    }

    @Override
    protected Number count(Number a, Number b) {
        if (a.getClass() == BigInteger.class) {
            BigInteger A, B;
            A = (BigInteger) a;
            B = (BigInteger) b;
            return A.divide(B);
        } else {
            int A, B;
            A = (int) a;
            B = (int) b;
            if (B == 0) {
                throw CalculateException.error("Division by zero");
            }
            if (B == -1 && A == Integer.MIN_VALUE) {
                throw CalculateException.error("Overflow");
            }
            return A / B;
        }
    }

}
