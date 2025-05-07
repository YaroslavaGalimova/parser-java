package expression.exceptions;

public class StringSource implements CharSource {
    private final String data;
    private int pos = 0;
    private int point = -1;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public IllegalArgumentException error(final String message) {
        return new IllegalArgumentException(pos + ": " + message);
    }

    public void mark() {
        point = pos - 1;
    }

    public void reset() {
        pos = point >= 0 ? point : pos;
    }
}
