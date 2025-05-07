package expression.generic.parsers;

import java.math.BigInteger;

public class ParseBigInteger implements MiniParser<BigInteger>{

    @Override
    public BigInteger parse(String expression) {
        try {
            return new BigInteger(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse BigInteger");
        }
    }
    
}
