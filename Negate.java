package expression;

import java.math.BigInteger;


public class Negate extends UnOperations {

    public Negate(Parts part) {
        super(part);
    }

    @Override
    protected Number count(Number a) {
        if (a.getClass() == BigInteger.class) {
            return ((BigInteger)a).negate();
        } else {
            int A = (int) a;
            return -A;
        }
    }


    @Override
    protected String getSign() {
        return "-";
    }
}
