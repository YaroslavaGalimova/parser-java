package expression;

import expression.exceptions.CheckedSubtract;
import expression.exceptions.CheckedDivide;

public class Brackets {
    public static boolean check(Operations last, Operations current, boolean isLeft) {
        int last_priority = last.getPriority();
        int current_priority = current.getPriority();
        if (!isLeft && last_priority == current_priority) {
            if ((last.getClass() == Subtract.class || last.getClass() == CheckedSubtract.class) && current_priority == 4) {
                return true;
            }
            if (last.getClass() != current.getClass() && current_priority == 0) {
                return true;
            }
            if (last_priority == 5 && ((last.getClass() == Divide.class || current.getClass() == Divide.class) || 
                                    (last.getClass() == CheckedDivide.class || current.getClass() == CheckedDivide.class))) {
                return true;
            }
        }
        return last_priority > current_priority;
    }
}