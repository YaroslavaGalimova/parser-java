package expression.generic;

public class GenBrackets {
    public static boolean check(GenOperation<?> last, GenOperation<?> current, boolean isLeft) {
        int last_priority = last.getPriority();
        int current_priority = current.getPriority();
        if (!isLeft && last_priority == current_priority) {
            if ((last.getClass() == GenSubtract.class) && current_priority == 4) {
                return true;
            }
            if (last.getClass() != current.getClass() && current_priority == 0) {
                return true;
            }
            if (last_priority == 5 && ((last.getClass() == GenDivide.class || current.getClass() == GenDivide.class))) {
                return true;
            }
        }
        return last_priority > current_priority;
    }
}