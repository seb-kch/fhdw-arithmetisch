package expressions;

import operator.Operator;

public abstract class BinaryExpression {
    private Expression arg1;
    private Expression arg2;
    private Operator op;

    public BinaryExpression(Operator op, Expression arg1, Expression arg2) {
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Expression getArg1() {
        return arg1;
    }

    public Expression getArg2() {
        return arg2;
    }

    public Operator getOp() {
        return this.op;
    }
}
