package expression.generic.parsers;

public class ParseBoolean implements MiniParser<Boolean>{

    @Override
    public Boolean parse(String expression) {
        try {
            return Integer.parseInt(expression) != 0;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse Boolean");
        }
    }
    
}
