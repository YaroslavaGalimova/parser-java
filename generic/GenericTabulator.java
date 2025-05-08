package expression.generic;

import java.math.BigInteger;

import expression.exceptions.CalculateException;
import expression.exceptions.ParseException;
import expression.generic.math.*;
import expression.generic.parsers.*;

public class GenericTabulator implements Tabulator{

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws ParseException {
        switch(mode) {
            case "i": {
                GenParts<Integer> result = new GenericParser().parse(expression, new ParseInt());
                return tabulate(result, new CheckedIntCalc(), x1, x2, y1, y2, z1, z2);
            } case "d": {
                GenParts<Double> result = new GenericParser().parse(expression, new ParseDouble());
                return tabulate(result, new DoubleCalc(), x1, x2, y1, y2, z1, z2);
            } case "bi":{
                GenParts<BigInteger> result = new GenericParser().parse(expression, new ParseBigInteger());
                return tabulate(result, new BigIntegerCalc(), x1, x2, y1, y2, z1, z2);
            } case "u": {
                GenParts<Integer> result = new GenericParser().parse(expression, new ParseInt());
                return tabulate(result, new IntCalc(), x1, x2, y1, y2, z1, z2);
            } case "b": {
                GenParts<Byte> result = new GenericParser().parse(expression, new ParseByte());
                return tabulate(result, new ByteCalc(), x1, x2, y1, y2, z1, z2);
            } case "bool": {
                GenParts<Boolean> result = new GenericParser().parse(expression, new ParseBoolean());
                return tabulate(result, new BooleanCalc(), x1, x2, y1, y2, z1, z2);
            } default:
                throw new CalculateException("incorrect mode :(");
        }
        
    }

    private <T> Object[][][] tabulate(GenParts<T> result, Calculate<T> calc, int x1, int x2, int y1, int y2, int z1, int z2) {
        Object[][][] answer = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    Object eval = null;
                    try {
                        eval = result.evaluate(calc.cast(x), calc.cast(y), calc.cast(z), calc);
                    } catch(CalculateException | ArithmeticException e) {}
                    answer[x - x1][y - y1][z - z1] = eval;
                }
            }
        }
        return answer;
    }
    
}
