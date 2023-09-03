package expressions;

import operator.Addition;
import operator.Operator;

/**
 * A term of type S+E
 */
// TODO Complete this class
public abstract class Sum implements BinaryTerm, Expression {
    private Operator op;

    public abstract Expression getArg1();
    public abstract Expression getArg2();
    public Sum(Operator op) {
       super();
       this.op = op;
    }

    public Operator getOp() {
        return op;
    }

    public Integer evaluate() {
        // TODO Implement this method
        return this.op.calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
    }

    public boolean equals(Object obj) {
        return obj instanceof Sum;
    }
}
