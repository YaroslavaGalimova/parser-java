package expression.generic.math;

public class ByteCalc implements Calculate<Byte> {

    @Override
    public Byte add(Byte a, Byte b) {
        return (byte)(a + b);
    }

    @Override
    public Byte subtract(Byte a, Byte b) {
        return (byte)(a - b);
    }

    @Override
    public Byte multiply(Byte a, Byte b) {
        return (byte)(a * b);
    }

    @Override
    public Byte divide(Byte a, Byte b) {
        return (byte)(a / b);
    }

    @Override
    public Byte negate(Byte a) {
        return (byte)(-a);
    }

    @Override
    public Byte min(Byte a, Byte b) {
        return (byte)Math.min(a, b);
    }

    @Override
    public Byte max(Byte a, Byte b) {
        return (byte)Math.max(a, b);
    }

    @Override
    public Byte count(Byte a) {
        return (byte)Integer.bitCount(a & 0xff);
    }

    @Override
    public Byte cast(int a) {
        return (byte)a;
    }
    
}
