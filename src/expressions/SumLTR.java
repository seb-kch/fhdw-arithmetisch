package expressions;

import operator.Addition;
import operator.Operator;

public class SumLTR extends Sum {
    private Expression arg1;
    private Summand arg2;
    private Operator op;

    public SumLTR(Expression arg1, Summand arg2) {
        super(Addition.getInstance());
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    public Expression getArg1() {
        return null;
    }

    public Expression getArg2() {
        return null;
    }
}
