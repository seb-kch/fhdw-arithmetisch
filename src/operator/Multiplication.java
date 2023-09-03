package operator;

import expressions.Expression;

public class Multiplication implements Operator {
    private static Multiplication instance = new Multiplication();

    public static Multiplication getInstance() {
        return instance;
    }

    @Override
    public Integer calculate(Integer arg1, Integer arg2) {
        return arg1 * arg2;
    }
}
