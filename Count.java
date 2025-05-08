package expression;

import java.math.BigInteger;


public class Count extends UnOperations {

    public Count(Parts part) {
        super(part);
    }

    @Override
    protected String getSign() {
        return "count";
    }

    @Override
    protected Number count(Number a) {
        if (a.getClass() == BigInteger.class) {
            return new BigInteger(Integer.toString(((BigInteger)a).bitCount()));
        } else {
            return Integer.bitCount((int)a);
        }
    }
}
