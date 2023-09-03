package operator;

import expressions.Expression;

public class Addition implements Operator {
    private static Addition instance = new Addition();

    public static Addition getInstance() {
        return instance;
    }

    @Override
    public Integer calculate(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }
}
