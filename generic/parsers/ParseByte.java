package expression.generic.parsers;

public class ParseByte implements MiniParser<Byte>{

    @Override
    public Byte parse(String expression) {
        try {
            return Byte.parseByte(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse Byte");
        }
    }
    
}
