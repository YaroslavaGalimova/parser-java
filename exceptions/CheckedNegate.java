package expression.exceptions;

import java.math.BigInteger;

import expression.Negate;
import expression.Parts;

public class CheckedNegate extends Negate{

    public CheckedNegate(Parts part) {
        super(part);
    }
    
    @Override
    protected Number count(Number a) {
        if (a.getClass() == BigInteger.class) {
            return ((BigInteger)a).negate();
        } else {
            int A = (int) a;
            if (A == Integer.MIN_VALUE) {
                throw CalculateException.error("Overflow");
            }
            return -A;
        }
    }
}
