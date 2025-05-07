package expression.generic.math;

import java.math.BigInteger;

public class BigIntegerCalc implements Calculate<BigInteger> {

    @Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    @Override
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    @Override
    public BigInteger min(BigInteger a, BigInteger b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    @Override
    public BigInteger max(BigInteger a, BigInteger b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    @Override
    public BigInteger count(BigInteger a) {
        return new BigInteger(Integer.toString(a.bitCount()));
    }

    @Override
    public BigInteger cast(int a) {
        return new BigInteger(Integer.toString(a));
    }
    
}
