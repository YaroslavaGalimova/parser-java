package expression.generic.math;

public class IntCalc implements Calculate<Integer> {

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    @Override
    public Integer negate(Integer a) {
        return -a;
    }

    @Override
    public Integer min(Integer a, Integer b) {
        return Math.min(a, b);
    }

    @Override
    public Integer max(Integer a, Integer b) {
        return Math.max(a, b);
    }

    @Override
    public Integer count(Integer a) {
        return Integer.bitCount(a);
    }

    @Override
    public Integer cast(int a) {
        return a;
    }
    
}
