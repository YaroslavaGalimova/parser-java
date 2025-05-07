package expression.generic.math;

import expression.exceptions.CalculateException;

public class BooleanCalc implements Calculate<Boolean> {

    @Override
    public Boolean add(Boolean a, Boolean b) {
        return a || b;
    }

    @Override
    public Boolean subtract(Boolean a, Boolean b) {
        return !(a == b);
    }

    @Override
    public Boolean multiply(Boolean a, Boolean b) {
        return a && b;
    }

    @Override
    public Boolean divide(Boolean a, Boolean b) {
        if (!b) {
            throw new CalculateException("Division by zero");
        }
        return a;
    }

    @Override
    public Boolean negate(Boolean a) {
        return a;
    }

    @Override
    public Boolean min(Boolean a, Boolean b) {
        return a && b;
    }

    @Override
    public Boolean max(Boolean a, Boolean b) {
        return a || b;
    }

    @Override
    public Boolean count(Boolean a) {
        return a;
    }

    @Override
    public Boolean cast(int a) {
        return a != 0;
    }
    
}
