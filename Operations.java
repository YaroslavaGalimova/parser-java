package expression;

import java.util.List;


public abstract class Operations implements Parts{
    protected Parts a;
    protected Parts b;
    private static final int B = 73;
    private static final int MOD = 1000000007;

    public Operations(Parts a, Parts b) {
        this.a = a;
        this.b = b;
    }

    protected abstract Number count(Number a, Number b);

    protected abstract String getSign();


    @Override
    public int evaluate(int x) {
        return (int)count(a.evaluate(x), b.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)count(a.evaluate(x, y, z), b.evaluate(x, y, z));
    }

    @Override
    public int evaluate(List<Integer> variables) {
        return (int)count(a.evaluate(variables), b.evaluate(variables));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && this.getClass() == obj.getClass()) {
            Operations x = (Operations) obj;
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
    public String toMiniString(Operations last, boolean isLeft) {
        boolean brackets = Brackets.check(last, this, isLeft);
        return (brackets ? "(" : "") + a.toMiniString(this, true) + 
        this.getSign() + b.toMiniString(this, false) + 
        (brackets ? ")" : "");
    }

}
