package expression.generic.math;

public class DoubleCalc implements Calculate<Double> {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double negate(Double a) {
        return -a;
    }

    @Override
    public Double min(Double a, Double b) {
        return Math.min(a, b);
    }

    @Override
    public Double max(Double a, Double b) {
        return Math.max(a, b);
    }

    @Override
    public Double count(Double a) {
        return (double)Long.bitCount(Double.doubleToLongBits(a));
    }

    @Override
    public Double cast(int a) {
        return (double)a;
    }
    
}
