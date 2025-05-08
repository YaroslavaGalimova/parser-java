package expression.generic;

import expression.generic.math.Calculate;

public abstract class GenOperation<T> implements GenParts<T> {

    protected GenParts<T> a;
    protected GenParts<T> b;
    private static final int B = 73;
    private static final int MOD = 1000000007;

    public GenOperation(GenParts<T> a, GenParts<T> b) {
        this.a = a;
        this.b = b;
    }

    protected abstract String getSign();

    protected abstract T count(T a, T b, Calculate<T> calc);

    @Override
    public T evaluate(T x, T y, T z, Calculate<T> calc) {
        return count(a.evaluate(x, y, z, calc), b.evaluate(x, y, z, calc), calc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenOperation<?>) {
            GenOperation<?> x = (GenOperation<?>) obj;
            return x.getSign().equals(this.getSign())
                    && x.a.equals(this.a)
                    && x.b.equals(this.b);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(this.a.toString()).append(this.getSign()).append(this.b.toString()).append(")");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        return (a.hashCode() * B * B * B % MOD + 
                this.getSign().hashCode() * B * B % MOD +
                b.hashCode() * B % MOD) % MOD;
    }

    @Override
    public String toMiniString() {
        return a.toMiniString(this, true) + this.getSign() + b.toMiniString(this, false);
    }

    @Override
    public String toMiniString(GenOperation<T> last, boolean isLeft) {
        boolean brackets = GenBrackets.check(last, this, isLeft);
        return (brackets ? "(" : "") + a.toMiniString(this, true) + 
        this.getSign() + b.toMiniString(this, false) + 
        (brackets ? ")" : "");
    }
    
}
