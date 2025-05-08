package expression.generic.parsers;

public class ParseInt implements MiniParser<Integer>{

    @Override
    public Integer parse(String expression) {
        try {
            return Integer.parseInt(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse integer");
        }
    }
    
}
