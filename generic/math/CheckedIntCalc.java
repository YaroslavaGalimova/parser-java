package expression.generic.math;

import expression.exceptions.CalculateException;

public class CheckedIntCalc extends IntCalc {

    @Override
    public Integer add(Integer a, Integer b) {
        if ((a > Integer.MAX_VALUE - b && b >= 0) || (a < Integer.MIN_VALUE - b && b <= 0)) {
                throw CalculateException.error("Overflow");
            }
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        if ((a < Integer.MIN_VALUE + b && b >= 0) || (a > Integer.MAX_VALUE + b && b <= 0)) {
            throw new ArithmeticException("Overflow");
        }
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if ((a > 0 && b > 0 && a > Integer.MAX_VALUE / b) ||
            (a > 0 && b < -1 && a > Integer.MIN_VALUE / b) ||
            (a < 0 && b > 0 && a < Integer.MIN_VALUE / b) ||
            (a < 0 && b < 0 && a < Integer.MAX_VALUE / b)) {
                throw CalculateException.error("Overflow");
            }
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw CalculateException.error("Division by zero");
        }
        if (b == -1 && a == Integer.MIN_VALUE) {
            throw CalculateException.error("Overflow");
        }
        return a / b;
    }

    @Override
    public Integer negate(Integer a) {
        if (a == Integer.MIN_VALUE) {
            throw CalculateException.error("Overflow");
        }
        return -a;
    }
}
