package expression.generic.parsers;

public class ParseDouble implements MiniParser<Double>{

    @Override
    public Double parse(String expression) {
        try {
            return Double.parseDouble(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse double");
        }
    }
    
}
