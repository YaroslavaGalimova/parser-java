package expression;

import java.util.List;

import expression.exceptions.ParseException;


public class Variable extends NoneOperators {
    String variable;
    final int index;

    public Variable(String variable) {
        this.variable = variable;
        index = -1;
    }

    public Variable(int index) {
        this.index = index;
        variable = "$" + index;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (variable) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new IllegalArgumentException(variable + " is not x, y or z");
        }
    }

    @Override
    public String toString() {
        return variable;
    }

    public void makeName(String name) {
        if (variable.equals("$" + index)) {
            variable = name;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            Variable that = (Variable) obj;
            return variable.equals(that.variable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    @Override
    public int evaluate(List<Integer> variables) {
        if (index < 0 || index > variables.size()) {
            throw ParseException.error("Invalid data in your List");
        }
        return variables.get(index);
    }

}
