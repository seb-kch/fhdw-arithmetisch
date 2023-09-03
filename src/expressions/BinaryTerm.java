package expressions;

import operator.Operator;

public interface BinaryTerm extends Expression {
    public Expression getArg1();
    public Expression getArg2();
    public Operator getOp();
}
