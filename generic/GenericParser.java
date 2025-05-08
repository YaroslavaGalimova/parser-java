package expression.generic;

import java.util.Map;

import expression.exceptions.*;
import expression.generic.parsers.MiniParser;

public class GenericParser {

    private static Map<Character, Character> BRACKETS = Map.of('(', ')', '[', ']', '{', '}');

    public <T> GenParts<T> parse(String expression, MiniParser<T> parsik) {
        StringSource source = new StringSource(expression);
        Parser<T> parser = new Parser<T>(source, parsik);
        GenParts<T> result = parser.parseParts(1);
        parser.skipWhitespaces();
        if (!parser.eof()) {
            throw ParseException.error("There's some extra data after your expression");
        }
        return result;
    }

    @FunctionalInterface
    private interface Creation<T> {
        GenParts<T> create(GenParts<T> a, GenParts<T> b);
    }

    private static class Parser<T> extends BaseParser {

        private MiniParser<T> miniParser;

        private final  Map<Integer, Map<String, Creation<T>>> levelConnection = Map.of(
                1, Map.of(
                        "min", (a, b) -> new GenMin<T>(a, b),
                        "max", (a, b) -> new GenMax<T>(a, b)
                ),
                2, Map.of(
                        "+", (a, b) -> new GenAdd<T>(a, b),
                        "-", (a, b) -> new GenSubtract<T>(a, b)
                ),
                3, Map.of(
                        "*", (a, b) -> new GenMultiply<T>(a, b),
                        "/", (a, b) -> new GenDivide<T>(a, b)
                )
        );

        public Parser(CharSource source, MiniParser<T> miniParser) {
            super(source);
            this.miniParser = miniParser;
        }

        private boolean checkLastLetters() {
            return !(between('a', 'z') || between('0', '9'));
        }

        public GenParts<T> parseParts(int level) {
            if (level == 4) {
                return parseFactor();
            }
            skipWhitespaces();
            GenParts<T> x = parseParts(level + 1);
            skipWhitespaces();
            Map<String, Creation<T>> expected = levelConnection.get(level);
            while (!eof()) {
                boolean flag = true;
                for (Map.Entry<String, Creation<T>> t : expected.entrySet()) {
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

        private GenParts<T> parseFactor() {
            skipWhitespaces();
            if (take("count")) {
                return new GenCount<T>(parseFactor());
            } else if (test('x') || test('y') || test('z')) {
                return parseVariable();
            } else if (between('0', '9')) {
                return parseConst(false);
            } else if (take('-')) {
                if (between('0', '9')) {
                    return parseConst(true);
                } else {
                    return new GenNegate<T>(parseFactor());
                }
            }
            for (Map.Entry<Character, Character> br : BRACKETS.entrySet()) {
                if (take(br.getKey())) {
                    GenParts<T> x = parseParts(1);
                    expect(br.getValue());
                    return x;
                }
            }

            throw ParseException.error("You wrote wrong data");
        }

        private GenConst<T> parseConst(boolean isNegative) {
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
            return new GenConst<T>(miniParser.parse(sb.toString()));
        }

        private void takeDigits(final StringBuilder sb) {
            while (between('0', '9')) {
                sb.append(take());
            }
        }

        private GenVariable<T> parseVariable() {
            return new GenVariable<T>(Character.toString(take()));
        }

        private void skipWhitespaces() {
            while (isWhitespace()) {
                take();
            }
        }
    }
}
