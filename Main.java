package expression;

import expression.exceptions.ParseException;
import expression.generic.GenericTabulator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("You should enter mode and expression");
            return;
        }
        try {
            Object[][][] ans = new GenericTabulator().tabulate(args[0].substring(1), args[1], -2, 2, -2, 2, -2, 2);
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    for (int k = 0; k < 4; ++k) {
                        System.out.print(ans[i][j][k] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("-------------");
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}