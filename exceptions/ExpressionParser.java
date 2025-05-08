package expression.exceptions;

import java.util.List;
import java.util.Map;

import expression.*;

public class ExpressionParser implements TripleParser, ListParser {

    private static Map<Character, Character> BRACKETS = Map.of('(', ')', '[', ']', '{', '}');

    @Override
    public TripleExpression parse(String expression) {
        // System.err.println(expression);
        return parse(new StringSource(expression), List.of("x", "y", "z"));
    }

    @Override
    public ListExpression parse(String expression, List<String> variables) {
        // System.err.println(expression); 
        return parse(new StringSource(expression), variables);
    }

    private Parts parse(StringSource source, List<String> variables) {
        Parser parser = new Parser(source, variables);
        Parts expression = parser.parseParts(1);
        parser.skipWhitespaces();
        if (!parser.eof()) {
            throw ParseException.error("There's some extra data after your expression");
        }
        // System.err.println(expression);
        return expression;
    }

    @FunctionalInterface
    private interface Creation {
        Parts create(Parts a, Parts b);
    }

    private static class Parser extends BaseParser {

        private final List<String> variables;
        private final static Map<Integer, Map<String, Creation>> levelConnection = Map.of(
                1, Map.of(
                        "min", (a, b) -> new Min(a, b),
                        "max", (a, b) -> new Max(a, b)
                ),
                2, Map.of(
                        "+", (a, b) -> new CheckedAdd(a, b),
                        "-", (a, b) -> new CheckedSubtract(a, b)
                ),
                3, Map.of(
                        "*", (a, b) -> new CheckedMultiply(a, b),
                        "/", (a, b) -> new CheckedDivide(a, b)
                )
        );

        public Parser(CharSource source, List<String> variables) {
            super(source);
            this.variables = variables;
        }

        private boolean checkLastLetters() {
            return !(between('a', 'z') || between('0', '9'));
        }

        public Parts parseParts(int level) {
            if (level == 4) {
                return parseFactor();
            }
            skipWhitespaces();
            Parts x = parseParts(level + 1);
            skipWhitespaces();
            Map<String, Creation> expected = levelConnection.get(level);
            while (!eof()) {
                boolean flag = true;
                for (Map.Entry<String, Creation> t : expected.entrySet()) {
                    if (take(t.getKey())) {
                        if (level != 1 || checkLastLetters()) {
                            x = t.getValue().create(x, parseParts(level + 1));
                            flag = false;
                            break;
                        } else {
                            reset();
                        }
                    }
                }
                if (flag) {
                    break;
                }
                skipWhitespaces();
            }
            return x;
        }

        private boolean isVariable() {
            return (between('a', 'z') || between('A', 'Z') || test('_') || test('$'));
        }

        private Parts parseFactor() {
            skipWhitespaces();
            if (isVariable()) {
                return parseVariable();
            } else if (between('0', '9')) {
                return parseConst(false);
            } else if (take('-')) {
                if (between('0', '9')) {
                    return parseConst(true);
                } else {
                    return new CheckedNegate(parseFactor());
                }
            }
            for (Map.Entry<Character, Character> br : BRACKETS.entrySet()) {
                if (take(br.getKey())) {
                    Parts x = parseParts(1);
                    expect(br.getValue());
                    return x;
                }
            }

            throw ParseException.error("You wrote wrong data");
        }

        private Const parseConst(boolean isNegative) {
            StringBuilder sb = new StringBuilder();
            if (isNegative) {
                sb.append('-');
            }
            if (take('0')) {
                sb.append('0');
            } else if (between('1', '9')) {
                takeDigits(sb);
            } else {
                throw ParseException.error("It's impossible to parse const");
            }
            try {
                return new Const(Integer.parseInt(sb.toString()));
            } catch (NumberFormatException e) {
                throw ParseException.error("Some problems with const format");
            }
        }

        private void takeDigits(final StringBuilder sb) {
            while (between('0', '9')) {
                sb.append(take());
            }
        }

        private Variable parseVariable() {
            StringBuilder sb = new StringBuilder();
            while (isVariable() || between('0', '9')) {
                sb.append(take());
            }
            if (variables.contains(sb.toString())) {
                Variable variable = new Variable(variables.indexOf(sb.toString()));
                variable.makeName(sb.toString());
                return variable;
            } else {
                throw ParseException.error("The variable " + sb.toString() + " isn't in List");
            }
        }

        private void skipWhitespaces() {
            while (isWhitespace()) {
                take();
            }
        }
    }
}
